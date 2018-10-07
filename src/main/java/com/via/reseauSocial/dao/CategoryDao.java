package com.via.reseauSocial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
	List<Category> findByTypeCategory(String type);
	List<Category> findByNameContaining(String name);
	Category findByNameAndTypeCategory(String name, String type);
}
