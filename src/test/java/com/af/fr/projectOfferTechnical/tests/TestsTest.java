package com.af.fr.projectOfferTechnical.tests;

import static com.af.fr.projectOfferTechnical.common.CommonUtility.FRANCE_STR;
import static com.af.fr.projectOfferTechnical.common.CommonUtility.FRENCH_LEGAL_AGE;
import static com.af.fr.projectOfferTechnical.tests.Tests.testCountryOfResidence;
import static com.af.fr.projectOfferTechnical.tests.Tests.testLegalAge;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import com.af.fr.projectOfferTechnical.model.Gender;
import com.af.fr.projectOfferTechnical.model.User;

class TestsTest {
	
	@Test
	void testWithoutOptionalsFieldsInstance() {
		
		//test data
		//userWithoutOptionnalsFields
		User user1 = new User( Long.valueOf(1), "userWithoutOptionnalsFields", new GregorianCalendar().getTime(), FRANCE_STR );
		Gender genderDefault = new Gender( Long.valueOf(3), 'O' );
		
		String log_error = "Error in "+ this.getClass().getEnclosingMethod() +", result : ";
		
		//result
		assertFalse( user1 == null,
				log_error + user1);
		
		assertFalse( user1.getPhoneNumber() == null,
				log_error + user1.getPhoneNumber() );
		
		assertTrue( user1.getPhoneNumber().equals(""),
				log_error + user1.getPhoneNumber() );
		
		assertFalse( user1.getGender() == null ,
				log_error + user1.getGender() );
		
		assertTrue( user1.getGender().equals(genderDefault) ,
				log_error + user1.getGender() );
	}
	
	@Test
	void testWithOptionalsFieldsInstance() {
		
		//test data
		Gender genderDefault = new Gender( Long.valueOf(3), 'O' );
		User userFullFields = new User( Long.valueOf(1), "userFullFields", new GregorianCalendar().getTime(), FRANCE_STR, "0778811556", genderDefault );
		
		String log_error = "Error in "+ this.getClass().getEnclosingMethod() +", result : ";
		
		//result
		assertFalse( userFullFields == null,
				log_error + userFullFields);
	}

	@Test
	void testLegalAgeTest() {
		
		//test data
		int yearNow = new GregorianCalendar().get(Calendar.YEAR);
		int minYear = yearNow - FRENCH_LEGAL_AGE;
		
		GregorianCalendar date = new GregorianCalendar();
		date.set(Calendar.YEAR, (minYear - 1));
		Date resultTrue1 = date.getTime();
		date.set(Calendar.YEAR, minYear);
		Date resultTrue2 = date.getTime();
		date.set(Calendar.YEAR, (minYear + 1));
		Date resultFalse1 = date.getTime();
		date.set(Calendar.YEAR, (-1));
		Date resultFalse2 = date.getTime();
		date.set(Calendar.YEAR, (minYear - 130));
		Date resultFalse3 = date.getTime();
		
		//result
		assertTrue( testLegalAge(resultTrue1) , "Error in testLegalAgeTest for true test1" );
		assertTrue( testLegalAge(resultTrue2) , "Error in testLegalAgeTest for true test2" );
		assertFalse( testLegalAge(resultFalse1) , "Error in testLegalAgeTest for false test1" );
		assertFalse( testLegalAge(resultFalse2) , "Error in testLegalAgeTest for false test2" );
		assertFalse( testLegalAge(resultFalse3) , "Error in testLegalAgeTest for false test3" );
	}
	
	@Test
	void testCountryOfResidenceTest() {
		
		//test data
		String dataTrue = FRANCE_STR;
		String dataFalse = "BELGIQUE";
		
		//start test
		boolean resultTrue = testCountryOfResidence( dataTrue );
		boolean resultFalse = testCountryOfResidence( dataFalse );
		
		//result
		assertTrue( resultTrue , "Error in testCountryOfResidence for true test" );
		assertFalse( resultFalse , "Error in testCountryOfResidence for false test" );
	}
}


