package com.via.reseauSocial.web.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

import com.via.reseauSocial.beans.Movie;
import com.via.reseauSocial.dao.MovieDao;

@RestController
public class MovieControler {
	
	@Autowired
	private MovieDao movieDao;
	
	@GetMapping(value = "/movies")
    public List<Movie> listMovies() {
       return movieDao.findAll();
    }
	
	@GetMapping(value = "/movies/{id}")
	public Movie viewMovie(@PathVariable int id) {
	    return movieDao.findById(id);
	}
	
    @PostMapping(value = "/movies")
    public ResponseEntity<Void> addMovie(@RequestBody Movie movie) {
    	Movie newMovie= movieDao.save(movie);
    	
    	if(newMovie == null) {
    		return ResponseEntity.noContent().build();
    	}
    	
    	URI location= ServletUriComponentsBuilder
    			.fromCurrentRequest()
    			.path("/{id}")
    			.buildAndExpand(newMovie.getId())
    			.toUri();
    	
    	return ResponseEntity.created(location).build();
    }
}
