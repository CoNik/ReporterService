package org.reporter.service.ets_reports;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(FraudStations.class)
public class FraudStations_ { 

    public static volatile SingularAttribute<FraudStations, BigInteger> fraudStations;
    public static volatile SingularAttribute<FraudStations, String> fraudPicture;
    public static volatile SingularAttribute<FraudStations, BigInteger> fraudCardId;
    public static volatile SingularAttribute<FraudStations, Integer> fraudType;
    public static volatile SingularAttribute<FraudStations, Long> fraudId;
    public static volatile SingularAttribute<FraudStations, Date> createDate;

}