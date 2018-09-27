package com.via.reseauSocial.web.controler;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.via.reseauSocial.beans.User;
import com.via.reseauSocial.ctrl.UserCtrl;
import com.via.reseauSocial.dao.UserDao;

@RestController
public class UserControler {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserCtrl userCtrl;
	
	@GetMapping(value = "/users")
    public List<User> listUsers() {
       return userDao.findAll();
    }
	
	@GetMapping(value = "/users/{id}")
	public User viewUser(@PathVariable int id) {
	    return userDao.findById(id);
	}
	
	@PostMapping(value = "/users/sign-in")
    public ResponseEntity<String> signIn(@RequestBody User user, HttpServletRequest request) {
		
		userCtrl.signUpCtrl(user);
		if(!userCtrl.isError()) {
			User newUser= userDao.save(user);
			request.getSession().setAttribute("user", newUser);
	
			URI location= ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(1)
					.toUri();
			return ResponseEntity.created(location).build();
		}
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
	            .body("Erreur dans le formulaire d'inscription");
	}
	
	@PostMapping(value = "/users")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
    	User newUser= userDao.save(user);
    	
    	if(newUser == null) {
    		return ResponseEntity.noContent().build();
    	}
    	
    	URI location= ServletUriComponentsBuilder
    			.fromCurrentRequest()
    			.path("/{id}")
    			.buildAndExpand(newUser.getId())
    			.toUri();
    	
    	return ResponseEntity.created(location).build();
    }
}