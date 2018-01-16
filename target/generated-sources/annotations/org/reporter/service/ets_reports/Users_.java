package org.reporter.service.ets_reports;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Date> preventLoggingUntilTheTime;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Date> sentDate;
    public static volatile SingularAttribute<Users, String> cardId;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Date> validationDate;
    public static volatile SingularAttribute<Users, Date> lastLoginDate;
    public static volatile SingularAttribute<Users, Date> last3TimesPasswordErrorOccuredTime;
    public static volatile SingularAttribute<Users, String> userName;

}