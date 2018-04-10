package com.aeryinnovations.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.aeryinnovations.client.MessageService;
import com.aeryinnovations.shared.entities.Person;
import com.aeryinnovations.shared.JPAUtil;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import net.sf.gilead.core.PersistenceUtil;
import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.core.hibernate.jpa.JpaUtil;
import net.sf.gilead.core.store.stateless.StatelessProxyStore;
import net.sf.gilead.gwt.GwtConfigurationHelper;
import net.sf.gilead.gwt.PersistentRemoteService;

@SuppressWarnings("serial")
public class MessageServiceImpl extends PersistentRemoteService implements MessageService{
	
	public MessageServiceImpl() {
		final EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
		final PersistentBeanManager persistentBeanManager = GwtConfigurationHelper.initGwtStatelessBeanManager(new JpaUtil(emf));
		//final PersistentBeanManager persistentBeanManager = new PersistentBeanManager();
		
		//persistentBeanManager.setPersistenceUtil(new JpaUtil(emf));
		persistentBeanManager.setProxyStore(new StatelessProxyStore());
		setBeanManager(persistentBeanManager);
	}
	
	@Override
	public String sendUser(String s) {
		return "Hi " + s + ", your message was received!";
	}
	
	@Override
	public String saveUser(String firstName, String lastName) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Person person = new Person(firstName, lastName);
		em.persist(person);
		tx.commit();
		em.close();
		
		return "Person saved successfully!";
	}

	@Override
	public String saveUserClass(Person person) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//Person person = new Person(firstName, lastName);
		em.persist(person);
		tx.commit();
		em.close();
		
		return "Person saved successfully!";
	}	
}	