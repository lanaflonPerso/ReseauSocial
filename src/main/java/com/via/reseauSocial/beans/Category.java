package com.via.reseauSocial.beans;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Category")
@PrimaryKeyJoinColumn(name="id")
public class Category extends Likable {
	
	private String name;
	private String typeCategory;
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Category() {	}
	
	public Category(String name, String typeCategory) {
		super();
		this.name = name;
		this.typeCategory= typeCategory;
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeCategory() {
		return typeCategory;
	}
	public void setTypeCategory(String typeCategory) {
		this.typeCategory = typeCategory;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", type=" + typeCategory + "]";
	}
	
	
}
