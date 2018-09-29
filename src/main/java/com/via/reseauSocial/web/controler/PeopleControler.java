package com.via.reseauSocial.web.controler;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.via.reseauSocial.beans.People;
import com.via.reseauSocial.ctrl.PeopleCtrl;
import com.via.reseauSocial.dao.PeopleDao;

@RestController
public class PeopleControler {

	@Autowired
	private PeopleDao peopleDao;
	@Autowired
	private PeopleCtrl peopleCtrl;
	
	@GetMapping(value = "/peoples/{id}")
	public People viewPeople(@PathVariable int id) {
	    return peopleDao.findById(id);
	}
	
	@PostMapping(value = "/peoples/add")
    public ResponseEntity<String> addPeople(@RequestBody People people) {
		peopleCtrl.AddPeopleCtrl(people);	
		
		if(!peopleCtrl.isError()) {
			People newPeople= peopleDao.save(people);
			URI location= ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newPeople.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
	            .body("Erreur dans le formulaire de création");
	
	}
}
