package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Brick;

@Repository
public interface BrickDao extends JpaRepository<Brick, Integer>  {

}
