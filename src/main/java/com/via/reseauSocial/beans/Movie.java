package com.via.reseauSocial.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Movie")
@PrimaryKeyJoinColumn(name="id") 
//@JsonIgnoreProperties(value = {"studio", "picture"})
public class Movie extends Likable {
	
	private String title;
	@Column(length = 4)
	private int releaseDate;
	private String studio;
	private String picture;
	@Column(length = 1500)
	private String synopsis;
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Movie() {}
	public Movie(String title, String synopsis) {
		super();
		this.title = title;
		this.synopsis = synopsis;
	}
	
	public Movie(int id, String title, String synopsis) {
		super(id);
		this.title = title;
		this.synopsis = synopsis;
	}
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
			this.synopsis = synopsis;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

	/* ****************************************************************************************
	 * ****************************OVERRIDE****************************************************
	 * ***************************************************************************************/		
}
