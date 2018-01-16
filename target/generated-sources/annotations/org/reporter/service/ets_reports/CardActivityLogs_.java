package org.reporter.service.ets_reports;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(CardActivityLogs.class)
public class CardActivityLogs_ { 

    public static volatile SingularAttribute<CardActivityLogs, String> activityCode;
    public static volatile SingularAttribute<CardActivityLogs, BigDecimal> amount;
    public static volatile SingularAttribute<CardActivityLogs, Date> sentDate;
    public static volatile SingularAttribute<CardActivityLogs, Date> createdDate;
    public static volatile SingularAttribute<CardActivityLogs, Short> directionId;
    public static volatile SingularAttribute<CardActivityLogs, BigDecimal> currentBalance;
    public static volatile SingularAttribute<CardActivityLogs, String> description;
    public static volatile SingularAttribute<CardActivityLogs, Long> id;
    public static volatile SingularAttribute<CardActivityLogs, String> sessionId;
    public static volatile SingularAttribute<CardActivityLogs, String> cardNumber;
    public static volatile SingularAttribute<CardActivityLogs, String> validatorCode;

}