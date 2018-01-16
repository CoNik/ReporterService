package org.reporter.service.ets_reports;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(KioskItems.class)
public class KioskItems_ { 

    public static volatile SingularAttribute<KioskItems, Integer> itemType;
    public static volatile SingularAttribute<KioskItems, String> code;
    public static volatile SingularAttribute<KioskItems, Integer> maximumCount;
    public static volatile SingularAttribute<KioskItems, String> description;
    public static volatile SingularAttribute<KioskItems, Integer> hopperVaultIndex;
    public static volatile SingularAttribute<KioskItems, Boolean> onInfeeder02;
    public static volatile SingularAttribute<KioskItems, Boolean> onInfeeder01;
    public static volatile SingularAttribute<KioskItems, Integer> upperTrashHoldCount;
    public static volatile SingularAttribute<KioskItems, Integer> countAtPrimary;
    public static volatile SingularAttribute<KioskItems, Integer> minimumCount;
    public static volatile SingularAttribute<KioskItems, Integer> iproRCDeviceId;
    public static volatile SingularAttribute<KioskItems, Integer> countAtSecondary;
    public static volatile SingularAttribute<KioskItems, String> validatorPath;
    public static volatile SingularAttribute<KioskItems, Date> sentDate;
    public static volatile SingularAttribute<KioskItems, Date> createdDate;
    public static volatile SingularAttribute<KioskItems, Integer> currentCount;
    public static volatile SingularAttribute<KioskItems, Integer> id;
    public static volatile SingularAttribute<KioskItems, Integer> iproRCStackIndex;
    public static volatile SingularAttribute<KioskItems, BigDecimal> value;
    public static volatile SingularAttribute<KioskItems, String> validatorCode;
    public static volatile SingularAttribute<KioskItems, Integer> hopperDeviceId;
    public static volatile SingularAttribute<KioskItems, Date> lastUpdateTime;
    public static volatile SingularAttribute<KioskItems, Integer> lowerTrashHoldCount;
    public static volatile SingularAttribute<KioskItems, Integer> status;

}