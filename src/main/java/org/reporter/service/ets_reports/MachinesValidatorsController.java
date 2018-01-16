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

@Named("machinesValidatorsController")
@SessionScoped
public class MachinesValidatorsController implements Serializable {

    @EJB
    private org.reporter.service.ets_reports.MachinesValidatorsFacade ejbFacade;
    private List<MachinesValidators> items = null;
    private MachinesValidators selected;

    public MachinesValidatorsController() {
    }

    public MachinesValidators getSelected() {
        return selected;
    }

    public void setSelected(MachinesValidators selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setMachinesValidatorsPK(new org.reporter.service.ets_reports.MachinesValidatorsPK());
    }

    private MachinesValidatorsFacade getFacade() {
        return ejbFacade;
    }

    public MachinesValidators prepareCreate() {
        selected = new MachinesValidators();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MachinesValidatorsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MachinesValidatorsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MachinesValidatorsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<MachinesValidators> getItems() {
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

    public MachinesValidators getMachinesValidators(org.reporter.service.ets_reports.MachinesValidatorsPK id) {
        return getFacade().find(id);
    }

    public List<MachinesValidators> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<MachinesValidators> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = MachinesValidators.class)
    public static class MachinesValidatorsControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MachinesValidatorsController controller = (MachinesValidatorsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "machinesValidatorsController");
            return controller.getMachinesValidators(getKey(value));
        }

        org.reporter.service.ets_reports.MachinesValidatorsPK getKey(String value) {
            org.reporter.service.ets_reports.MachinesValidatorsPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.reporter.service.ets_reports.MachinesValidatorsPK();
            key.setMachineId(Integer.parseInt(values[0]));
            key.setValidatorCode(values[1]);
            return key;
        }

        String getStringKey(org.reporter.service.ets_reports.MachinesValidatorsPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getMachineId());
            sb.append(SEPARATOR);
            sb.append(value.getValidatorCode());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof MachinesValidators) {
                MachinesValidators o = (MachinesValidators) object;
                return getStringKey(o.getMachinesValidatorsPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), MachinesValidators.class.getName()});
                return null;
            }
        }

    }

}
