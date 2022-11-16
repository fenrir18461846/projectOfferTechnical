package com.af.fr.projectOfferTechnical.resource;

import static com.af.fr.projectOfferTechnical.common.CommonUtility.ID_USER_DB;
import static com.af.fr.projectOfferTechnical.common.CommonUtility.TABLES_USERS_DB;

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

@CrossOrigin(origins = "http://localhost:4200" )
@RestController
@RequestMapping("/" + TABLES_USERS_DB)
public class UserResource {
	
	private final UserService userService;
	
	public UserResource(UserService userService) {
		
		this.userService = userService;
	}

	//Find one user
	@GetMapping("/find/{"+ ID_USER_DB +"}")
	public ResponseEntity<User> getUserById(@PathVariable( ID_USER_DB ) Long idUser) {
		
		User user = userService.findUserById(idUser);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//Add one user
	@PostMapping("/add")
	public ResponseEntity<User> addUserById(@RequestBody User user) {
		
		User newUser = userService.addUser(user);
		
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
	}
	
}

