package org.reporter.service.ets_reports;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.reporter.service.ets_reports.CardTypes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(Cards.class)
public class Cards_ { 

    public static volatile SingularAttribute<Cards, BigDecimal> loyaltPassCount;
    public static volatile SingularAttribute<Cards, Long> cardId;
    public static volatile SingularAttribute<Cards, BigDecimal> currentBalance;
    public static volatile SingularAttribute<Cards, Long> currentPassCount;
    public static volatile SingularAttribute<Cards, BigInteger> customerId;
    public static volatile SingularAttribute<Cards, CardTypes> cardTypeCode;
    public static volatile SingularAttribute<Cards, Date> validationDate;
    public static volatile SingularAttribute<Cards, String> cardNumber;
    public static volatile SingularAttribute<Cards, String> cardIdForBle;
    public static volatile SingularAttribute<Cards, Date> createDate;
    public static volatile SingularAttribute<Cards, Character> status;

}