package org.reporter.service.ets_reports;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.reporter.service.ets_reports.RouteStations;
import org.reporter.service.ets_reports.Validators;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(Stations.class)
public class Stations_ { 

    public static volatile CollectionAttribute<Stations, Validators> validatorsCollection;
    public static volatile SingularAttribute<Stations, String> stationDescription;
    public static volatile SingularAttribute<Stations, String> displayName;
    public static volatile CollectionAttribute<Stations, RouteStations> routeStationsCollection;
    public static volatile SingularAttribute<Stations, Long> stationId;
    public static volatile SingularAttribute<Stations, String> createDate;
    public static volatile SingularAttribute<Stations, Short> status;

}