package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Comment;
import com.via.reseauSocial.beans.User;

@Repository
public interface commentDao extends JpaRepository<Comment, Integer>  {

}
