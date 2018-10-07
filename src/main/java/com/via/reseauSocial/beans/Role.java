package com.via.reseauSocial.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Role")
public class Role {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)     
	@Column(name = "id")
	private int id;
	private String roleName;
	
	public Role() {
		
	}
	public Role(String roleName) {
		this.roleName= roleName;
	}
		
	/* ****************************************************************************************
	 * ***************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	/* ****************************************************************************************
	 * ***************************OVERRIDE****************************************************
	 * ***************************************************************************************/
	@Override
	public String toString() {
		return "role [id=" + id + ", roleName=" + roleName + "]";
	}
}
