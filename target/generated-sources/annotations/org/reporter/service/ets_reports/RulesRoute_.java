package org.reporter.service.ets_reports;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(RulesRoute.class)
public class RulesRoute_ { 

    public static volatile SingularAttribute<RulesRoute, String> routeCode;
    public static volatile SingularAttribute<RulesRoute, Date> endDate;
    public static volatile SingularAttribute<RulesRoute, BigDecimal> multiplier;
    public static volatile SingularAttribute<RulesRoute, String> formula;
    public static volatile SingularAttribute<RulesRoute, String> cardTypeCode;
    public static volatile SingularAttribute<RulesRoute, Long> ruleId;
    public static volatile SingularAttribute<RulesRoute, Date> startDate;
    public static volatile SingularAttribute<RulesRoute, Date> createDate;

}