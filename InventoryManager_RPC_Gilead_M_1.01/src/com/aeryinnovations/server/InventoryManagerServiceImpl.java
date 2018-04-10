package com.aeryinnovations.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.aeryinnovations.client.InventoryManagerService;
import com.aeryinnovations.shared.JPAUtil;
import com.aeryinnovations.shared.coredomain.SparePartSpecification;
import com.aeryinnovations.shared.coredomain.StockReceipt;
import com.aeryinnovations.shared.coredomain.StockReceiptLineItem;

import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.core.hibernate.jpa.JpaUtil;
import net.sf.gilead.core.store.stateless.StatelessProxyStore;
import net.sf.gilead.gwt.GwtConfigurationHelper;
import net.sf.gilead.gwt.PersistentRemoteService;

@SuppressWarnings("serial")
public class InventoryManagerServiceImpl extends PersistentRemoteService implements InventoryManagerService{
	
	public InventoryManagerServiceImpl() {
		final EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		
		final PersistentBeanManager persistentBeanManager = GwtConfigurationHelper.initGwtStatelessBeanManager(new JpaUtil(emf));
		//final PersistentBeanManager persistentBeanManager = new PersistentBeanManager();
		
		//persistentBeanManager.setPersistenceUtil(new JpaUtil(emf));
		persistentBeanManager.setProxyStore(new StatelessProxyStore());
		setBeanManager(persistentBeanManager);
	}
	
	@SuppressWarnings("unchecked")
	public List<SparePartSpecification> loadSpecifications(){
	  List<SparePartSpecification> sparePartSpecs = new ArrayList<SparePartSpecification>();
		 
	  //Load from database
	  EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	  EntityTransaction tx = em.getTransaction();
	  tx.begin();
	  sparePartSpecs = em.createQuery(
			"SELECT p FROM SparePartSpecification p order by p.spSpecId asc")
			  .getResultList();
	  tx.commit();
	  em.close();
		
	  return sparePartSpecs;
	}

	@Override
	public Long saveStockReceiptLineItem(StockReceiptLineItem srli) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(srli);
		
		tx.commit();
		em.close();
		
		return srli.getStockReceiptLineItemId();
	}

	@Override
	public Long saveStockReceipt(StockReceipt sr) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(sr);
		
		tx.commit();
		em.close();
		
		return sr.getStockReceiptId();
	}
	

}	