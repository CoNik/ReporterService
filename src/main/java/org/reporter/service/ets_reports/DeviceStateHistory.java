/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "DeviceStateHistory_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceStateHistory.findAll", query = "SELECT d FROM DeviceStateHistory d")
    , @NamedQuery(name = "DeviceStateHistory.findById", query = "SELECT d FROM DeviceStateHistory d WHERE d.id = :id")
    , @NamedQuery(name = "DeviceStateHistory.findByPeriod", query = "SELECT d FROM DeviceStateHistory d WHERE d.sentDate between :startDate and :endDate")
    , @NamedQuery(name = "DeviceStateHistory.findByPeriodAndStation", query = "SELECT d FROM DeviceStateHistory d, MachinesValidators mv, Validators v, Stations s WHERE (d.sentDate between :startDate and :endDate) and d.machineId=mv.machinesValidatorsPK.machineId and mv.machinesValidatorsPK.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.displayName = :stationName")
    , @NamedQuery(name = "DeviceStateHistory.findByPeriodAndStationId", query = "SELECT d FROM DeviceStateHistory d, MachinesValidators mv, Validators v, Stations s WHERE (d.sentDate between :startDate and :endDate) and d.machineId=mv.machinesValidatorsPK.machineId and mv.machinesValidatorsPK.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.stationId = :stationId")
    , @NamedQuery(name = "DeviceStateHistory.findByMachineId", query = "SELECT d FROM DeviceStateHistory d WHERE d.machineId = :machineId")
    , @NamedQuery(name = "DeviceStateHistory.findByHopperComIsOpen", query = "SELECT d FROM DeviceStateHistory d WHERE d.hopperComIsOpen = :hopperComIsOpen")
    , @NamedQuery(name = "DeviceStateHistory.findByHopperIsAlive", query = "SELECT d FROM DeviceStateHistory d WHERE d.hopperIsAlive = :hopperIsAlive")
    , @NamedQuery(name = "DeviceStateHistory.findByIProRCComIsOpen", query = "SELECT d FROM DeviceStateHistory d WHERE d.iProRCComIsOpen = :iProRCComIsOpen")
    , @NamedQuery(name = "DeviceStateHistory.findByIProRCMoneyReceivingStatus", query = "SELECT d FROM DeviceStateHistory d WHERE d.iProRCMoneyReceivingStatus = :iProRCMoneyReceivingStatus")
    , @NamedQuery(name = "DeviceStateHistory.findByIProRCMoneyBackingStatus", query = "SELECT d FROM DeviceStateHistory d WHERE d.iProRCMoneyBackingStatus = :iProRCMoneyBackingStatus")
    , @NamedQuery(name = "DeviceStateHistory.findByIProRCStackersStatus", query = "SELECT d FROM DeviceStateHistory d WHERE d.iProRCStackersStatus = :iProRCStackersStatus")
    , @NamedQuery(name = "DeviceStateHistory.findByIProRCInitializationSucceeded", query = "SELECT d FROM DeviceStateHistory d WHERE d.iProRCInitializationSucceeded = :iProRCInitializationSucceeded")
    , @NamedQuery(name = "DeviceStateHistory.findByKGBComIsOpen", query = "SELECT d FROM DeviceStateHistory d WHERE d.kGBComIsOpen = :kGBComIsOpen")
    , @NamedQuery(name = "DeviceStateHistory.findByKGBIsAlive", query = "SELECT d FROM DeviceStateHistory d WHERE d.kGBIsAlive = :kGBIsAlive")
    , @NamedQuery(name = "DeviceStateHistory.findByKGBTicketOnInfeeder01", query = "SELECT d FROM DeviceStateHistory d WHERE d.kGBTicketOnInfeeder01 = :kGBTicketOnInfeeder01")
    , @NamedQuery(name = "DeviceStateHistory.findByKGBTicketOnInfeeder02", query = "SELECT d FROM DeviceStateHistory d WHERE d.kGBTicketOnInfeeder02 = :kGBTicketOnInfeeder02")
    , @NamedQuery(name = "DeviceStateHistory.findByKGBIsReady", query = "SELECT d FROM DeviceStateHistory d WHERE d.kGBIsReady = :kGBIsReady")
    , @NamedQuery(name = "DeviceStateHistory.findByKGBTicketInside", query = "SELECT d FROM DeviceStateHistory d WHERE d.kGBTicketInside = :kGBTicketInside")
    , @NamedQuery(name = "DeviceStateHistory.findByKGBTicketJam", query = "SELECT d FROM DeviceStateHistory d WHERE d.kGBTicketJam = :kGBTicketJam")
    , @NamedQuery(name = "DeviceStateHistory.findByValidatorComIsOpen", query = "SELECT d FROM DeviceStateHistory d WHERE d.validatorComIsOpen = :validatorComIsOpen")
    , @NamedQuery(name = "DeviceStateHistory.findByValidatorIsAlive", query = "SELECT d FROM DeviceStateHistory d WHERE d.validatorIsAlive = :validatorIsAlive")
    , @NamedQuery(name = "DeviceStateHistory.findByCardDispanserIsAlive", query = "SELECT d FROM DeviceStateHistory d WHERE d.cardDispanserIsAlive = :cardDispanserIsAlive")
    , @NamedQuery(name = "DeviceStateHistory.findByCardDispanserCardStatus", query = "SELECT d FROM DeviceStateHistory d WHERE d.cardDispanserCardStatus = :cardDispanserCardStatus")
    , @NamedQuery(name = "DeviceStateHistory.findByPrinterHasError", query = "SELECT d FROM DeviceStateHistory d WHERE d.printerHasError = :printerHasError")
    , @NamedQuery(name = "DeviceStateHistory.findByPrinterIsOffline", query = "SELECT d FROM DeviceStateHistory d WHERE d.printerIsOffline = :printerIsOffline")
    , @NamedQuery(name = "DeviceStateHistory.findByMachineControlCardIsAlive", query = "SELECT d FROM DeviceStateHistory d WHERE d.machineControlCardIsAlive = :machineControlCardIsAlive")
    , @NamedQuery(name = "DeviceStateHistory.findByClessReaderIsAlive", query = "SELECT d FROM DeviceStateHistory d WHERE d.clessReaderIsAlive = :clessReaderIsAlive")
    , @NamedQuery(name = "DeviceStateHistory.findByPosIsAlive", query = "SELECT d FROM DeviceStateHistory d WHERE d.posIsAlive = :posIsAlive")
    , @NamedQuery(name = "DeviceStateHistory.findByNetworkIsAlive", query = "SELECT d FROM DeviceStateHistory d WHERE d.networkIsAlive = :networkIsAlive")
    , @NamedQuery(name = "DeviceStateHistory.findByServerIsReachable", query = "SELECT d FROM DeviceStateHistory d WHERE d.serverIsReachable = :serverIsReachable")
    , @NamedQuery(name = "DeviceStateHistory.findByExtendedStates", query = "SELECT d FROM DeviceStateHistory d WHERE d.extendedStates = :extendedStates")
    , @NamedQuery(name = "DeviceStateHistory.findByStateChangeDate", query = "SELECT d FROM DeviceStateHistory d WHERE d.stateChangeDate = :stateChangeDate")
    , @NamedQuery(name = "DeviceStateHistory.findBySentDate", query = "SELECT d FROM DeviceStateHistory d WHERE d.sentDate = :sentDate")})
public class DeviceStateHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "MachineId")
    private Integer machineId;
    @Column(name = "HopperComIsOpen")
    private Boolean hopperComIsOpen;
    @Column(name = "HopperIsAlive")
    private Boolean hopperIsAlive;
    @Column(name = "IProRCComIsOpen")
    private Boolean iProRCComIsOpen;
    @Column(name = "IProRCMoneyReceivingStatus")
    private Boolean iProRCMoneyReceivingStatus;
    @Column(name = "IProRCMoneyBackingStatus")
    private Boolean iProRCMoneyBackingStatus;
    @Column(name = "IProRCStackersStatus")
    private Boolean iProRCStackersStatus;
    @Column(name = "IProRCInitializationSucceeded")
    private Boolean iProRCInitializationSucceeded;
    @Column(name = "KGBComIsOpen")
    private Boolean kGBComIsOpen;
    @Column(name = "KGBIsAlive")
    private Boolean kGBIsAlive;
    @Column(name = "KGBTicketOnInfeeder01")
    private Boolean kGBTicketOnInfeeder01;
    @Column(name = "KGBTicketOnInfeeder02")
    private Boolean kGBTicketOnInfeeder02;
    @Column(name = "KGBIsReady")
    private Boolean kGBIsReady;
    @Column(name = "KGBTicketInside")
    private Boolean kGBTicketInside;
    @Column(name = "KGBTicketJam")
    private Boolean kGBTicketJam;
    @Column(name = "ValidatorComIsOpen")
    private Boolean validatorComIsOpen;
    @Column(name = "ValidatorIsAlive")
    private Boolean validatorIsAlive;
    @Column(name = "CardDispanserIsAlive")
    private Boolean cardDispanserIsAlive;
    @Column(name = "CardDispanserCardStatus")
    private Integer cardDispanserCardStatus;
    @Column(name = "PrinterHasError")
    private Boolean printerHasError;
    @Column(name = "PrinterIsOffline")
    private Boolean printerIsOffline;
    @Column(name = "MachineControlCardIsAlive")
    private Boolean machineControlCardIsAlive;
    @Column(name = "ClessReaderIsAlive")
    private Boolean clessReaderIsAlive;
    @Column(name = "PosIsAlive")
    private Boolean posIsAlive;
    @Column(name = "NetworkIsAlive")
    private Boolean networkIsAlive;
    @Column(name = "ServerIsReachable")
    private Boolean serverIsReachable;
    @Size(max = 1000)
    @Column(name = "ExtendedStates")
    private String extendedStates;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StateChangeDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stateChangeDate;
    @Column(name = "SentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    public DeviceStateHistory() {
    }

    public DeviceStateHistory(Integer id) {
        this.id = id;
    }

    public DeviceStateHistory(Integer id, Date stateChangeDate) {
        this.id = id;
        this.stateChangeDate = stateChangeDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public Boolean getHopperComIsOpen() {
        return hopperComIsOpen;
    }

    public void setHopperComIsOpen(Boolean hopperComIsOpen) {
        this.hopperComIsOpen = hopperComIsOpen;
    }

    public Boolean getHopperIsAlive() {
        return hopperIsAlive;
    }

    public void setHopperIsAlive(Boolean hopperIsAlive) {
        this.hopperIsAlive = hopperIsAlive;
    }

    public Boolean getIProRCComIsOpen() {
        return iProRCComIsOpen;
    }

    public void setIProRCComIsOpen(Boolean iProRCComIsOpen) {
        this.iProRCComIsOpen = iProRCComIsOpen;
    }

    public Boolean getIProRCMoneyReceivingStatus() {
        return iProRCMoneyReceivingStatus;
    }

    public void setIProRCMoneyReceivingStatus(Boolean iProRCMoneyReceivingStatus) {
        this.iProRCMoneyReceivingStatus = iProRCMoneyReceivingStatus;
    }

    public Boolean getIProRCMoneyBackingStatus() {
        return iProRCMoneyBackingStatus;
    }

    public void setIProRCMoneyBackingStatus(Boolean iProRCMoneyBackingStatus) {
        this.iProRCMoneyBackingStatus = iProRCMoneyBackingStatus;
    }

    public Boolean getIProRCStackersStatus() {
        return iProRCStackersStatus;
    }

    public void setIProRCStackersStatus(Boolean iProRCStackersStatus) {
        this.iProRCStackersStatus = iProRCStackersStatus;
    }

    public Boolean getIProRCInitializationSucceeded() {
        return iProRCInitializationSucceeded;
    }

    public void setIProRCInitializationSucceeded(Boolean iProRCInitializationSucceeded) {
        this.iProRCInitializationSucceeded = iProRCInitializationSucceeded;
    }

    public Boolean getKGBComIsOpen() {
        return kGBComIsOpen;
    }

    public void setKGBComIsOpen(Boolean kGBComIsOpen) {
        this.kGBComIsOpen = kGBComIsOpen;
    }

    public Boolean getKGBIsAlive() {
        return kGBIsAlive;
    }

    public void setKGBIsAlive(Boolean kGBIsAlive) {
        this.kGBIsAlive = kGBIsAlive;
    }

    public Boolean getKGBTicketOnInfeeder01() {
        return kGBTicketOnInfeeder01;
    }

    public void setKGBTicketOnInfeeder01(Boolean kGBTicketOnInfeeder01) {
        this.kGBTicketOnInfeeder01 = kGBTicketOnInfeeder01;
    }

    public Boolean getKGBTicketOnInfeeder02() {
        return kGBTicketOnInfeeder02;
    }

    public void setKGBTicketOnInfeeder02(Boolean kGBTicketOnInfeeder02) {
        this.kGBTicketOnInfeeder02 = kGBTicketOnInfeeder02;
    }

    public Boolean getKGBIsReady() {
        return kGBIsReady;
    }

    public void setKGBIsReady(Boolean kGBIsReady) {
        this.kGBIsReady = kGBIsReady;
    }

    public Boolean getKGBTicketInside() {
        return kGBTicketInside;
    }

    public void setKGBTicketInside(Boolean kGBTicketInside) {
        this.kGBTicketInside = kGBTicketInside;
    }

    public Boolean getKGBTicketJam() {
        return kGBTicketJam;
    }

    public void setKGBTicketJam(Boolean kGBTicketJam) {
        this.kGBTicketJam = kGBTicketJam;
    }

    public Boolean getValidatorComIsOpen() {
        return validatorComIsOpen;
    }

    public void setValidatorComIsOpen(Boolean validatorComIsOpen) {
        this.validatorComIsOpen = validatorComIsOpen;
    }

    public Boolean getValidatorIsAlive() {
        return validatorIsAlive;
    }

    public void setValidatorIsAlive(Boolean validatorIsAlive) {
        this.validatorIsAlive = validatorIsAlive;
    }

    public Boolean getCardDispanserIsAlive() {
        return cardDispanserIsAlive;
    }

    public void setCardDispanserIsAlive(Boolean cardDispanserIsAlive) {
        this.cardDispanserIsAlive = cardDispanserIsAlive;
    }

    public Integer getCardDispanserCardStatus() {
        return cardDispanserCardStatus;
    }

    public void setCardDispanserCardStatus(Integer cardDispanserCardStatus) {
        this.cardDispanserCardStatus = cardDispanserCardStatus;
    }

    public Boolean getPrinterHasError() {
        return printerHasError;
    }

    public void setPrinterHasError(Boolean printerHasError) {
        this.printerHasError = printerHasError;
    }

    public Boolean getPrinterIsOffline() {
        return printerIsOffline;
    }

    public void setPrinterIsOffline(Boolean printerIsOffline) {
        this.printerIsOffline = printerIsOffline;
    }

    public Boolean getMachineControlCardIsAlive() {
        return machineControlCardIsAlive;
    }

    public void setMachineControlCardIsAlive(Boolean machineControlCardIsAlive) {
        this.machineControlCardIsAlive = machineControlCardIsAlive;
    }

    public Boolean getClessReaderIsAlive() {
        return clessReaderIsAlive;
    }

    public void setClessReaderIsAlive(Boolean clessReaderIsAlive) {
        this.clessReaderIsAlive = clessReaderIsAlive;
    }

    public Boolean getPosIsAlive() {
        return posIsAlive;
    }

    public void setPosIsAlive(Boolean posIsAlive) {
        this.posIsAlive = posIsAlive;
    }

    public Boolean getNetworkIsAlive() {
        return networkIsAlive;
    }

    public void setNetworkIsAlive(Boolean networkIsAlive) {
        this.networkIsAlive = networkIsAlive;
    }

    public Boolean getServerIsReachable() {
        return serverIsReachable;
    }

    public void setServerIsReachable(Boolean serverIsReachable) {
        this.serverIsReachable = serverIsReachable;
    }

    public String getExtendedStates() {
        return extendedStates;
    }

    public void setExtendedStates(String extendedStates) {
        this.extendedStates = extendedStates;
    }

    public Date getStateChangeDate() {
        return stateChangeDate;
    }

    public void setStateChangeDate(Date stateChangeDate) {
        this.stateChangeDate = stateChangeDate;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceStateHistory)) {
            return false;
        }
        DeviceStateHistory other = (DeviceStateHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.DeviceStateHistory[ id=" + id + " ]";
    }
    
}
