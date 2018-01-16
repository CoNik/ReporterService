package org.reporter.service.ets_reports;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.reporter.service.ets_reports.Routes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(TransportTypes.class)
public class TransportTypes_ { 

    public static volatile SingularAttribute<TransportTypes, String> transportTypeDescription;
    public static volatile CollectionAttribute<TransportTypes, Routes> routesCollection;
    public static volatile SingularAttribute<TransportTypes, Short> transportTypeID;
    public static volatile SingularAttribute<TransportTypes, String> status;

}