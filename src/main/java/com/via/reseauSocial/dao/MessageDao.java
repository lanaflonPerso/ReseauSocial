package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Message;
import com.via.reseauSocial.beans.Video;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer> {

	Video findById(int id);
	long countBySender(int id);
}
