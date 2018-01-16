package org.reporter.service.ets_reports;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.reporter.service.ets_reports.CardTypes;
import org.reporter.service.ets_reports.RoutePricesPK;
import org.reporter.service.ets_reports.Routes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(RoutePrices.class)
public class RoutePrices_ { 

    public static volatile SingularAttribute<RoutePrices, BigDecimal> unitPrice;
    public static volatile SingularAttribute<RoutePrices, Short> unitTypeUse;
    public static volatile SingularAttribute<RoutePrices, Date> endDate;
    public static volatile SingularAttribute<RoutePrices, CardTypes> cardTypes;
    public static volatile SingularAttribute<RoutePrices, RoutePricesPK> routePricesPK;
    public static volatile SingularAttribute<RoutePrices, Routes> routes;
    public static volatile SingularAttribute<RoutePrices, BigDecimal> unitPassCount;
    public static volatile SingularAttribute<RoutePrices, BigDecimal> transfer5;
    public static volatile SingularAttribute<RoutePrices, BigDecimal> transfer3;
    public static volatile SingularAttribute<RoutePrices, BigDecimal> transfer4;
    public static volatile SingularAttribute<RoutePrices, BigDecimal> transfer1;
    public static volatile SingularAttribute<RoutePrices, BigDecimal> transfer2;
    public static volatile SingularAttribute<RoutePrices, Date> startDate;
    public static volatile SingularAttribute<RoutePrices, Date> createDate;
    public static volatile SingularAttribute<RoutePrices, Character> status;

}