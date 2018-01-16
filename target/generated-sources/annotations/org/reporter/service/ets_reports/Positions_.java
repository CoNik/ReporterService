package org.reporter.service.ets_reports;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(Positions.class)
public class Positions_ { 

    public static volatile SingularAttribute<Positions, String> locationTs;
    public static volatile SingularAttribute<Positions, BigInteger> cardid;
    public static volatile SingularAttribute<Positions, Date> travelInitTs;
    public static volatile SingularAttribute<Positions, BigInteger> customerid;
    public static volatile SingularAttribute<Positions, String> locationLatitude;
    public static volatile SingularAttribute<Positions, String> locationLongitude;
    public static volatile SingularAttribute<Positions, String> id;
    public static volatile SingularAttribute<Positions, Date> travelEndTs;

}