package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;

import org.reporter.service.ets_reports.util.JsfUtil;
import org.reporter.service.ets_reports.util.JsfUtil.PersistAction;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("routeStationsController")
@SessionScoped
public class RouteStationsController implements Serializable {

    @EJB
    private org.reporter.service.ets_reports.RouteStationsFacade ejbFacade;
    private List<RouteStations> items = null;
    private RouteStations selected;

    public RouteStationsController() {
    }

    public RouteStations getSelected() {
        return selected;
    }

    public void setSelected(RouteStations selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getRouteStationsPK().setRouteCode(selected.getRoutes().getRouteCode());
        selected.getRouteStationsPK().setStationId(selected.getStations().getStationId());
    }

    protected void initializeEmbeddableKey() {
        selected.setRouteStationsPK(new org.reporter.service.ets_reports.RouteStationsPK());
    }

    private RouteStationsFacade getFacade() {
        return ejbFacade;
    }

    public RouteStations prepareCreate() {
        selected = new RouteStations();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RouteStationsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RouteStationsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RouteStationsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RouteStations> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public RouteStations getRouteStations(org.reporter.service.ets_reports.RouteStationsPK id) {
        return getFacade().find(id);
    }

    public List<RouteStations> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RouteStations> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RouteStations.class)
    public static class RouteStationsControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RouteStationsController controller = (RouteStationsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "routeStationsController");
            return controller.getRouteStations(getKey(value));
        }

        org.reporter.service.ets_reports.RouteStationsPK getKey(String value) {
            org.reporter.service.ets_reports.RouteStationsPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.reporter.service.ets_reports.RouteStationsPK();
            key.setRouteCode(values[0]);
            key.setStationId(Long.parseLong(values[1]));
            return key;
        }

        String getStringKey(org.reporter.service.ets_reports.RouteStationsPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getRouteCode());
            sb.append(SEPARATOR);
            sb.append(value.getStationId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof RouteStations) {
                RouteStations o = (RouteStations) object;
                return getStringKey(o.getRouteStationsPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RouteStations.class.getName()});
                return null;
            }
        }

    }

}
