package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.People;

@Repository
public interface PeopleDao extends JpaRepository<People, Integer> {

	People findByFirstNameAndLastName(String firstName, String lastName);
	People findById(int id);

}
