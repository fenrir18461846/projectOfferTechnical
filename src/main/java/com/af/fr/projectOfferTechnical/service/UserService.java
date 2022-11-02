package com.af.fr.projectOfferTechnical.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.af.fr.projectOfferTechnical.exception.UserNotFoundException;
import com.af.fr.projectOfferTechnical.model.User;
import com.af.fr.projectOfferTechnical.repo.UserRepo;

@Service
@Transactional
public class UserService {
	
	private final UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public User findUserById( Long id ) {
		
		return userRepo.findUserById( id )
				.orElseThrow( () -> new UserNotFoundException( "User by id " + id + " was not found ! ") );
			
	}
	
	public User addUser( User user ) {
		
		return userRepo.save( user );
	}

}


