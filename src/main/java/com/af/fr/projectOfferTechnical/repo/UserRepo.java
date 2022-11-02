package com.af.fr.projectOfferTechnical.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.af.fr.projectOfferTechnical.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	Optional<User> findUserById(Long id);
	
}

