package com.aeryinnovations.testdata;


import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.aeryinnovations.shared.coredomain.*;
import com.aeryinnovations.shared.JPAUtil;

public class LoadTestData {
	
	private static void persistEquipmentSpecifications() {
		
		// Start EntityManagerFactory
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
				
		EquipmentSpecification equipSpec1 = new EquipmentSpecification("eq01", "Equipment 01",  "EquipmentType 01", "manufacturer01", "pn001", "10");
		equipSpec1.getEquipments().add(new Equipment(equipSpec1, "Lawn mower 01"));
		equipSpec1.getEquipments().add(new Equipment(equipSpec1, "Lawn mower 02"));
		equipSpec1.getEquipments().add(new Equipment(equipSpec1, "Lawn mower 03"));
		
		em.persist(equipSpec1);
		
		EquipmentSpecification equipSpec2 = new EquipmentSpecification("eq02", "Equipment 02",  "EquipmentType 01", "manufacturer01", "pn002", "20");
		equipSpec2.getEquipments().add(new Equipment(equipSpec2, "Water pump 01"));
		equipSpec2.getEquipments().add(new Equipment(equipSpec2, "Water pump 02"));
		
		em.persist(equipSpec2);
		
		tx.commit();
		em.close();
		
		JPAUtil.shutdown();
		
	}

	private static void persistSparePartSpecifications() {
		
		// Start EntityManagerFactory
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
				
		//SparePartSpecification(String partDescription,String partType,String manufacturer,String manufacturerPartNumber, BigDecimal price){
		
		//SparePartRegister spReg = new SparePartRegister();
		
		SparePartSpecification spareSpec1 = new SparePartSpecification("Bearing 6402", "Bearing",  "SKF", "6402", new BigDecimal("10"));
		em.persist(spareSpec1);
		
		SparePartSpecification spareSpec2 = new SparePartSpecification("Bearing 7402", "Bearing",  "FAG", "7402", new BigDecimal("20"));
		em.persist(spareSpec2);
		
		SparePartSpecification spareSpec3 = new SparePartSpecification("Coupling 16402", "Coupling",  "SKF", "16402", new BigDecimal("5"));
		em.persist(spareSpec3);
		
		SparePartSpecification spareSpec4 = new SparePartSpecification("Coupling 17402", "Coupling",  "FAG", "17402", new BigDecimal("15"));
		em.persist(spareSpec4);
		
		tx.commit();
		em.close();
		
		JPAUtil.shutdown();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//persistEquipmentSpecifications();
		persistSparePartSpecifications();
	}

}
