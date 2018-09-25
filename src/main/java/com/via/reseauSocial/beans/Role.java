package com.via.reseauSocial.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Function")
public class Role {
	
	@Id
	@GeneratedValue
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
