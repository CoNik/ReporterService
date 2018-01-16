package org.reporter.service.ets_reports.nosql;
/**
 *  ETS Project
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 *
 * Class used to store data from cassandra location_work table
 * The class is JSON enabled in order to facilitate the usage in RS services
 * Persistence is made using jdbc driver
 * and LocationWorkFacade class functionality
 *
 * Author: constantinn
 * Date: 2017 12 20
 */
import com.datastax.driver.mapping.annotations.Transient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({
        "id" ,
        "cardid" ,
        "createdate" ,
        "currentbalanc" ,
        "currentpasscount" ,
        "customerid" ,
        "loyaltypasscount" ,
        "opt_station_list" ,
        "opt_station_list_ts" ,
        "stationid_entrance" ,
        "station_id_exit" ,
        "status" ,
        "travel_time" ,
        "ts_entrance" ,
        "ts_exit" ,
        "validationdate" ,
        "validator_code_entrance" ,
        "validator_code_exit"

        })
public class LocationWorkData extends EtsData {
    @Transient
    @JsonIgnore
    private String tableName = "ets.location_work_time";

    @JsonProperty("id")
    private UUID id; // uuid,

    @JsonProperty("cardid")
    private long cardid; // bigint,

    @JsonProperty("createdate")
    private Date createdate; // timestamp,

    @JsonProperty("icurrentbalance")
    private double currentbalance; // double,

    @JsonProperty("currentpasscount")
    private double currentpasscount; // double,

    @JsonProperty("customerid")
    private long customerid; // bigint,

    @JsonProperty("loyaltypasscount")
    private double loyaltypasscount; // double,

    @JsonProperty("opt_station_list")
    private List<Long> opt_station_list; // LIST<bigint>,

    @JsonProperty("opt_station_list_ts")
    private List<Date> opt_station_list_ts; // LIST<timestamp>,

    @JsonProperty("stationid_entrance")
    private long stationid_entrance; // bigint,

    @JsonProperty("station_id_exit")
    private long station_id_exit; // bigint,

    @JsonProperty("status")
    private String status; // text,

    @JsonProperty("travel_time")
    private int travel_time; // int,

    @JsonProperty("ts_entrance")
    private Date ts_entrance; // timestamp,

    @JsonProperty("ts_exit")
    private Date ts_exit; // timestamp,

    @JsonProperty("validationdate")
    private Date validationdate; // timestamp,

    @JsonProperty("validator_code_entrance")
    private String validator_code_entrance; // text,

    @JsonProperty("ivalidator_code_exit")
    private String validator_code_exit; // text,


    /**
     * Default constructor
     * Initialize id using random generator
     */
    public LocationWorkData() {
        id = UUID.randomUUID();
    }

    /**
     * Contructor used to initialize fields with random values
     * Lists remains null
     * @param stype (if it is "random", then rasndom values for all fields except lists are generated)
     */
    public LocationWorkData(String stype) {
        // this constructor generated randomly the data
        id = UUID.randomUUID();

        if (stype.equalsIgnoreCase("random")) {
            randomizeFields();
        }

    }

    /**
     * Constructor used to initialize fields with random values
     * Lists remains null
     * @param noList (if it is >=0, then rasndom values for all fields including lists are generated)
     */
    public LocationWorkData(int noList) {
        // this constructor generated randomly the data
        id = UUID.randomUUID();

        if (noList >= 0) {
            Date dn = new Date();
            long ld = dn.getTime() - EtsUtils.randL(10000, 20000);
            Date dn1 = new Date(ld);
            randomizeFields();

            for (int ii = 0; ii < noList; ii++) {
                long l = EtsUtils.randL(0l, 100l);
                opt_station_list.add(l);

                ld = dn.getTime() - EtsUtils.randL(10000, 20000);
                dn1 = new Date(ld);
                opt_station_list_ts.add(dn1);
            }
        }

    }
    
     public LocationWorkData(long pCardId, Date pCreateDate, double pCurrentbalance, double pCurrentpasscount, long pCustomerid,
                             double pLoyaltypasscount, long pStationIdExit, long pStationIdEntrance, String pStatus , 
                             List<Long> pOptStationList, List<Date>  pOptStationListTs, int pTravelTime, Date pTsEntrance, Date pTsExit,Date pValidationDate,
                             String pValidatorCodeEntrance, String pValidatorCodeExit){
         
         id = UUID.randomUUID();
         this.cardid = pCardId;
         this.createdate = pCreateDate;
         this.currentbalance = pCurrentbalance;
         this.currentpasscount = pCurrentpasscount;
         this.customerid = pCustomerid;
         this.loyaltypasscount = pLoyaltypasscount;
         this.station_id_exit = pStationIdExit;
         this.stationid_entrance = pStationIdEntrance;
         this.status = pStatus;
         this.opt_station_list = pOptStationList;
         this.opt_station_list_ts = pOptStationListTs;
         this.travel_time = pTravelTime;
         this.ts_entrance = pTsEntrance;
         this.ts_exit = pTsExit;
         this.validationdate = pValidationDate;
         this.validator_code_entrance = pValidatorCodeEntrance;
         this.validator_code_exit = pValidatorCodeExit;
         
     }

    /**
     * Initializes fields with random values
     */
    private void randomizeFields(){
        Date dn = new Date();
        long ld = dn.getTime() - EtsUtils.randL(10000, 20000);
        Date dn1 = new Date(ld);

        cardid = EtsUtils.randL(0l, 10000L); //       + " card_id, "

        createdate = dn1; //+ " createdate, "

        currentbalance = EtsUtils.randD(0L, 1000000L); //+ " currentbalance, "
        currentpasscount = EtsUtils.randD(0, 1000l); //+ " currentpasscount, "

        customerid = EtsUtils.randL(0l, 10000L); // + " customerid, "
        loyaltypasscount = EtsUtils.randD(0l, 1000L); // + " loyaltypasscount, " // double,
        // TODO
        //opt_station_list LIST<bigint>,
        //opt_station_list_ts LIST<timestamp>,

        stationid_entrance = EtsUtils.randL(0l, 100L); // + " stationid_entrance, " // bigint,
        station_id_exit = EtsUtils.randL(0l, 100L); // + " station_id_exit, " // bigint,
        status = "status " + EtsUtils.randL(0l, 10L); // " status, " // text,
        travel_time = (int) EtsUtils.randL(0l, 100L); // + " travel_time, " // int,
        ts_entrance = dn1; //+ " ts_entrance, " // timestamp,
        ts_exit = dn; //+ " ts_exit, " // timestamp,
        validationdate = dn; //+ " validationdate, " // timestamp,

        validator_code_entrance = "IN" + EtsUtils.randL(0l, 10L); // + " validator_code_entrance, " // text,
        validator_code_exit = "OUT" + EtsUtils.randL(0l, 10L);  //+ " validator_code_exit " // text,

        opt_station_list = new ArrayList<>();

        opt_station_list_ts = new ArrayList<>();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        String ss = id.toString() + " - " +
                cardid  + " - " +
                sdf.format(createdate)  + " - " +
                currentbalance  + " - " +
                currentpasscount  + " - " +
                customerid  + " - " +
                loyaltypasscount + " - " +
                stationid_entrance + " - " +
                station_id_exit + " - " +
                status + " - " +
                travel_time + " - " +
                sdf.format(ts_entrance) + " - " +
                sdf.format(ts_exit)+ " - " +
                sdf.format(validationdate)+ " - " +
                validator_code_entrance + " - " +
                validator_code_exit;
        return ss;

    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getCardid() {
        return cardid;
    }

    public void setCardid(long cardid) {
        this.cardid = cardid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public double getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(double currentbalance) {
        this.currentbalance = currentbalance;
    }

    public double getCurrentpasscount() {
        return currentpasscount;
    }

    public void setCurrentpasscount(double currentpasscount) {
        this.currentpasscount = currentpasscount;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public double getLoyaltypasscount() {
        return loyaltypasscount;
    }

    public void setLoyaltypasscount(double loyaltypasscount) {
        this.loyaltypasscount = loyaltypasscount;
    }

    public List<Long> getOpt_station_list() {
        return opt_station_list;
    }

    public void setOpt_station_list(List<Long> opt_station_list) {
        this.opt_station_list = opt_station_list;
    }

    public List<Date> getOpt_station_list_ts() {
        return opt_station_list_ts;
    }

    public void setOpt_station_list_ts(List<Date> opt_station_list_ts) {
        this.opt_station_list_ts = opt_station_list_ts;
    }

    public long getStationid_entrance() {
        return stationid_entrance;
    }

    public void setStationid_entrance(long stationid_entrance) {
        this.stationid_entrance = stationid_entrance;
    }

    public long getStation_id_exit() {
        return station_id_exit;
    }

    public void setStation_id_exit(long station_id_exit) {
        this.station_id_exit = station_id_exit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTravel_time() {
        return travel_time;
    }

    public void setTravel_time(int travel_time) {
        this.travel_time = travel_time;
    }

    public Date getTs_entrance() {
        return ts_entrance;
    }

    public void setTs_entrance(Date ts_entrance) {
        this.ts_entrance = ts_entrance;
    }

    public Date getTs_exit() {
        return ts_exit;
    }

    public void setTs_exit(Date ts_exit) {
        this.ts_exit = ts_exit;
    }

    public Date getValidationdate() {
        return validationdate;
    }

    public void setValidationdate(Date validationdate) {
        this.validationdate = validationdate;
    }

    public String getValidator_code_entrance() {
        return validator_code_entrance;
    }

    public void setValidator_code_entrance(String validator_code_entrance) {
        this.validator_code_entrance = validator_code_entrance;
    }

    public String getValidator_code_exit() {
        return validator_code_exit;
    }

    public void setValidator_code_exit(String validator_code_exit) {
        this.validator_code_exit = validator_code_exit;
    }
}
