package org.reporter.service.ets_reports;


import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.subject.Subject;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.reporter.service.ets_reports.util.Constants;
import org.reporter.service.ets_reports.util.JsfUtil;
import org.reporter.service.ets_reports.util.Language;
import org.reporter.service.ets_reports.util.JsfUtil.PersistAction;

@Named("dashboardController")
@SessionScoped
public class DashboardController implements Serializable {
    
    @EJB
    private org.reporter.service.ets_reports.ActivityLogsFacade activityFacade;
    @EJB
    private org.reporter.service.ets_reports.AlertsFacade alertsFacade;
    @EJB
    private StationsFacade stationsFacade;
    
    private List<ActivityLogs> items = null;
    private ActivityLogs selected;
    private List<Alerts> alerts = null;
    private Alerts  selectedAlerts=null;

    private StreamedContent pdfFileLineChart;
    private StreamedContent pdfFilePieChart;
    
    /*Dashboard inputs*/
    private List<Stations> stationsList;
    private Stations selectedStation;
    private String selectedLanguage;
    private Date startDate;
    private Date endDate;
    private String currentPage = "Dashboard";
    
    private Date defaultStartDate;
    private Date defaultEndDate;
    private Long defaultStationId;
    private String defaultLanguage = "en";
    private Date endMaxDate;
    
    private boolean startDateChanged;
    private boolean endDateChanged;
    private boolean stationIdChanged;
    private boolean languageChanged;
    
    public DashboardController() {}

    @PostConstruct
    public void init(){
        endMaxDate = new Date();
        
        //default all stations
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.dformat);

        //default startDate and endDate
        endDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.add(Calendar.HOUR, -24);
        startDate = calendar.getTime();
        
        //put in sessionMap
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constants.STATION_ID, new Long(-1));
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constants.START_DATE, startDate);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constants.END_DATE, endDate);

        defaultStartDate = startDate;
        defaultEndDate = endDate; 
        defaultStationId = new Long(-1);
        
        System.out.println("Stations: ALL(-1). StartPeriod: " + sdf.format(startDate) + " EndPeriod: " + sdf.format(endDate));
        
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("resources/images/csv.png");
        pdfFileLineChart = new DefaultStreamedContent(stream, "image/jpg", "csv.png");
        
        pdfFilePieChart = null;
    }
    
    
    public void onMetroStationClick(){
        String stationIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("stationId");
        if(stationIdStr == null || stationIdStr.trim().isEmpty()){
            return;
        }
        Integer stationId = Integer.parseInt(stationIdStr);
        selectedStation = stationsFacade.find(stationId.longValue());
        System.out.println("Redirecting to: " + stationId);
        
        try{
            FacesContext fCtx = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
            String sessionId = session.getId();
            
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/index.xhtml" + ";jsessionid="+sessionId);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
 
    
    /**
     * On language selected event
     * @param event 
     */
    public void onLanguageSelected(AjaxBehaviorEvent event){
        SelectOneMenu som = (SelectOneMenu)event.getSource();
        selectedLanguage = som.getValue().toString();
        if(selectedLanguage!=null && !selectedLanguage.equals(defaultLanguage)){
            languageChanged = true;
            System.out.println("Language changed!");
        }
    }
    /**
     * On station selected event
     * @param event 
     */
    public void onStationSelected(AjaxBehaviorEvent event){
        SelectOneMenu som = (SelectOneMenu)event.getSource();
        selectedStation = (Stations)som.getValue();
        if(selectedStation==null){
            stationIdChanged = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constants.STATION_ID, new Long(-1));
        }else{
            if(!defaultStationId.equals(selectedStation.getStationId())){
                stationIdChanged = true;
                System.out.println("STATION ID CHANGED!");
            }
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constants.STATION_ID, selectedStation.getStationId());
        }
    }
    public void onStartDateChanged(SelectEvent event){
        if(!defaultStartDate.equals((Date)event.getObject())){
            startDateChanged = true;
        }
    }
    public void onEndDateChanged(SelectEvent event){
        if(!defaultEndDate.equals((Date)event.getObject())){
            endDateChanged = true;
            if(startDate.after(endDate)){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(endDate);
                calendar.add(Calendar.HOUR, -24);
                startDate = calendar.getTime();
            }
        }
    }
    /**
     * Check if startDate or endDate changed from original
     * @return 
     */
    public boolean filtersChanged(){
        if(startDateChanged || endDateChanged || stationIdChanged || languageChanged){
            return true;
        }
        return false;
    }
    public void applyEtsFilters(){
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.dformat);
        Long stationID = selectedStation!=null?selectedStation.getStationId():new Long(-1);
        
        System.out.println("Filters: Station ID: " + stationID + " startDate: " + sdf.format(startDate) + " endDate: " + sdf.format(endDate));
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constants.STATION_ID, stationID);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constants.START_DATE, startDate);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constants.END_DATE, endDate);
        
        defaultStartDate = startDate;
        defaultEndDate = endDate; 
        defaultLanguage = selectedLanguage;
        
        RequestContext.getCurrentInstance().execute("location.reload()");
        startDateChanged = false;
        endDateChanged = false;
        stationIdChanged = false;
        languageChanged = false;
        
        endMaxDate = new Date();
    }
    
    public ActivityLogs prepareCreateActivityLogs() {
        selected = new ActivityLogs();
        initializeEmbeddableKey();
        return selected;
    }
    public void createActivityLogs() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ActivityLogsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public void updateActivityLogs() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ActivityLogsUpdated"));
    }
    public void destroyActivityLogs() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ActivityLogsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getActivityLogsFacade().edit(selected);
                } else {
                    getActivityLogsFacade().remove(selected);
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
    
    public ActivityLogs getActivityLogs(java.lang.Integer id) {
        return getActivityLogsFacade().find(id);
    }
    public List<ActivityLogs> getItemsAvailableSelectMany() {
        return getActivityLogsFacade().findAll();
    }
    public List<ActivityLogs> getItemsAvailableSelectOne() {
        return getActivityLogsFacade().findAll();
    }
    public Alerts getAlerts(java.lang.Integer id) {
        return getAlertsFacade().find(id);
    }
    public List<Alerts> getAlertsAvailableSelectMany() {
        return getAlertsFacade().findAll();
    }
    public List<Alerts> getAlertsAvailableSelectOne() {
        return getAlertsFacade().findAll();
    }
    public StationsFacade getStationsFacade() {
        return stationsFacade;
    }
    public void setStationsFacade(StationsFacade stationsFacade) {
        this.stationsFacade = stationsFacade;
    }
    public List<Stations> getStationsList() {
        if(stationsList==null){
            stationsList = stationsFacade.findAll();
            stationsList.sort(Comparator.comparing(Stations::getDisplayName));
        }
        return stationsList;
    }
    public void setStationsList(List<Stations> stationsList) {
        this.stationsList = stationsList;
    }
    public Stations getSelectedStation() {
        return selectedStation;
    }
    public void setSelectedStation(Stations selectedStation) {
        this.selectedStation = selectedStation;
    }
    public ActivityLogs getSelectedActivityLogs() {
        return selected;
    }
    /**
     * @param alerts the alerts to set
     */
    public void setAlerts(List<Alerts> alerts) {
        this.alerts = alerts;
    }
    /**
     * @return the selectedAlerts
     */
    public Alerts getSelectedAlerts() {
        return selectedAlerts;
    }
    /**
     * @param selectedAlerts the selectedAlerts to set
     */
    public void setSelectedAlerts(Alerts selectedAlerts) {
        this.selectedAlerts = selectedAlerts;
    }
    public void setSelectedActivityLogs(ActivityLogs selected) {
        this.selected = selected;
    }
    protected void setEmbeddableKeys() {
    }
    protected void initializeEmbeddableKey() {
    }
    public List<ActivityLogs> getItems() {
        if (items == null) {
            items = getActivityLogsFacade().findAll();
        }
        return items;
    }
    public List<Alerts> getAlerts() {
        if (alerts == null) {
            alerts = getAlertsFacade().findAll();
        }
        return alerts;
    }
    private ActivityLogsFacade getActivityLogsFacade() {
        return activityFacade;
    }
    private AlertsFacade getAlertsFacade() {
        return alertsFacade;
    }
    public ActivityLogsFacade getActivityFacade() {
        return activityFacade;
    }
    public void setActivityFacade(ActivityLogsFacade activityFacade) {
        this.activityFacade = activityFacade;
    }
    public ActivityLogs getSelected() {
        return selected;
    }
    public void setSelected(ActivityLogs selected) {
        this.selected = selected;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }
    public void navigate(){
        String pageName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pageName");
        if(pageName!=null){
            setCurrentPage(pageName);
        }
    }
    public StreamedContent getPdfFileLineChart() {
        return pdfFileLineChart;
    }
    public void setPdfFileLineChart(StreamedContent pdfFileLineChart) {
        this.pdfFileLineChart = pdfFileLineChart;
    }
    public StreamedContent getPdfFilePieChart() {
        return pdfFilePieChart;
    }
    public void setPdfFilePieChart(StreamedContent pdfFilePieChart) {
        this.pdfFilePieChart = pdfFilePieChart;
    }
    /**
     * Returns the current user's username
     * @return 
     */
    public String getCurrentUserUsername(){
        Subject subject = org.apache.shiro.SecurityUtils.getSubject();
        if(subject!=null){
            return subject.getPrincipal().toString();
        }else{
            return "User";
        }
    }
    public boolean isUserAdmin(){
        Subject subject = org.apache.shiro.SecurityUtils.getSubject();
        if(subject!=null){
            if(subject.hasRole("Admin")){
                return true;
            }
        }
        return false;
    }
    public boolean isUserAdminOrManager(){
        Subject subject = org.apache.shiro.SecurityUtils.getSubject();
        if(subject!=null){
            if(subject.hasRole("Admin") || subject.hasRole("TrafficManager")){
                return true;
            }
        }
        return false;
    }
    public Date getEndMaxDate() {
        return endMaxDate;
    }
    public void setEndMaxDate(Date endMaxDate) {
        this.endMaxDate = endMaxDate;
    }
    
    
    @FacesConverter(forClass = ActivityLogs.class)
    public static class ActivityLogsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActivityLogsController controller = (ActivityLogsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "activityLogsController");
            return controller.getActivityLogs(getKey(value));
        }
     
        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ActivityLogs) {
                ActivityLogs o = (ActivityLogs) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ActivityLogs.class.getName()});
                return null;
            }
        }

    }
    @FacesConverter(forClass = Alerts.class)
    public static class AlertsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AlertsController controller = (AlertsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "alertsController");
            return controller.getAlerts(getKey(value));
        }
     
        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Alerts) {
                Alerts o = (Alerts) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Alerts.class.getName()});
                return null;
            }
        }

    }

}
