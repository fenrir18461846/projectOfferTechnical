package com.af.fr.projectOfferTechnical.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.af.fr.projectOfferTechnical.model.User;
import com.af.fr.projectOfferTechnical.service.UserService;

@CrossOrigin(origins = "http://192.168.56.1:4200" )
@RestController
@RequestMapping("/users")
public class UserResource {
	
	private final UserService userService;
	
	public UserResource(UserService userService) {
		
		this.userService = userService;
	}

	//Find one user
	@GetMapping("/find/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = userService.findUserById(id);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//Add one user
	@PostMapping("/add")
	public ResponseEntity<User> addUserById(@RequestBody User user) {
		User newUser = userService.addUser(user);
		
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
	}
	
}

