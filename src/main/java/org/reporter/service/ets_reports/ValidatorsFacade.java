/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author constantinn
 */
@Stateless
public class ValidatorsFacade extends AbstractFacade<Validators> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValidatorsFacade() {
        super(Validators.class);
    }
    
      //get station id 
    public Long getStationIdbyValidatorCode(String pValidatorCode){
        
        TypedQuery<Stations> getStationIdQuery = em.createQuery("SELECT c.stationId  FROM Validators c "
                                                                + " WHERE c.validatorsPK.validatorCode = :vValidatorCode ", Stations.class);
        getStationIdQuery.setParameter("vValidatorCode", pValidatorCode);
        Long stationId = 0l;
        Stations stationsObj= null;
        try{   
            stationsObj = (Stations)(getStationIdQuery.getSingleResult());
            if(stationsObj != null){
                stationId = stationsObj.getStationId();
            }
        }
        catch(Exception ex){
         stationId = 0l;   
        }
        
        return stationId;
    }
    
}
