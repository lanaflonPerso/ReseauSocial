package com.via.reseauSocial.web.controler;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.via.reseauSocial.beans.Movie;
import com.via.reseauSocial.ctrl.MovieCtrl;
import com.via.reseauSocial.dao.MovieDao;

@RestController
public class MovieControler {
	
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private MovieCtrl movieCtrl;
	
	@GetMapping(value = "/movies")
    public List<Movie> listMovies() {
       return movieDao.findAll();
    }
	
	@GetMapping(value = "/movies/{id}")
	public Movie viewMovie(@PathVariable int id) {
	    return movieDao.findById(id);
	}
	
    @PostMapping(value = "/movies/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
    	movieCtrl.addMovieCtrl(movie);
    	if(!movieCtrl.isError()) {
    		Movie newMovie= movieDao.save(movie);
    		URI location= ServletUriComponentsBuilder
    				.fromCurrentRequest()
    				.path("/{id}")
    				.buildAndExpand(newMovie.getId())
    				.toUri();
    		
    		return ResponseEntity.created(location).build();
    	}
    	return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
	            .body("Erreur dans le formulaire de création de film");
    	
    }
}
