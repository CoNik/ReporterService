package org.reporter.service.ets_reports.analysis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericType;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SlideEndEvent;
import org.reporter.service.ets_reports.clients.StationPositionClient;
import org.reporter.service.ets_reports.pattern.ValueOnChart;
import org.reporter.service.ets_reports.pattern.ValueOnMap;

/**
 *
 * @author constantinn
 */
@Named("dataAnalysisController")
@ViewScoped
public class DataAnalysisController implements Serializable{
    
    //Day selected from ets-da-daysPanel. Value ranges from [0,7]
    //Select many checkbox - these values can be combined
    private Integer selectedDay;
    //If selected => nominal; else => nenominal
    private boolean nominal;
    //If selected => smartCard; else => mobile
    private boolean smartCard;
    //If selected => in; else => out
    private boolean in;
    
    //Selected value to display. Value ranges from [0,5]
    private Integer selectedValue;
    
    //Selected time from slider
    private Date selectedTime;
    private int selectedTimeValue;
    
    //Used to render chart panel
    private boolean metroStationSelected;
    
    private String selectedStationName;
    
    
    public DataAnalysisController(){
        //Default selectedTime = 00:00
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        selectedTime = calendar.getTime();
        System.out.println("Selected time: " + selectedTime.toString());
    }

    @PostConstruct
    public void init(){
        getCurrentDayOfWeek();
    }
    
    
    //Events
    public void onDaySelected(){
        System.out.println("Day selected: " + selectedDay);
    }
    public void onValueSelected(){
        System.out.println("Value selected: " + selectedValue);
    }
    public void onSlideEnd(SlideEndEvent see){
        selectedTimeValue = see.getValue();
        selectedTime = getSelectedDateFromValue(selectedTimeValue);
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        String BASE_URI = url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath() + "/";
        
        StationPositionClient stationPositionClient = new StationPositionClient(BASE_URI);
        int nominalInt = nominal?1:0;
        int smartCardInt = smartCard?1:0;
        int inInt = in?1:0;
        
        if(selectedValue!=null){
            List<ValueOnMap> stationsData = stationPositionClient.getPositionsOnMap_JSON(
                    Integer.toString(selectedDay), Integer.toString(selectedTimeValue), 
                    Integer.toString(nominalInt), Integer.toString(smartCardInt), 
                    Integer.toString(inInt), Integer.toString(selectedValue));
            stationPositionClient.close();
            try{
                ObjectMapper objectMapper = new ObjectMapper();
                String stationsDataJSON = objectMapper.writeValueAsString(stationsData);
                RequestContext.getCurrentInstance().execute("initStationData('" + stationsDataJSON +"')");
                
            }catch(JsonProcessingException jpe){
                jpe.printStackTrace();
            }
            
        }else{
            //show user message to select value
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, 
                    "No value has been selected", "Please select a value to show");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        
    }
    
    /**
     * Remote command called from ets-data-analysis.js when a station is clicked
     * This method will call onStationClick from ets-data-analysis.js with station data.
     */
    public void onMetroStationClickedRC(){
        if(selectedValue==null){
            System.out.println("No value selected");
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, 
                    "No value has been selected", "Please select a value to show");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            RequestContext.getCurrentInstance().update("growl");
            return;
        }
        
        metroStationSelected = true;
        
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        String BASE_URI = url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath() + "/";
        String stationIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("stationId");
        this.selectedStationName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("stationName");
        

        if(stationIdStr!=null && !stationIdStr.trim().isEmpty()){
            int nominalInt = nominal?1:0;
            int smartCardInt = smartCard?1:0;
            int inInt = in?1:0;
        
            StationPositionClient stationPositionClient = new StationPositionClient(BASE_URI);
            List<ValueOnChart> stationData = stationPositionClient.getPositionsOnChart_JSON(Integer.toString(selectedDay), 
                    stationIdStr, Integer.toString(nominalInt), Integer.toString(smartCardInt),
                    Integer.toString(inInt), Integer.toString(selectedValue));
            stationPositionClient.close();
            
            //Call js function to populate chart with data
            try{
                ObjectMapper objectMapper = new ObjectMapper();
                String stationDataJSON = objectMapper.writeValueAsString(stationData);
                RequestContext.getCurrentInstance().execute("onStationClick('" + stationDataJSON +"')");
            }catch(JsonProcessingException jpe){
                jpe.printStackTrace();
            }
            
        }
    }
    
    
    //Utility methods
    /**
     * Returns a value [0,6] to predefine selectedDay
     * @return 
     */
    public int getCurrentDayOfWeek(){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        selectedDay = calendar.get(Calendar.DAY_OF_WEEK)-2;
        System.out.println("Selected day: " + selectedDay);
        return selectedDay;
    }
    public Date getSelectedDateFromValue(int selectedValue){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.MINUTE, selectedValue);
        return calendar.getTime();
    }
    public String getSelectedValueDisplayName(){
        if(selectedValue==null){
            return "";
        }
        switch(selectedValue){
            case 0:
                return "number of passengers";
            case 1:
                return "duration";
            case 2:
                return "fraudulents";
            case 3:
                return "kiosk actions";
            case 4:
                return "OK face recognitions";
            case 5:
                return "NOT OK face recognitions";
            case 6:
                return "ERROR face recognitions";
        }
        return "";
    }
    public void setSelectedValueDisplayName(String val){
        //do nothing
    }
    
    public Integer getSelectedDay() {
        return selectedDay;
    }
    public void setSelectedDay(Integer selectedDay) {
        this.selectedDay = selectedDay;
    }
    public boolean isNominal() {
        return nominal;
    }
    public void setNominal(boolean nominal) {
        this.nominal = nominal;
    }
    public boolean isSmartCard() {
        return smartCard;
    }
    public void setSmartCard(boolean smartCard) {
        this.smartCard = smartCard;
    }
    public boolean isIn() {
        return in;
    }
    public void setIn(boolean in) {
        this.in = in;
    }
    public Integer getSelectedValue() {
        return selectedValue;
    }
    public void setSelectedValue(Integer selectedValue) {
        this.selectedValue = selectedValue;
    }
    public int getSelectedTimeValue() {
        return selectedTimeValue;
    }
    public void setSelectedTimeValue(int selectedTimeValue) {
        this.selectedTimeValue = selectedTimeValue;
    }
    public Date getSelectedTime() {
        return selectedTime;
    }
    public void setSelectedTime(Date selectedTime) {
        this.selectedTime = selectedTime;
    }
    public boolean isMetroStationSelected() {
        return metroStationSelected;
    }
    public void setMetroStationSelected(boolean metroStationSelected) {
        this.metroStationSelected = metroStationSelected;
    }
    public String getSelectedStationName() {
        return selectedStationName;
    }
    public void setSelectedStationName(String selectedStationName) {
        this.selectedStationName = selectedStationName;
    }
    
    
    
}
