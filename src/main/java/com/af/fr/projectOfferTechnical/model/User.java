package com.af.fr.projectOfferTechnical.model;

import static com.af.fr.projectOfferTechnical.common.CommonUtility.ID_GENDER_DB;
import static com.af.fr.projectOfferTechnical.common.CommonUtility.ID_USER_DB;
import static com.af.fr.projectOfferTechnical.common.CommonUtility.TABLES_USERS_DB;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = TABLES_USERS_DB)
@Builder
public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ID_USER_DB, nullable = false, updatable = false)
	private Long idUser;
	private String userName;
	private Date birthdate;
	private String countryOfResidence;
	
	//---Not required---//
	private String phoneNumber;
	
	@OneToOne
	@JoinColumn(name=ID_GENDER_DB, nullable = false, updatable = false)
	private Gender gender;
	
	//Constructor User without field not required
	public User(Long idUser, String userName, Date birthdate, String countryOfResidence) {
		this.idUser = idUser;
		this.userName = userName;
		this.birthdate = birthdate;
		this.countryOfResidence = countryOfResidence;
		this.phoneNumber = "";
		// 'O' to 'other'
		this.gender = new Gender( Long.valueOf(3), 'O' );
	}
}


