package com.via.reseauSocial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.via.reseauSocial.beans.GroupMusic;

public interface GroupDao extends JpaRepository<GroupMusic, Integer> {

	List<GroupMusic> findByBandNameContaining(String name);

	GroupMusic findByBandName(String bandName);
}
