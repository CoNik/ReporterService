package org.reporter.service.ets_reports;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-16T14:09:06")
@StaticMetamodel(DeviceStateHistory.class)
public class DeviceStateHistory_ { 

    public static volatile SingularAttribute<DeviceStateHistory, Boolean> iProRCComIsOpen;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> hopperComIsOpen;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> iProRCStackersStatus;
    public static volatile SingularAttribute<DeviceStateHistory, Date> stateChangeDate;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> iProRCMoneyBackingStatus;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> clessReaderIsAlive;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> hopperIsAlive;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> kGBTicketOnInfeeder02;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> kGBTicketOnInfeeder01;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> validatorIsAlive;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> posIsAlive;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> printerIsOffline;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> iProRCInitializationSucceeded;
    public static volatile SingularAttribute<DeviceStateHistory, Date> sentDate;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> networkIsAlive;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> kGBTicketJam;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> kGBTicketInside;
    public static volatile SingularAttribute<DeviceStateHistory, Integer> id;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> kGBIsReady;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> serverIsReachable;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> validatorComIsOpen;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> cardDispanserIsAlive;
    public static volatile SingularAttribute<DeviceStateHistory, Integer> cardDispanserCardStatus;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> printerHasError;
    public static volatile SingularAttribute<DeviceStateHistory, Integer> machineId;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> kGBComIsOpen;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> kGBIsAlive;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> machineControlCardIsAlive;
    public static volatile SingularAttribute<DeviceStateHistory, String> extendedStates;
    public static volatile SingularAttribute<DeviceStateHistory, Boolean> iProRCMoneyReceivingStatus;

}