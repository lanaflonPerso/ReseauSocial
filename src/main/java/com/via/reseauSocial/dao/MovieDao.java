package com.via.reseauSocial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> { 
	
	Movie findById(int id);
	Movie findByTitleAndReleaseDate(String title, int releaseDate);
	List<Movie> findByTitleContaining(String title);
}