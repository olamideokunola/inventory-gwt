package com.aeryinnovations.shared.tests;

import com.aeryinnovations.shared.coredomain.SparePartRegister;

public class TestSpareRegister {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparePartRegister spReg = new SparePartRegister();
		System.out.println("No of items in register is: " + spReg.getSparePartSpecifications().size());
	}	

}
