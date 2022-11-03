package com.af.fr.projectOfferTechnical.model;

import static com.af.fr.projectOfferTechnical.resource.StaticElements.USER;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity(name = "user")
@NoArgsConstructor
public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String userName;
	//Retransformer la date String -> Date ?
	private Date birthdate;
	private String countryOfResidence;
	
	//Not required
	//Faire un test de validation
	private String phoneNumber = "";
	//Faire un test de validation
	//Initiated in 3 = uninformed
	private int genderId = 3;
	
	public User(Long id, String userName, Date birthdate, String countryOfResidence, String phoneNumber, int genderId) {
		this.id = id;
		this.userName = userName;
		this.birthdate = birthdate;
		this.countryOfResidence = countryOfResidence;
		this.phoneNumber = phoneNumber;
		this.genderId = genderId;
	}
	
	//Constructor User without field not required
	public User(Long id, String userName, Date birthdate, String countryOfResidence) {
		this.id = id;
		this.userName = userName;
		this.birthdate = birthdate;
		this.countryOfResidence = countryOfResidence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

}
