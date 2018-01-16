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

@Named("validatorsController")
@SessionScoped
public class ValidatorsController implements Serializable {

    @EJB
    private org.reporter.service.ets_reports.ValidatorsFacade ejbFacade;
    private List<Validators> items = null;
    private Validators selected;

    public ValidatorsController() {
    }

    public Validators getSelected() {
        return selected;
    }

    public void setSelected(Validators selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setValidatorsPK(new org.reporter.service.ets_reports.ValidatorsPK());
    }

    private ValidatorsFacade getFacade() {
        return ejbFacade;
    }

    public Validators prepareCreate() {
        selected = new Validators();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ValidatorsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ValidatorsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ValidatorsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Validators> getItems() {
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

    public Validators getValidators(org.reporter.service.ets_reports.ValidatorsPK id) {
        return getFacade().find(id);
    }

    public List<Validators> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Validators> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Validators.class)
    public static class ValidatorsControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ValidatorsController controller = (ValidatorsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "validatorsController");
            return controller.getValidators(getKey(value));
        }

        org.reporter.service.ets_reports.ValidatorsPK getKey(String value) {
            org.reporter.service.ets_reports.ValidatorsPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.reporter.service.ets_reports.ValidatorsPK();
            key.setValidatorCode(values[0]);
            key.setIPAdress(values[1]);
            return key;
        }

        String getStringKey(org.reporter.service.ets_reports.ValidatorsPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getValidatorCode());
            sb.append(SEPARATOR);
            sb.append(value.getIPAdress());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Validators) {
                Validators o = (Validators) object;
                return getStringKey(o.getValidatorsPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Validators.class.getName()});
                return null;
            }
        }

    }

}
