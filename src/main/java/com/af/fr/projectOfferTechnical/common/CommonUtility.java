package com.af.fr.projectOfferTechnical.common;

public abstract class CommonUtility {
	
	public static final String FRANCE_STR = "FRANCE";
	public static final int FRENCH_LEGAL_AGE = 18;
	
	//---TABLE IN DB---//
	
	//Change name because user is key word in SQL
	public static final String TABLES_USERS_DB = "users";
	public static final String ID_USER_DB = "id_user";
	
	//Change name because conflict with field gender
	public static final String TABLES_GENDER_DB = "genders";
	public static final String ID_GENDER_DB = "id_gender";
}
