/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author constantinn
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.reporter.service.ets_reports.service.ActivitiesFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.ActivityLogsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.AlertLogsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.AlertsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.CITReportsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.CardActivityLogsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.CardTypesFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.CardsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.CustomerAdressFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.CustomerCardsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.CustomersFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.DashboardInfoTFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.DataAnalyserFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.DeviceStateHistoryFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.DevicesFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.DirectionFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.FraudStationsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.FraudTypesFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.KioskItemsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.LocationWorkFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.MachinesFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.MachinesValidatorsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.PositionsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.RoutePricesFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.RouteStationsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.RoutesFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.RulesRouteFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.StationPositionsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.StationsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.SysdiagramsFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.TransportTypesFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.UsersFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.VTripTimeFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.ValidatorTypesFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.ValidatorsActivityFacadeREST.class);
        resources.add(org.reporter.service.ets_reports.service.ValidatorsFacadeREST.class);
    }
    
}
