package org.reporter.service.ets_reports;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(AlertLogs.class)
public class AlertLogs_ { 

    public static volatile SingularAttribute<AlertLogs, Integer> itemId;
    public static volatile SingularAttribute<AlertLogs, Date> sentDate;
    public static volatile SingularAttribute<AlertLogs, Integer> machineId;
    public static volatile SingularAttribute<AlertLogs, Date> createdDate;
    public static volatile SingularAttribute<AlertLogs, String> alertCode;
    public static volatile SingularAttribute<AlertLogs, String> cardId;
    public static volatile SingularAttribute<AlertLogs, String> description;
    public static volatile SingularAttribute<AlertLogs, Integer> id;
    public static volatile SingularAttribute<AlertLogs, String> sessionId;
    public static volatile SingularAttribute<AlertLogs, String> alertId;
    public static volatile SingularAttribute<AlertLogs, Integer> deviceId;

}