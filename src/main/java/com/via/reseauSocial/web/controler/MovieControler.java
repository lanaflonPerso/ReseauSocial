package com.via.reseauSocial.web.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieControler {
	
	@GetMapping(value = "/movies")
    public String listeProduits() {
        return "Un exemple de produit";
    }
	
	@GetMapping(value = "/movies/{id}")
	public String afficherUnProduit(@PathVariable int id) {
		return "Vous avez demandé un produit avec l'id  " + id;
	}
}
