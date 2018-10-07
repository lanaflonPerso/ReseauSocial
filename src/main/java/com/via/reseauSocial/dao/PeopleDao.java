package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.via.reseauSocial.beans.People;

@Repository
public interface PeopleDao extends JpaRepository<People, Integer> {
	List<People> findByLastNameContaining(String lastName);
	People findByFirstNameAndLastName(String firstName, String lastName);
	People findById(int id);
}
