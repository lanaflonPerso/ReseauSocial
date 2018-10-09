package com.via.reseauSocial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Likable;
import com.via.reseauSocial.beans.LikeDislike;
import com.via.reseauSocial.beans.User;

@Repository
public interface LikeDislikeDao extends JpaRepository<LikeDislike, Integer> {
	
	LikeDislike findById(int id);
	List<LikeDislike> findByLikableAndTypeVote(Likable likable, int typeVote);
	List<LikeDislike> findByLikable(Likable likable);
	List<LikeDislike> findByUser(User user);
	LikeDislike findByUserAndLikable(User user, Likable likable);
}
