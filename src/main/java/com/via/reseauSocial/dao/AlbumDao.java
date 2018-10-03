package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Album;

@Repository
public interface AlbumDao extends JpaRepository<Album, Integer> {

}
