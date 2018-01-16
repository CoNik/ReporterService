package org.reporter.service.ets_reports;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(VTripTime.class)
public class VTripTime_ { 

    public static volatile SingularAttribute<VTripTime, Date> endDate;
    public static volatile SingularAttribute<VTripTime, Integer> difftime;
    public static volatile SingularAttribute<VTripTime, String> stationIn;
    public static volatile SingularAttribute<VTripTime, String> sessionId;
    public static volatile SingularAttribute<VTripTime, String> stationOut;
    public static volatile SingularAttribute<VTripTime, String> cardNumber;
    public static volatile SingularAttribute<VTripTime, Date> startDate;

}