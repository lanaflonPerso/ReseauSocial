package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Likable;
import com.via.reseauSocial.beans.Video;

@Repository
public interface VideoDao extends JpaRepository<Likable, Integer>  {

	Video findById(int id);
}
