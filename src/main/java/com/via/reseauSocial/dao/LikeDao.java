package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Likable;
import com.via.reseauSocial.beans.LikeDislike;
import com.via.reseauSocial.beans.User;

@Repository
public interface LikeDao extends JpaRepository<LikeDislike, Integer> {

	LikeDislike findByUser(User user);
	LikeDislike findByUserAndLikable(User user, Likable likable);
}
