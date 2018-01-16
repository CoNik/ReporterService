package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.reporter.service.ets_reports.util.Constants;
import org.reporter.service.ets_reports.util.JsfUtil;
import org.reporter.service.ets_reports.util.TimeSeries;
import org.reporter.service.ets_reports.util.JsfUtil.PersistAction;

@Named("cardActivityLogsController")
@RequestScoped
public class CardActivityLogsController implements Serializable {

    @EJB
    private org.reporter.service.ets_reports.CardActivityLogsFacade ejbFacade;
    private List<CardActivityLogs> items = null;
    private CardActivityLogs selected;

    private Date startDate;
    private Date endDate;
    private Long stationId;

    private LineChartModel dateModel;
    private final static String dformat = Constants.dformat;
    private boolean noChartData;

    public CardActivityLogsController() {
        startDate = Constants.defaultStartDate;
        endDate = Constants.defaultEndDate;
        stationId = Constants.defaultStationId;

        stationId = Constants.defaultStationId;
        String sfrom = "2017-10-18 00:00:00";
        String sto = "2017-10-20 23:59:59";

        DateFormat format = new SimpleDateFormat(dformat);
        startDate = new Date();
        startDate.setTime(startDate.getTime() - 3600000);
        endDate = new Date();

        try {
            startDate = format.parse(sfrom);
            endDate = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(CardActivityLogsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @PostConstruct
    public void init() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        if (sessionMap != null && sessionMap.containsKey(Constants.START_DATE) && sessionMap.containsKey(Constants.END_DATE)
                && sessionMap.containsKey(Constants.STATION_ID)) {
            startDate = (Date) sessionMap.get(Constants.START_DATE);
            endDate = (Date) sessionMap.get(Constants.END_DATE);
            stationId = (Long) sessionMap.get(Constants.STATION_ID);
            if (items != null) {
                items.clear();
            }
            getItems();
        } else {
            System.out.println("Could not initialize items using session attributes");
        }
        createDateModel();
    }

    public LineChartModel getDateModel() {
        return dateModel;
    }

    private void createDateModel() {
//        String lformat = "dd HH:mm:ss";
        DateFormat format = new SimpleDateFormat(Constants.CHART_DATE_FOMART);
        List<NoActivitiesInPeriod> lnap = getTimeSeries(1000l, startDate, endDate);
        if (lnap == null || lnap.size() < 2) {
            noChartData = true;
        }
        dateModel = new LineChartModel();
        if (lnap != null && lnap.size() > 2) {

            LineChartSeries series1 = new LineChartSeries();

            series1.setLabel("Activities");
            for (NoActivitiesInPeriod nap : lnap) {
                series1.set(format.format(nap.getStartDate()), nap.getNoActivities());
            }
            //series1.set("2014-01-01", 51);

            dateModel.addSeries(series1);
        }
        dateModel.setTitle("Zoom for Details");
        dateModel.setZoom(true);
        dateModel.setShadow(false);
        dateModel.setAnimate(Constants.ANIMATE_CHART);
        dateModel.setSeriesColors(Constants.CHART_SERIES_COLORS);
        dateModel.getAxis(AxisType.Y).setLabel("No ");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-30);
        axis.setMax("20 23:59:59");
        axis.setTickFormat(Constants.CHART_TICK_FORMAT);

        dateModel.getAxes().put(AxisType.X, axis);

    }

    public CardActivityLogs getSelected() {
        return selected;
    }

    public void setSelected(CardActivityLogs selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CardActivityLogsFacade getFacade() {
        return ejbFacade;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the stationId
     */
    public Long getStationId() {
        return stationId;
    }

    /**
     * @param stationId the stationId to set
     */
    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public CardActivityLogs prepareCreate() {
        selected = new CardActivityLogs();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CardActivityLogsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CardActivityLogsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CardActivityLogsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CardActivityLogs> getItems() {
        if (items == null || items.isEmpty()) {
            if ((this.stationId == null || this.stationId < 0) && (this.startDate == null) && (this.endDate == null)) {
                items = getFacade().findAll();
            } else {
                if ((this.stationId == null || this.stationId < 0)) {
                    items = getItems(startDate, endDate);
                } else {
                    items = getItems(stationId, startDate, endDate);
                }
            }
        }
        return items;
    }

    public List<CardActivityLogs> getItems(Date startDate, Date endDate) {
        if (items == null) {
            EntityManager em = getFacade().getEntityManager();
            Query q = em.createNamedQuery("CardActivityLogs.findByPeriod", CardActivityLogs.class);
            try {
                items = (List<CardActivityLogs>) q.setParameter("startDate", startDate).
                        setParameter("endDate", endDate).
                        getResultList();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        return items;
    }

    public List<CardActivityLogs> getItems(String stationName, Date startDate, Date endDate) {
        if (items == null) {
            EntityManager em = getFacade().getEntityManager();
            Query q = em.createNamedQuery("CardActivityLogs.findByPeriodAndStationId", CardActivityLogs.class);
            try {
                items = (List<CardActivityLogs>) q.setParameter("startDate", startDate).
                        setParameter("endDate", endDate).
                        setParameter("stationId", stationName).
                        getResultList();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        return items;
    }

    public List<CardActivityLogs> getItems(Long stationId, Date startDate, Date endDate) {
        if (items == null) {
            EntityManager em = getFacade().getEntityManager();
            Query q = em.createNamedQuery("CardActivityLogs.findByPeriodAndStation", CardActivityLogs.class);
            try {
                items = (List<CardActivityLogs>) q.setParameter("startDate", startDate).
                        setParameter("endDate", endDate).
                        setParameter("stationName", stationId).
                        getResultList();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        return items;
    }

    private List<NoActivitiesInPeriod> getTimeSeries(Long noElements, Date dfrom, Date dto) {
        long noItems;

        List<NoActivitiesInPeriod> lnoap = null;
        // first build the time values
        List<CardActivityLogs> lag = getItems(dfrom, dto);
        if (lag != null) {
            noItems = lag.size() > noElements ? noElements : lag.size();

            lnoap = TimeSeries.getInitialTimeSeries(noItems, dfrom, dto);
            // now for each entry count values with sendDate in the given interval
            for (CardActivityLogs al : lag) {
                for (NoActivitiesInPeriod ap : lnoap) {
                    if ((al.getSentDate().after(ap.getStartDate())) && (al.getSentDate().before(ap.getEndDate()))) {
                        ap.setNoActivities(ap.getNoActivities() + 1l);
                        break;
                    }
                }
            }
        }
        return lnoap;
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

    public CardActivityLogs getCardActivityLogs(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CardActivityLogs> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CardActivityLogs> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public boolean isNoChartData() {
        return noChartData;
    }

    public void setNoChartData(boolean noChartData) {
        this.noChartData = noChartData;
    }

    @FacesConverter(forClass = CardActivityLogs.class)
    public static class CardActivityLogsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CardActivityLogsController controller = (CardActivityLogsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cardActivityLogsController");
            return controller.getCardActivityLogs(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CardActivityLogs) {
                CardActivityLogs o = (CardActivityLogs) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CardActivityLogs.class.getName()});
                return null;
            }
        }

    }

}
