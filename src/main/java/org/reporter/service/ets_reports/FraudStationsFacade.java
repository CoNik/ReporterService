/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author constantinn
 */
@Stateless
public class FraudStationsFacade extends AbstractFacade<FraudStations> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public FraudStationsFacade() {
        super(FraudStations.class);
    }
    
}
