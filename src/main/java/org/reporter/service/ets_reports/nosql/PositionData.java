package org.reporter.service.ets_reports.nosql;
/**
 *  ETS Project
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 *
 * Class used to store data from cassandra positions table
 * The class is JSON enabled in order to facilitate the usage in RS services
 * Persistence is made using jdbc driver
 * and PositionFacade class functionality
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
        "customerid" ,
        "location_latitude" ,
        "location_longitude" ,
        "location_ts" ,
        "travel_init_ts" ,
        "travel_end_ts"
})
public class PositionData extends EtsData{
    @Transient
    @JsonIgnore
    private String tableName = "ets.positions_time";

    @JsonProperty("id")
    private UUID id; // uuid,

    @JsonProperty("cardid")
    private long cardid; // bigint,

    @JsonProperty("customerid")
    private long customerid; // bigint,

    @JsonProperty("location_latitude")
    private List<Double> location_latitude; // LIST<float>,

    @JsonProperty("location_longitude")
    private List<Double> location_longitude; // LIST<float>,

    @JsonProperty("location_ts")
    private List<Date> location_ts; // LIST<timestamp>,

    @JsonProperty("travel_init_ts")
    private Date travel_init_ts; // timestamp,

    @JsonProperty("travel_end_ts")
    private Date travel_end_ts; // timestamp,

    /**
     * Default constructor
     * Initialize id using random generator
     */
    public PositionData(){
        id = UUID.randomUUID();
    }

    /**
     * Constructor used to initialize fields with random values
     * Lists remains null
     * @param stype (if it is "random", then rasndom values for all fields except lists are generated)
     */
    public PositionData(String stype){
        // this constructor generated randomly the data
        // list values are NOT generated
        id = UUID.randomUUID();
        Date dn = new Date();
        long ld = dn.getTime() -  EtsUtils.randL(10000, 20000);
        Date dn1 = new Date(ld);

        if(stype.equalsIgnoreCase("random")) {

            randomizeFields();
        }
    }
    
    public PositionData(long pcardid, long pcustomerid, List<Double> plocation_latitude, List<Double> plocation_longitude,
                        List<Date> plocation_ts, Date ptravel_init_ts, Date ptravel_end_ts ){
        
          id = UUID.randomUUID();
          this.cardid = pcardid;
          this.customerid = pcustomerid;
          this.location_latitude = plocation_latitude;
          this.location_longitude = plocation_longitude;
          this.location_ts = plocation_ts;
          this.travel_init_ts = ptravel_init_ts;
          this.travel_end_ts = ptravel_end_ts;
    }

    /**
     * Constructor used to initialize fields with random values
     * Lists remains null
     * @param noList (if it is >=0, then rasndom values for all fields including lists are generated)
     */
    public PositionData(int noList){
        // this constructor generated randomly the data
        // also the lst values are generated
        id = UUID.randomUUID();
        if(noList>=0) {
            Date dn = new Date();
            long ld = dn.getTime() -  EtsUtils.randL(10000, 20000);
            Date dn1 = new Date(ld);
            randomizeFields();

            for (int ii=0; ii<noList; ii++){
                Double d=EtsUtils.randD(0l, 180l);
                location_latitude.add(d);
                d=EtsUtils.randD(0l, 180l);
                location_longitude.add(d);
                ld = dn.getTime() -  EtsUtils.randL(10000, 20000);
                dn1 = new Date(ld);
                location_ts.add(dn1);
            }

        }
    }

    /**
     * Initializes fields with random data
     */
    private void randomizeFields(){
        Date dn = new Date();
        long ld = dn.getTime() -  EtsUtils.randL(10000, 20000);
        Date dn1 = new Date(ld);
        cardid = EtsUtils.randL(0l, 10000L); //       + " card_id, "
        customerid = EtsUtils.randL(0l, 10000L); // + " customerid, "
        // TODO
        //private List<Double> location_latitude; // LIST<float>,
        //private List<Double> location_longitude; // LIST<float>,
        //private List<Date> location_ts; // LIST<timestamp>,
        travel_init_ts = dn1; // timestamp,
        travel_end_ts = dn; // timestamp;

        location_latitude = new ArrayList<>();
        location_longitude = new ArrayList<>();

        location_ts = new ArrayList<>();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String ss = id.toString() + " - " +
                cardid  + " - " +
                customerid  + " - " +
                sdf.format(travel_init_ts)  + " - " +
                sdf.format(travel_end_ts)
                ;
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

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public List<Double> getLocation_latitude() {
        return location_latitude;
    }

    public void setLocation_latitude(List<Double> location_latitude) {
        this.location_latitude = location_latitude;
    }

    public List<Double> getLocation_longitude() {
        return location_longitude;
    }

    public void setLocation_longitude(List<Double> location_longitude) {
        this.location_longitude = location_longitude;
    }

    public List<Date> getLocation_ts() {
        return location_ts;
    }

    public void setLocation_ts(List<Date> location_ts) {
        this.location_ts = location_ts;
    }

    public Date getTravel_init_ts() {
        return travel_init_ts;
    }

    public void setTravel_init_ts(Date travel_init_ts) {
        this.travel_init_ts = travel_init_ts;
    }

    public Date getTravel_end_ts() {
        return travel_end_ts;
    }

    public void setTravel_end_ts(Date travel_end_ts) {
        this.travel_end_ts = travel_end_ts;
    }
}
