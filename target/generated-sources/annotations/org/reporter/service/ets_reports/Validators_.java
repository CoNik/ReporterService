package org.reporter.service.ets_reports;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.reporter.service.ets_reports.Routes;
import org.reporter.service.ets_reports.Stations;
import org.reporter.service.ets_reports.ValidatorsPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(Validators.class)
public class Validators_ { 

    public static volatile SingularAttribute<Validators, Routes> routeCode;
    public static volatile SingularAttribute<Validators, ValidatorsPK> validatorsPK;
    public static volatile SingularAttribute<Validators, String> password;
    public static volatile SingularAttribute<Validators, String> versionID;
    public static volatile SingularAttribute<Validators, String> validatorTypeCode;
    public static volatile SingularAttribute<Validators, String> routeDirection;
    public static volatile SingularAttribute<Validators, String> serialNo;
    public static volatile SingularAttribute<Validators, Character> status;
    public static volatile SingularAttribute<Validators, Stations> stationId;

}