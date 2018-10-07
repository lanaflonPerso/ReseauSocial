package com.via.reseauSocial.web.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.via.reseauSocial.beans.Category;
import com.via.reseauSocial.dao.CategoryDao;

@RestController
public class CategoryControler {

	@Autowired
	private CategoryDao categoryDao;
	
	@GetMapping(value= "/category/{typeCategory}")
	public List<Category> findByType(@PathVariable String typeCategory) {
	    return categoryDao.findByTypeCategory(typeCategory);
	}
	
	@GetMapping(value= "/category/search/{name}")
	public List<Category> searchByName(@PathVariable String name) {
	    return categoryDao.findByNameContaining(name);
	}
}
