package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.via.reseauSocial.beans.Movie;

public interface MovieDao extends JpaRepository<Movie, Integer> { 
	
	Movie findById(int id);
	Movie findByTitleAndReleaseDate(String title, int releaseDate);
}
