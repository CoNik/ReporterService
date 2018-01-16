package org.reporter.service.ets_reports;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(ActivityLogs.class)
public class ActivityLogs_ { 

    public static volatile SingularAttribute<ActivityLogs, Integer> activityId;
    public static volatile SingularAttribute<ActivityLogs, Integer> itemId;
    public static volatile SingularAttribute<ActivityLogs, String> activityCode;
    public static volatile SingularAttribute<ActivityLogs, Date> sentDate;
    public static volatile SingularAttribute<ActivityLogs, Integer> quantity;
    public static volatile SingularAttribute<ActivityLogs, Integer> machineId;
    public static volatile SingularAttribute<ActivityLogs, Date> createdDate;
    public static volatile SingularAttribute<ActivityLogs, String> cardId;
    public static volatile SingularAttribute<ActivityLogs, String> description;
    public static volatile SingularAttribute<ActivityLogs, String> sessionId;
    public static volatile SingularAttribute<ActivityLogs, Integer> id;
    public static volatile SingularAttribute<ActivityLogs, BigDecimal> value;

}