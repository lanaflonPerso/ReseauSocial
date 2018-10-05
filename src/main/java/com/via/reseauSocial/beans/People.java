package com.via.reseauSocial.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name= "People")
@PrimaryKeyJoinColumn(name="id")
public class People extends Likable {
	
	private String firstName;
	private String lastName;
	private String nickName;
//	@Column(length = 800)
//	private String biography;
	private String picture;
	
	@Column
	private Integer birthday;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name= "PeopleContent_Function",
		joinColumns = { @JoinColumn(name = "people_id") },
		inverseJoinColumns = { @JoinColumn(name = "function_id") }
	)
	private List<Role> roles= new ArrayList<>();
	
	/* ****************************************************************************************
	 * ***************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public People() {

	}
	
	
	/* ****************************************************************************************
	 * ***************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	public void setFunction(Role role) {
		roles.add(role);
	}
	
	/* ****************************************************************************************
	 * ***************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int year) {
		this.birthday = year;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setFunctions(List<Role> roles) {
		this.roles = roles;
	}
//	public String getBiography() {
//		return biography;
//	}
//	public void setBiography(String biography) {
//		if(biography.length() < 800) {
//			this.biography = biography;
//		} else {
//			this.biography = biography.substring(0, 799);
//		}
//	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}


	@Override
	public String toString() {
		return "People [firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName + ", picture=" + picture + ", birthday=" + birthday + ", roles=" + roles + ", toString()="
				+ super.toString() + "]";
	}

	/* ****************************************************************************************
	 * ***************************OVERRIDE****************************************************
	 * ***************************************************************************************/
	
}
