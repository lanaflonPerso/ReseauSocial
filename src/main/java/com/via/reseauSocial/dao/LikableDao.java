package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Likable;

@Repository
public interface LikableDao extends JpaRepository<Likable, Integer> {

	Likable findById(int id);
}
