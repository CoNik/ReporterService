/*
 *  
 * Reporter Service 2018 Updates
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
public class DashboardInfoTFacade extends AbstractFacade<DashboardInfoT> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DashboardInfoTFacade() {
        super(DashboardInfoT.class);
    }
    
}
