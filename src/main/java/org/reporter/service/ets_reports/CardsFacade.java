package org.reporter.service.ets_reports;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author constantinn
 */
@Stateless
public class CardsFacade extends AbstractFacade<Cards> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public CardsFacade() {
        super(Cards.class);
    }
    
     //get cardId and customerId from cards where card  number = ?
    public String getCardIdInfo(String pCardNumber){
        
        TypedQuery<Long> getCardIdQuery = em.createQuery("SELECT c.cardId  FROM Cards c WHERE c.cardNumber = :vCardNumber ", Long.class);
        getCardIdQuery.setParameter("vCardNumber", pCardNumber);
        // Long cardId = getCardIdQuery.getSingleResult();
        Long cardId = 0l;
        List<Long> results = getCardIdQuery.getResultList();
        if(!results.isEmpty()){
   
            cardId = results.get(0);
        }
        TypedQuery<BigInteger> getCustomerIdQuery = em.createQuery("SELECT c.customerId  FROM Cards c WHERE c.cardNumber = :vCardNumber ", BigInteger.class);
        getCustomerIdQuery.setParameter("vCardNumber", pCardNumber);
      //  BigInteger customerId = getCustomerIdQuery.getSingleResult();
       BigInteger customerId = BigInteger.valueOf(0);
       List<BigInteger> results1 = getCustomerIdQuery.getResultList();
       if(!results1.isEmpty()){
   
            customerId = results1.get(0);
        }
      
        String cardIdInfo = cardId + "/" + customerId;
       
        return cardIdInfo;
    }
}
