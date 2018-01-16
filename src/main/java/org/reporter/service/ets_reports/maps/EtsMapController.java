package org.reporter.service.ets_reports.maps;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.reporter.service.ets_reports.DashboardInfo;

/**
 *
 * @author constantinn
 */
@Named("etsMapController")
@ViewScoped
public class EtsMapController implements Serializable{

    private DashboardInfo dashboardInfo;
    
    @PostConstruct
    public void init(){
        dashboardInfo = new DashboardInfo();
    }
    
    public void onMetroStationHover(){
        String stationIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("stationId");
        if(stationIdStr == null || stationIdStr.trim().isEmpty()){
            return;
        }
        Integer stationId = Integer.parseInt(stationIdStr);
        
        //TODO: Get information for station with id: stationId
        
        dashboardInfo = new DashboardInfo();
        System.out.println("Showing info for station: " + stationId);
        try{
            RequestContext.getCurrentInstance().update("mapForm:stationInfoPanel");
        }catch(Exception ex){}
    }
    
    

    public DashboardInfo getDashboardInfo() {
        return dashboardInfo;
    }

    public void setDashboardInfo(DashboardInfo dashboardInfo) {
        this.dashboardInfo = dashboardInfo;
    }
    
    
    
}
