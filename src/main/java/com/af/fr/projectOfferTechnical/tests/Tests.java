package com.af.fr.projectOfferTechnical.tests;

import static com.af.fr.projectOfferTechnical.common.CommonUtility.FRANCE_STR;
import static com.af.fr.projectOfferTechnical.common.CommonUtility.FRENCH_LEGAL_AGE;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * All tests
 * @author escan
 *
 */
public abstract class Tests {
	
	/**
	 * test legal age
	 * @param birthdate
	 * @return boolean
	 */
	public static boolean testLegalAge(Date birthdate){
		
		int yearNow = new GregorianCalendar().get(Calendar.YEAR);
		int yearBirthdate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
		
		if(( yearNow - yearBirthdate ) < FRENCH_LEGAL_AGE ) {
			return false;
		}
		
		if( ( yearBirthdate < 0 ) || ( yearNow - yearBirthdate > 130 ) ) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * test country of residence
	 * @param countryOfResidence
	 * @return boolean
	 */
	public static boolean testCountryOfResidence(String countryOfResidence){
		
		if( countryOfResidence != FRANCE_STR ) {
			return false;
		}
		
		return true;
	}
}
