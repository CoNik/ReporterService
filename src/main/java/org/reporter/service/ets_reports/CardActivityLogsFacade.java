/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author constantinn
 */
@Stateless
public class CardActivityLogsFacade extends AbstractFacade<CardActivityLogs> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public CardActivityLogsFacade() {
        super(CardActivityLogs.class);
    }
     
    public List<CardActivityLogs> findAllCardActivityLogs() {
        
         TypedQuery<CardActivityLogs> findActivityLogsQuery = em.createQuery("SELECT c  FROM CardActivityLogs c ORDER BY c.sessionId, c.activityCode", CardActivityLogs.class);
         List<CardActivityLogs> cardActivityList = findActivityLogsQuery.getResultList();
         return cardActivityList;
   
    }
    
}
