package org.reporter.service.ets_reports;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(CustomerAdress.class)
public class CustomerAdress_ { 

    public static volatile SingularAttribute<CustomerAdress, Character> valid;
    public static volatile SingularAttribute<CustomerAdress, Integer> country;
    public static volatile SingularAttribute<CustomerAdress, BigInteger> cities;
    public static volatile SingularAttribute<CustomerAdress, BigInteger> city;
    public static volatile SingularAttribute<CustomerAdress, Long> customerId;
    public static volatile SingularAttribute<CustomerAdress, Long> customerAdressId;
    public static volatile SingularAttribute<CustomerAdress, String> adress1;
    public static volatile SingularAttribute<CustomerAdress, Character> status;
    public static volatile SingularAttribute<CustomerAdress, Date> createDate;

}