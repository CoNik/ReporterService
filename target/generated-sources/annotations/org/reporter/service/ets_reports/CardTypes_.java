package org.reporter.service.ets_reports;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.reporter.service.ets_reports.Cards;
import org.reporter.service.ets_reports.RoutePrices;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(CardTypes.class)
public class CardTypes_ { 

    public static volatile SingularAttribute<CardTypes, Date> endDate;
    public static volatile CollectionAttribute<CardTypes, Cards> cardsCollection;
    public static volatile SingularAttribute<CardTypes, String> cardTypeDescription;
    public static volatile SingularAttribute<CardTypes, String> cardTypeCode;
    public static volatile SingularAttribute<CardTypes, Date> startDate;
    public static volatile SingularAttribute<CardTypes, Character> status;
    public static volatile CollectionAttribute<CardTypes, RoutePrices> routePricesCollection;

}