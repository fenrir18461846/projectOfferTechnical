package com.af.fr.projectOfferTechnical.model;

import static com.af.fr.projectOfferTechnical.common.CommonUtility.ID_GENDER_DB;
import static com.af.fr.projectOfferTechnical.common.CommonUtility.TABLES_GENDER_DB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = TABLES_GENDER_DB)
@Builder
public class Gender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name=ID_GENDER_DB, nullable = false, updatable = false)
	private Long idGender;

	private char gender;
}

