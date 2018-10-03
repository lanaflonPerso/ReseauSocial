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
import com.via.reseauSocial.beans.People;
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
    
    @GetMapping(value = "/movies/search/{title}")
	public List<Movie> searchMovie(@PathVariable String title) {
    	return movieDao.findByTitleContaining(title);
	}
    
    
    @GetMapping(value = "/movies/fixture/1")
	public void fixtureOne() {
    	Movie m= new Movie();
    	People pOne= new People();
    	pOne.setType("people");
    	pOne.setFirstName("Sandra");
    	pOne.setLastName("Bullock");
    	pOne.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/aCa4ELD1MfsVjLWYAynYbhXHQmu.jpg");
    	pOne.setBiography("Sandra Bullock est une actrice germano-américaine née le 26 juillet 1964 à Arlington, en Virginie (États-Unis). Elle accède à la reconnaissance du grand public après avoir joué dans des films à succès tels que Demolition Man, Speed ou L'Amour à tout prix et est depuis devenue une des actrices les plus populaires d'Hollywood grâce à des films comme Miss Détective et Collision qui ont reçu des critiques positives…");
    	
    	m.setType("movie");
    	m.setTitle("La Proposition");
    	m.setReleaseDate(2009);
    	m.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/7MQdp9iPY3917AmgnKYgHyaVsTJ.jpg");
    	m.setSynopsis("Une patronne exigeante est forcée de quitter les États-Unis pour retourner dans son pays d'origine : le Canada. Elle accepte par la force des choses de contracter un mariage blanc avec son jeune assistant, dans le but de ne pas partir.");
    	System.out.println(pOne);
    	m.setActor(pOne);
    	movieDao.save(m);
	}
}
