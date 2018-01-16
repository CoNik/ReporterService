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

@Named("routePricesController")
@SessionScoped
public class RoutePricesController implements Serializable {

    @EJB
    private org.reporter.service.ets_reports.RoutePricesFacade ejbFacade;
    private List<RoutePrices> items = null;
    private RoutePrices selected;

    public RoutePricesController() {
    }

    public RoutePrices getSelected() {
        return selected;
    }

    public void setSelected(RoutePrices selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getRoutePricesPK().setCardTypeCode(selected.getCardTypes().getCardTypeCode());
        selected.getRoutePricesPK().setRouteCode(selected.getRoutes().getRouteCode());
    }

    protected void initializeEmbeddableKey() {
        selected.setRoutePricesPK(new org.reporter.service.ets_reports.RoutePricesPK());
    }

    private RoutePricesFacade getFacade() {
        return ejbFacade;
    }

    public RoutePrices prepareCreate() {
        selected = new RoutePrices();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RoutePricesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RoutePricesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RoutePricesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RoutePrices> getItems() {
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

    public RoutePrices getRoutePrices(org.reporter.service.ets_reports.RoutePricesPK id) {
        return getFacade().find(id);
    }

    public List<RoutePrices> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RoutePrices> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RoutePrices.class)
    public static class RoutePricesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RoutePricesController controller = (RoutePricesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "routePricesController");
            return controller.getRoutePrices(getKey(value));
        }

        org.reporter.service.ets_reports.RoutePricesPK getKey(String value) {
            org.reporter.service.ets_reports.RoutePricesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.reporter.service.ets_reports.RoutePricesPK();
            key.setRouteCode(values[0]);
            key.setCardTypeCode(values[1]);
            return key;
        }

        String getStringKey(org.reporter.service.ets_reports.RoutePricesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getRouteCode());
            sb.append(SEPARATOR);
            sb.append(value.getCardTypeCode());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof RoutePrices) {
                RoutePrices o = (RoutePrices) object;
                return getStringKey(o.getRoutePricesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RoutePrices.class.getName()});
                return null;
            }
        }

    }

}
