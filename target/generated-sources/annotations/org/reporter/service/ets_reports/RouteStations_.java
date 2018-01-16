package org.reporter.service.ets_reports;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.reporter.service.ets_reports.RouteStationsPK;
import org.reporter.service.ets_reports.Routes;
import org.reporter.service.ets_reports.Stations;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(RouteStations.class)
public class RouteStations_ { 

    public static volatile SingularAttribute<RouteStations, Routes> routes;
    public static volatile SingularAttribute<RouteStations, Integer> lineNo;
    public static volatile SingularAttribute<RouteStations, Stations> stations;
    public static volatile SingularAttribute<RouteStations, RouteStationsPK> routeStationsPK;
    public static volatile SingularAttribute<RouteStations, Character> status;

}