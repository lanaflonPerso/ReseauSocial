package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByFirstNameAndLastName(String firstName, String LastName);
	User findById(int id);
	User findByEmail(String email);
	User findByEmailAndPassword(String email, String password);
}
