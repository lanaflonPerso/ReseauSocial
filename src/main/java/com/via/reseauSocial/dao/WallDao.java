package com.via.reseauSocial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Brick;
import com.via.reseauSocial.beans.User;

@Repository
public interface WallDao extends JpaRepository<Brick, Integer> {

	Brick findById(int id);
	List<Brick> findByFollowersAndShare(User user, boolean share);
}
