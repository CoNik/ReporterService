package org.reporter.service.ets_reports;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.reporter.service.ets_reports.RoutePrices;
import org.reporter.service.ets_reports.RouteStations;
import org.reporter.service.ets_reports.TransportTypes;
import org.reporter.service.ets_reports.Validators;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(Routes.class)
public class Routes_ { 

    public static volatile SingularAttribute<Routes, String> routeCode;
    public static volatile SingularAttribute<Routes, Date> routeEndDate;
    public static volatile CollectionAttribute<Routes, Validators> validatorsCollection;
    public static volatile SingularAttribute<Routes, Character> specialRoute;
    public static volatile SingularAttribute<Routes, Date> routeStartDate;
    public static volatile CollectionAttribute<Routes, RouteStations> routeStationsCollection;
    public static volatile SingularAttribute<Routes, String> routeDescription;
    public static volatile SingularAttribute<Routes, Character> status;
    public static volatile SingularAttribute<Routes, Date> createDate;
    public static volatile CollectionAttribute<Routes, RoutePrices> routePricesCollection;
    public static volatile SingularAttribute<Routes, TransportTypes> transportTypeId;

}