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
@Table(name = "Machines_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machines.findAll", query = "SELECT m FROM Machines m")
    , @NamedQuery(name = "Machines.findById", query = "SELECT m FROM Machines m WHERE m.id = :id")
    , @NamedQuery(name = "Machines.findByGroupId", query = "SELECT m FROM Machines m WHERE m.groupId = :groupId")
    , @NamedQuery(name = "Machines.findByMachineId", query = "SELECT m FROM Machines m WHERE m.machineId = :machineId")
    , @NamedQuery(name = "Machines.findByTypeId", query = "SELECT m FROM Machines m WHERE m.typeId = :typeId")
    , @NamedQuery(name = "Machines.findByDescription", query = "SELECT m FROM Machines m WHERE m.description = :description")
    , @NamedQuery(name = "Machines.findByHopperComIsOpen", query = "SELECT m FROM Machines m WHERE m.hopperComIsOpen = :hopperComIsOpen")
    , @NamedQuery(name = "Machines.findByHopperIsAlive", query = "SELECT m FROM Machines m WHERE m.hopperIsAlive = :hopperIsAlive")
    , @NamedQuery(name = "Machines.findByHopperDeviceInfo", query = "SELECT m FROM Machines m WHERE m.hopperDeviceInfo = :hopperDeviceInfo")
    , @NamedQuery(name = "Machines.findByIProRCComIsOpen", query = "SELECT m FROM Machines m WHERE m.iProRCComIsOpen = :iProRCComIsOpen")
    , @NamedQuery(name = "Machines.findByIProRCMoneyReceivingStatus", query = "SELECT m FROM Machines m WHERE m.iProRCMoneyReceivingStatus = :iProRCMoneyReceivingStatus")
    , @NamedQuery(name = "Machines.findByIProRCMoneyBackingStatus", query = "SELECT m FROM Machines m WHERE m.iProRCMoneyBackingStatus = :iProRCMoneyBackingStatus")
    , @NamedQuery(name = "Machines.findByIProRCStackersStatus", query = "SELECT m FROM Machines m WHERE m.iProRCStackersStatus = :iProRCStackersStatus")
    , @NamedQuery(name = "Machines.findByIProRCInitializationSucceeded", query = "SELECT m FROM Machines m WHERE m.iProRCInitializationSucceeded = :iProRCInitializationSucceeded")
    , @NamedQuery(name = "Machines.findByIProRCDeviceInfo", query = "SELECT m FROM Machines m WHERE m.iProRCDeviceInfo = :iProRCDeviceInfo")
    , @NamedQuery(name = "Machines.findByKGBComIsOpen", query = "SELECT m FROM Machines m WHERE m.kGBComIsOpen = :kGBComIsOpen")
    , @NamedQuery(name = "Machines.findByKGBIsAlive", query = "SELECT m FROM Machines m WHERE m.kGBIsAlive = :kGBIsAlive")
    , @NamedQuery(name = "Machines.findByKGBTicketOnInfeeder01", query = "SELECT m FROM Machines m WHERE m.kGBTicketOnInfeeder01 = :kGBTicketOnInfeeder01")
    , @NamedQuery(name = "Machines.findByKGBTicketOnInfeeder02", query = "SELECT m FROM Machines m WHERE m.kGBTicketOnInfeeder02 = :kGBTicketOnInfeeder02")
    , @NamedQuery(name = "Machines.findByKGBIsReady", query = "SELECT m FROM Machines m WHERE m.kGBIsReady = :kGBIsReady")
    , @NamedQuery(name = "Machines.findByKGBHasError", query = "SELECT m FROM Machines m WHERE m.kGBHasError = :kGBHasError")
    , @NamedQuery(name = "Machines.findByKGBTicketInside", query = "SELECT m FROM Machines m WHERE m.kGBTicketInside = :kGBTicketInside")
    , @NamedQuery(name = "Machines.findByKGBTicketJam", query = "SELECT m FROM Machines m WHERE m.kGBTicketJam = :kGBTicketJam")
    , @NamedQuery(name = "Machines.findByKGBLifeCheckState", query = "SELECT m FROM Machines m WHERE m.kGBLifeCheckState = :kGBLifeCheckState")
    , @NamedQuery(name = "Machines.findByKGBLifeCheckStateInString", query = "SELECT m FROM Machines m WHERE m.kGBLifeCheckStateInString = :kGBLifeCheckStateInString")
    , @NamedQuery(name = "Machines.findByKGBLastOperationStatus", query = "SELECT m FROM Machines m WHERE m.kGBLastOperationStatus = :kGBLastOperationStatus")
    , @NamedQuery(name = "Machines.findByKGBErrorCode", query = "SELECT m FROM Machines m WHERE m.kGBErrorCode = :kGBErrorCode")
    , @NamedQuery(name = "Machines.findByKGBLastErrors", query = "SELECT m FROM Machines m WHERE m.kGBLastErrors = :kGBLastErrors")
    , @NamedQuery(name = "Machines.findByValidatorComIsOpen", query = "SELECT m FROM Machines m WHERE m.validatorComIsOpen = :validatorComIsOpen")
    , @NamedQuery(name = "Machines.findByValidatorIsAlive", query = "SELECT m FROM Machines m WHERE m.validatorIsAlive = :validatorIsAlive")
    , @NamedQuery(name = "Machines.findByCardDispanserComIsOpen", query = "SELECT m FROM Machines m WHERE m.cardDispanserComIsOpen = :cardDispanserComIsOpen")
    , @NamedQuery(name = "Machines.findByCardDispanserIsAlive", query = "SELECT m FROM Machines m WHERE m.cardDispanserIsAlive = :cardDispanserIsAlive")
    , @NamedQuery(name = "Machines.findByCardDispanserCardStatus", query = "SELECT m FROM Machines m WHERE m.cardDispanserCardStatus = :cardDispanserCardStatus")
    , @NamedQuery(name = "Machines.findByCardDispanserIsBinFull", query = "SELECT m FROM Machines m WHERE m.cardDispanserIsBinFull = :cardDispanserIsBinFull")
    , @NamedQuery(name = "Machines.findByPrinterHasError", query = "SELECT m FROM Machines m WHERE m.printerHasError = :printerHasError")
    , @NamedQuery(name = "Machines.findByPrinterIsOffline", query = "SELECT m FROM Machines m WHERE m.printerIsOffline = :printerIsOffline")
    , @NamedQuery(name = "Machines.findByPrinterIsOutOfPaper", query = "SELECT m FROM Machines m WHERE m.printerIsOutOfPaper = :printerIsOutOfPaper")
    , @NamedQuery(name = "Machines.findByPrinterPaperIsNearToEnd", query = "SELECT m FROM Machines m WHERE m.printerPaperIsNearToEnd = :printerPaperIsNearToEnd")
    , @NamedQuery(name = "Machines.findByMachineControlCardIsAlive", query = "SELECT m FROM Machines m WHERE m.machineControlCardIsAlive = :machineControlCardIsAlive")
    , @NamedQuery(name = "Machines.findByMachineHumidity", query = "SELECT m FROM Machines m WHERE m.machineHumidity = :machineHumidity")
    , @NamedQuery(name = "Machines.findByMachineTemperature", query = "SELECT m FROM Machines m WHERE m.machineTemperature = :machineTemperature")
    , @NamedQuery(name = "Machines.findByMachineInteriorDoorStatus", query = "SELECT m FROM Machines m WHERE m.machineInteriorDoorStatus = :machineInteriorDoorStatus")
    , @NamedQuery(name = "Machines.findByMachineExteriorDoorStatus", query = "SELECT m FROM Machines m WHERE m.machineExteriorDoorStatus = :machineExteriorDoorStatus")
    , @NamedQuery(name = "Machines.findByMachineInsideLighting", query = "SELECT m FROM Machines m WHERE m.machineInsideLighting = :machineInsideLighting")
    , @NamedQuery(name = "Machines.findByMachineOutsideLighting", query = "SELECT m FROM Machines m WHERE m.machineOutsideLighting = :machineOutsideLighting")
    , @NamedQuery(name = "Machines.findByEtopupFileDownloadLastAttemptTime", query = "SELECT m FROM Machines m WHERE m.etopupFileDownloadLastAttemptTime = :etopupFileDownloadLastAttemptTime")
    , @NamedQuery(name = "Machines.findByEtopupFileDownloadLastSuccessTime", query = "SELECT m FROM Machines m WHERE m.etopupFileDownloadLastSuccessTime = :etopupFileDownloadLastSuccessTime")
    , @NamedQuery(name = "Machines.findByEtopupFileDownloadLastErrorTime", query = "SELECT m FROM Machines m WHERE m.etopupFileDownloadLastErrorTime = :etopupFileDownloadLastErrorTime")
    , @NamedQuery(name = "Machines.findByEtopupFileDownloadLastErrorMessage", query = "SELECT m FROM Machines m WHERE m.etopupFileDownloadLastErrorMessage = :etopupFileDownloadLastErrorMessage")
    , @NamedQuery(name = "Machines.findByEkentActivityFilesUploadLastAttemptTime", query = "SELECT m FROM Machines m WHERE m.ekentActivityFilesUploadLastAttemptTime = :ekentActivityFilesUploadLastAttemptTime")
    , @NamedQuery(name = "Machines.findByEkentActivityFilesUploadLastSuccessTime", query = "SELECT m FROM Machines m WHERE m.ekentActivityFilesUploadLastSuccessTime = :ekentActivityFilesUploadLastSuccessTime")
    , @NamedQuery(name = "Machines.findByEkentActivityFilesUploadLastErrorTime", query = "SELECT m FROM Machines m WHERE m.ekentActivityFilesUploadLastErrorTime = :ekentActivityFilesUploadLastErrorTime")
    , @NamedQuery(name = "Machines.findByEkentActivityFilesUploadLastErrorMessage", query = "SELECT m FROM Machines m WHERE m.ekentActivityFilesUploadLastErrorMessage = :ekentActivityFilesUploadLastErrorMessage")
    , @NamedQuery(name = "Machines.findByLastStatusCheckTime", query = "SELECT m FROM Machines m WHERE m.lastStatusCheckTime = :lastStatusCheckTime")
    , @NamedQuery(name = "Machines.findByLastActivityTime", query = "SELECT m FROM Machines m WHERE m.lastActivityTime = :lastActivityTime")
    , @NamedQuery(name = "Machines.findByLastUpdateTime", query = "SELECT m FROM Machines m WHERE m.lastUpdateTime = :lastUpdateTime")
    , @NamedQuery(name = "Machines.findByLastSentTime", query = "SELECT m FROM Machines m WHERE m.lastSentTime = :lastSentTime")
    , @NamedQuery(name = "Machines.findByUpdaterLastStartedOn", query = "SELECT m FROM Machines m WHERE m.updaterLastStartedOn = :updaterLastStartedOn")
    , @NamedQuery(name = "Machines.findByActivityLogUploaderLastStartedOn", query = "SELECT m FROM Machines m WHERE m.activityLogUploaderLastStartedOn = :activityLogUploaderLastStartedOn")
    , @NamedQuery(name = "Machines.findByAlertLogUploaderLastStartedOn", query = "SELECT m FROM Machines m WHERE m.alertLogUploaderLastStartedOn = :alertLogUploaderLastStartedOn")
    , @NamedQuery(name = "Machines.findByCITReportUploaderLastStartedOn", query = "SELECT m FROM Machines m WHERE m.cITReportUploaderLastStartedOn = :cITReportUploaderLastStartedOn")
    , @NamedQuery(name = "Machines.findByMachineUploaderLastStartedOn", query = "SELECT m FROM Machines m WHERE m.machineUploaderLastStartedOn = :machineUploaderLastStartedOn")
    , @NamedQuery(name = "Machines.findByTresholdControllerLastStartedOn", query = "SELECT m FROM Machines m WHERE m.tresholdControllerLastStartedOn = :tresholdControllerLastStartedOn")
    , @NamedQuery(name = "Machines.findByDownloadedFileUpdateTime", query = "SELECT m FROM Machines m WHERE m.downloadedFileUpdateTime = :downloadedFileUpdateTime")
    , @NamedQuery(name = "Machines.findByCurrentUpdateFileVersion", query = "SELECT m FROM Machines m WHERE m.currentUpdateFileVersion = :currentUpdateFileVersion")
    , @NamedQuery(name = "Machines.findByWaitingUpdateFileVersion", query = "SELECT m FROM Machines m WHERE m.waitingUpdateFileVersion = :waitingUpdateFileVersion")
    , @NamedQuery(name = "Machines.findByDownloadedScriptUpdateTime", query = "SELECT m FROM Machines m WHERE m.downloadedScriptUpdateTime = :downloadedScriptUpdateTime")
    , @NamedQuery(name = "Machines.findByCurrentUpdateScriptVersion", query = "SELECT m FROM Machines m WHERE m.currentUpdateScriptVersion = :currentUpdateScriptVersion")
    , @NamedQuery(name = "Machines.findByWaitingUpdateScriptVersion", query = "SELECT m FROM Machines m WHERE m.waitingUpdateScriptVersion = :waitingUpdateScriptVersion")
    , @NamedQuery(name = "Machines.findByDownloadedBannerUpdateTime", query = "SELECT m FROM Machines m WHERE m.downloadedBannerUpdateTime = :downloadedBannerUpdateTime")
    , @NamedQuery(name = "Machines.findByCurrentBannerVersion", query = "SELECT m FROM Machines m WHERE m.currentBannerVersion = :currentBannerVersion")
    , @NamedQuery(name = "Machines.findByWaitingBannerVersion", query = "SELECT m FROM Machines m WHERE m.waitingBannerVersion = :waitingBannerVersion")
    , @NamedQuery(name = "Machines.findByDownloadedEKentUpdateTime", query = "SELECT m FROM Machines m WHERE m.downloadedEKentUpdateTime = :downloadedEKentUpdateTime")
    , @NamedQuery(name = "Machines.findByCurrentEKentVersion", query = "SELECT m FROM Machines m WHERE m.currentEKentVersion = :currentEKentVersion")
    , @NamedQuery(name = "Machines.findByWaitingEKentVersion", query = "SELECT m FROM Machines m WHERE m.waitingEKentVersion = :waitingEKentVersion")
    , @NamedQuery(name = "Machines.findByCreatedDate", query = "SELECT m FROM Machines m WHERE m.createdDate = :createdDate")
    , @NamedQuery(name = "Machines.findByStatus", query = "SELECT m FROM Machines m WHERE m.status = :status")
    , @NamedQuery(name = "Machines.findByClessReaderIsAlive", query = "SELECT m FROM Machines m WHERE m.clessReaderIsAlive = :clessReaderIsAlive")
    , @NamedQuery(name = "Machines.findByClessReaderStatus", query = "SELECT m FROM Machines m WHERE m.clessReaderStatus = :clessReaderStatus")})
public class Machines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GroupId")
    private int groupId;
    @Column(name = "MachineId")
    private Integer machineId;
    @Column(name = "TypeId")
    private Integer typeId;
    @Size(max = 4000)
    @Column(name = "Description")
    private String description;
    @Column(name = "HopperComIsOpen")
    private Boolean hopperComIsOpen;
    @Column(name = "HopperIsAlive")
    private Boolean hopperIsAlive;
    @Size(max = 1000)
    @Column(name = "HopperDeviceInfo")
    private String hopperDeviceInfo;
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
    @Size(max = 1000)
    @Column(name = "IProRCDeviceInfo")
    private String iProRCDeviceInfo;
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
    @Column(name = "KGBHasError")
    private Boolean kGBHasError;
    @Column(name = "KGBTicketInside")
    private Boolean kGBTicketInside;
    @Column(name = "KGBTicketJam")
    private Boolean kGBTicketJam;
    @Column(name = "KGBLifeCheckState")
    private Short kGBLifeCheckState;
    @Size(max = 50)
    @Column(name = "KGBLifeCheckStateInString")
    private String kGBLifeCheckStateInString;
    @Column(name = "KGBLastOperationStatus")
    private Boolean kGBLastOperationStatus;
    @Size(max = 20)
    @Column(name = "KGBErrorCode")
    private String kGBErrorCode;
    @Size(max = 1000)
    @Column(name = "KGBLastErrors")
    private String kGBLastErrors;
    @Column(name = "ValidatorComIsOpen")
    private Boolean validatorComIsOpen;
    @Column(name = "ValidatorIsAlive")
    private Boolean validatorIsAlive;
    @Column(name = "CardDispanserComIsOpen")
    private Boolean cardDispanserComIsOpen;
    @Column(name = "CardDispanserIsAlive")
    private Boolean cardDispanserIsAlive;
    @Column(name = "CardDispanserCardStatus")
    private Integer cardDispanserCardStatus;
    @Column(name = "CardDispanserIsBinFull")
    private Boolean cardDispanserIsBinFull;
    @Column(name = "PrinterHasError")
    private Boolean printerHasError;
    @Column(name = "PrinterIsOffline")
    private Boolean printerIsOffline;
    @Column(name = "PrinterIsOutOfPaper")
    private Boolean printerIsOutOfPaper;
    @Column(name = "PrinterPaperIsNearToEnd")
    private Boolean printerPaperIsNearToEnd;
    @Column(name = "MachineControlCardIsAlive")
    private Boolean machineControlCardIsAlive;
    @Column(name = "MachineHumidity")
    private Integer machineHumidity;
    @Column(name = "MachineTemperature")
    private Integer machineTemperature;
    @Column(name = "MachineInteriorDoorStatus")
    private Integer machineInteriorDoorStatus;
    @Column(name = "MachineExteriorDoorStatus")
    private Integer machineExteriorDoorStatus;
    @Column(name = "MachineInsideLighting")
    private Boolean machineInsideLighting;
    @Column(name = "MachineOutsideLighting")
    private Boolean machineOutsideLighting;
    @Column(name = "EtopupFileDownloadLastAttemptTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etopupFileDownloadLastAttemptTime;
    @Column(name = "EtopupFileDownloadLastSuccessTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etopupFileDownloadLastSuccessTime;
    @Column(name = "EtopupFileDownloadLastErrorTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etopupFileDownloadLastErrorTime;
    @Size(max = 1000)
    @Column(name = "EtopupFileDownloadLastErrorMessage")
    private String etopupFileDownloadLastErrorMessage;
    @Column(name = "EkentActivityFilesUploadLastAttemptTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ekentActivityFilesUploadLastAttemptTime;
    @Column(name = "EkentActivityFilesUploadLastSuccessTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ekentActivityFilesUploadLastSuccessTime;
    @Column(name = "EkentActivityFilesUploadLastErrorTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ekentActivityFilesUploadLastErrorTime;
    @Size(max = 1000)
    @Column(name = "EkentActivityFilesUploadLastErrorMessage")
    private String ekentActivityFilesUploadLastErrorMessage;
    @Column(name = "LastStatusCheckTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastStatusCheckTime;
    @Column(name = "LastActivityTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastActivityTime;
    @Column(name = "LastUpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;
    @Column(name = "LastSentTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSentTime;
    @Column(name = "UpdaterLastStartedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updaterLastStartedOn;
    @Column(name = "ActivityLogUploaderLastStartedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityLogUploaderLastStartedOn;
    @Column(name = "AlertLogUploaderLastStartedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alertLogUploaderLastStartedOn;
    @Column(name = "CITReportUploaderLastStartedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cITReportUploaderLastStartedOn;
    @Column(name = "MachineUploaderLastStartedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date machineUploaderLastStartedOn;
    @Column(name = "TresholdControllerLastStartedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tresholdControllerLastStartedOn;
    @Column(name = "DownloadedFileUpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date downloadedFileUpdateTime;
    @Column(name = "CurrentUpdateFileVersion")
    private Integer currentUpdateFileVersion;
    @Column(name = "WaitingUpdateFileVersion")
    private Integer waitingUpdateFileVersion;
    @Column(name = "DownloadedScriptUpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date downloadedScriptUpdateTime;
    @Column(name = "CurrentUpdateScriptVersion")
    private Integer currentUpdateScriptVersion;
    @Column(name = "WaitingUpdateScriptVersion")
    private Integer waitingUpdateScriptVersion;
    @Column(name = "DownloadedBannerUpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date downloadedBannerUpdateTime;
    @Column(name = "CurrentBannerVersion")
    private Integer currentBannerVersion;
    @Column(name = "WaitingBannerVersion")
    private Integer waitingBannerVersion;
    @Column(name = "DownloadedEKentUpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date downloadedEKentUpdateTime;
    @Column(name = "CurrentEKentVersion")
    private Integer currentEKentVersion;
    @Column(name = "WaitingEKentVersion")
    private Integer waitingEKentVersion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @Column(name = "ClessReaderIsAlive")
    private Boolean clessReaderIsAlive;
    @Size(max = 1000)
    @Column(name = "ClessReaderStatus")
    private String clessReaderStatus;

    public Machines() {
    }

    public Machines(Integer id) {
        this.id = id;
    }

    public Machines(Integer id, int groupId, Date createdDate, int status) {
        this.id = id;
        this.groupId = groupId;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getHopperDeviceInfo() {
        return hopperDeviceInfo;
    }

    public void setHopperDeviceInfo(String hopperDeviceInfo) {
        this.hopperDeviceInfo = hopperDeviceInfo;
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

    public String getIProRCDeviceInfo() {
        return iProRCDeviceInfo;
    }

    public void setIProRCDeviceInfo(String iProRCDeviceInfo) {
        this.iProRCDeviceInfo = iProRCDeviceInfo;
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

    public Boolean getKGBHasError() {
        return kGBHasError;
    }

    public void setKGBHasError(Boolean kGBHasError) {
        this.kGBHasError = kGBHasError;
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

    public Short getKGBLifeCheckState() {
        return kGBLifeCheckState;
    }

    public void setKGBLifeCheckState(Short kGBLifeCheckState) {
        this.kGBLifeCheckState = kGBLifeCheckState;
    }

    public String getKGBLifeCheckStateInString() {
        return kGBLifeCheckStateInString;
    }

    public void setKGBLifeCheckStateInString(String kGBLifeCheckStateInString) {
        this.kGBLifeCheckStateInString = kGBLifeCheckStateInString;
    }

    public Boolean getKGBLastOperationStatus() {
        return kGBLastOperationStatus;
    }

    public void setKGBLastOperationStatus(Boolean kGBLastOperationStatus) {
        this.kGBLastOperationStatus = kGBLastOperationStatus;
    }

    public String getKGBErrorCode() {
        return kGBErrorCode;
    }

    public void setKGBErrorCode(String kGBErrorCode) {
        this.kGBErrorCode = kGBErrorCode;
    }

    public String getKGBLastErrors() {
        return kGBLastErrors;
    }

    public void setKGBLastErrors(String kGBLastErrors) {
        this.kGBLastErrors = kGBLastErrors;
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

    public Boolean getCardDispanserComIsOpen() {
        return cardDispanserComIsOpen;
    }

    public void setCardDispanserComIsOpen(Boolean cardDispanserComIsOpen) {
        this.cardDispanserComIsOpen = cardDispanserComIsOpen;
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

    public Boolean getCardDispanserIsBinFull() {
        return cardDispanserIsBinFull;
    }

    public void setCardDispanserIsBinFull(Boolean cardDispanserIsBinFull) {
        this.cardDispanserIsBinFull = cardDispanserIsBinFull;
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

    public Boolean getPrinterIsOutOfPaper() {
        return printerIsOutOfPaper;
    }

    public void setPrinterIsOutOfPaper(Boolean printerIsOutOfPaper) {
        this.printerIsOutOfPaper = printerIsOutOfPaper;
    }

    public Boolean getPrinterPaperIsNearToEnd() {
        return printerPaperIsNearToEnd;
    }

    public void setPrinterPaperIsNearToEnd(Boolean printerPaperIsNearToEnd) {
        this.printerPaperIsNearToEnd = printerPaperIsNearToEnd;
    }

    public Boolean getMachineControlCardIsAlive() {
        return machineControlCardIsAlive;
    }

    public void setMachineControlCardIsAlive(Boolean machineControlCardIsAlive) {
        this.machineControlCardIsAlive = machineControlCardIsAlive;
    }

    public Integer getMachineHumidity() {
        return machineHumidity;
    }

    public void setMachineHumidity(Integer machineHumidity) {
        this.machineHumidity = machineHumidity;
    }

    public Integer getMachineTemperature() {
        return machineTemperature;
    }

    public void setMachineTemperature(Integer machineTemperature) {
        this.machineTemperature = machineTemperature;
    }

    public Integer getMachineInteriorDoorStatus() {
        return machineInteriorDoorStatus;
    }

    public void setMachineInteriorDoorStatus(Integer machineInteriorDoorStatus) {
        this.machineInteriorDoorStatus = machineInteriorDoorStatus;
    }

    public Integer getMachineExteriorDoorStatus() {
        return machineExteriorDoorStatus;
    }

    public void setMachineExteriorDoorStatus(Integer machineExteriorDoorStatus) {
        this.machineExteriorDoorStatus = machineExteriorDoorStatus;
    }

    public Boolean getMachineInsideLighting() {
        return machineInsideLighting;
    }

    public void setMachineInsideLighting(Boolean machineInsideLighting) {
        this.machineInsideLighting = machineInsideLighting;
    }

    public Boolean getMachineOutsideLighting() {
        return machineOutsideLighting;
    }

    public void setMachineOutsideLighting(Boolean machineOutsideLighting) {
        this.machineOutsideLighting = machineOutsideLighting;
    }

    public Date getEtopupFileDownloadLastAttemptTime() {
        return etopupFileDownloadLastAttemptTime;
    }

    public void setEtopupFileDownloadLastAttemptTime(Date etopupFileDownloadLastAttemptTime) {
        this.etopupFileDownloadLastAttemptTime = etopupFileDownloadLastAttemptTime;
    }

    public Date getEtopupFileDownloadLastSuccessTime() {
        return etopupFileDownloadLastSuccessTime;
    }

    public void setEtopupFileDownloadLastSuccessTime(Date etopupFileDownloadLastSuccessTime) {
        this.etopupFileDownloadLastSuccessTime = etopupFileDownloadLastSuccessTime;
    }

    public Date getEtopupFileDownloadLastErrorTime() {
        return etopupFileDownloadLastErrorTime;
    }

    public void setEtopupFileDownloadLastErrorTime(Date etopupFileDownloadLastErrorTime) {
        this.etopupFileDownloadLastErrorTime = etopupFileDownloadLastErrorTime;
    }

    public String getEtopupFileDownloadLastErrorMessage() {
        return etopupFileDownloadLastErrorMessage;
    }

    public void setEtopupFileDownloadLastErrorMessage(String etopupFileDownloadLastErrorMessage) {
        this.etopupFileDownloadLastErrorMessage = etopupFileDownloadLastErrorMessage;
    }

    public Date getEkentActivityFilesUploadLastAttemptTime() {
        return ekentActivityFilesUploadLastAttemptTime;
    }

    public void setEkentActivityFilesUploadLastAttemptTime(Date ekentActivityFilesUploadLastAttemptTime) {
        this.ekentActivityFilesUploadLastAttemptTime = ekentActivityFilesUploadLastAttemptTime;
    }

    public Date getEkentActivityFilesUploadLastSuccessTime() {
        return ekentActivityFilesUploadLastSuccessTime;
    }

    public void setEkentActivityFilesUploadLastSuccessTime(Date ekentActivityFilesUploadLastSuccessTime) {
        this.ekentActivityFilesUploadLastSuccessTime = ekentActivityFilesUploadLastSuccessTime;
    }

    public Date getEkentActivityFilesUploadLastErrorTime() {
        return ekentActivityFilesUploadLastErrorTime;
    }

    public void setEkentActivityFilesUploadLastErrorTime(Date ekentActivityFilesUploadLastErrorTime) {
        this.ekentActivityFilesUploadLastErrorTime = ekentActivityFilesUploadLastErrorTime;
    }

    public String getEkentActivityFilesUploadLastErrorMessage() {
        return ekentActivityFilesUploadLastErrorMessage;
    }

    public void setEkentActivityFilesUploadLastErrorMessage(String ekentActivityFilesUploadLastErrorMessage) {
        this.ekentActivityFilesUploadLastErrorMessage = ekentActivityFilesUploadLastErrorMessage;
    }

    public Date getLastStatusCheckTime() {
        return lastStatusCheckTime;
    }

    public void setLastStatusCheckTime(Date lastStatusCheckTime) {
        this.lastStatusCheckTime = lastStatusCheckTime;
    }

    public Date getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Date lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastSentTime() {
        return lastSentTime;
    }

    public void setLastSentTime(Date lastSentTime) {
        this.lastSentTime = lastSentTime;
    }

    public Date getUpdaterLastStartedOn() {
        return updaterLastStartedOn;
    }

    public void setUpdaterLastStartedOn(Date updaterLastStartedOn) {
        this.updaterLastStartedOn = updaterLastStartedOn;
    }

    public Date getActivityLogUploaderLastStartedOn() {
        return activityLogUploaderLastStartedOn;
    }

    public void setActivityLogUploaderLastStartedOn(Date activityLogUploaderLastStartedOn) {
        this.activityLogUploaderLastStartedOn = activityLogUploaderLastStartedOn;
    }

    public Date getAlertLogUploaderLastStartedOn() {
        return alertLogUploaderLastStartedOn;
    }

    public void setAlertLogUploaderLastStartedOn(Date alertLogUploaderLastStartedOn) {
        this.alertLogUploaderLastStartedOn = alertLogUploaderLastStartedOn;
    }

    public Date getCITReportUploaderLastStartedOn() {
        return cITReportUploaderLastStartedOn;
    }

    public void setCITReportUploaderLastStartedOn(Date cITReportUploaderLastStartedOn) {
        this.cITReportUploaderLastStartedOn = cITReportUploaderLastStartedOn;
    }

    public Date getMachineUploaderLastStartedOn() {
        return machineUploaderLastStartedOn;
    }

    public void setMachineUploaderLastStartedOn(Date machineUploaderLastStartedOn) {
        this.machineUploaderLastStartedOn = machineUploaderLastStartedOn;
    }

    public Date getTresholdControllerLastStartedOn() {
        return tresholdControllerLastStartedOn;
    }

    public void setTresholdControllerLastStartedOn(Date tresholdControllerLastStartedOn) {
        this.tresholdControllerLastStartedOn = tresholdControllerLastStartedOn;
    }

    public Date getDownloadedFileUpdateTime() {
        return downloadedFileUpdateTime;
    }

    public void setDownloadedFileUpdateTime(Date downloadedFileUpdateTime) {
        this.downloadedFileUpdateTime = downloadedFileUpdateTime;
    }

    public Integer getCurrentUpdateFileVersion() {
        return currentUpdateFileVersion;
    }

    public void setCurrentUpdateFileVersion(Integer currentUpdateFileVersion) {
        this.currentUpdateFileVersion = currentUpdateFileVersion;
    }

    public Integer getWaitingUpdateFileVersion() {
        return waitingUpdateFileVersion;
    }

    public void setWaitingUpdateFileVersion(Integer waitingUpdateFileVersion) {
        this.waitingUpdateFileVersion = waitingUpdateFileVersion;
    }

    public Date getDownloadedScriptUpdateTime() {
        return downloadedScriptUpdateTime;
    }

    public void setDownloadedScriptUpdateTime(Date downloadedScriptUpdateTime) {
        this.downloadedScriptUpdateTime = downloadedScriptUpdateTime;
    }

    public Integer getCurrentUpdateScriptVersion() {
        return currentUpdateScriptVersion;
    }

    public void setCurrentUpdateScriptVersion(Integer currentUpdateScriptVersion) {
        this.currentUpdateScriptVersion = currentUpdateScriptVersion;
    }

    public Integer getWaitingUpdateScriptVersion() {
        return waitingUpdateScriptVersion;
    }

    public void setWaitingUpdateScriptVersion(Integer waitingUpdateScriptVersion) {
        this.waitingUpdateScriptVersion = waitingUpdateScriptVersion;
    }

    public Date getDownloadedBannerUpdateTime() {
        return downloadedBannerUpdateTime;
    }

    public void setDownloadedBannerUpdateTime(Date downloadedBannerUpdateTime) {
        this.downloadedBannerUpdateTime = downloadedBannerUpdateTime;
    }

    public Integer getCurrentBannerVersion() {
        return currentBannerVersion;
    }

    public void setCurrentBannerVersion(Integer currentBannerVersion) {
        this.currentBannerVersion = currentBannerVersion;
    }

    public Integer getWaitingBannerVersion() {
        return waitingBannerVersion;
    }

    public void setWaitingBannerVersion(Integer waitingBannerVersion) {
        this.waitingBannerVersion = waitingBannerVersion;
    }

    public Date getDownloadedEKentUpdateTime() {
        return downloadedEKentUpdateTime;
    }

    public void setDownloadedEKentUpdateTime(Date downloadedEKentUpdateTime) {
        this.downloadedEKentUpdateTime = downloadedEKentUpdateTime;
    }

    public Integer getCurrentEKentVersion() {
        return currentEKentVersion;
    }

    public void setCurrentEKentVersion(Integer currentEKentVersion) {
        this.currentEKentVersion = currentEKentVersion;
    }

    public Integer getWaitingEKentVersion() {
        return waitingEKentVersion;
    }

    public void setWaitingEKentVersion(Integer waitingEKentVersion) {
        this.waitingEKentVersion = waitingEKentVersion;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getClessReaderIsAlive() {
        return clessReaderIsAlive;
    }

    public void setClessReaderIsAlive(Boolean clessReaderIsAlive) {
        this.clessReaderIsAlive = clessReaderIsAlive;
    }

    public String getClessReaderStatus() {
        return clessReaderStatus;
    }

    public void setClessReaderStatus(String clessReaderStatus) {
        this.clessReaderStatus = clessReaderStatus;
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
        if (!(object instanceof Machines)) {
            return false;
        }
        Machines other = (Machines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Machines[ id=" + id + " ]";
    }
    
}
