package com.via.reseauSocial.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Movie")
@PrimaryKeyJoinColumn(name="id") 
//@JsonIgnoreProperties(value = {"studio", "picture"})
public class Movie extends Video {
	
	private String title;
	private int releaseDate;
	private String studio;
	private String picture;
	@Column(length = 1500)
	private String synopsis;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
		name= "Movie_Actor",
		joinColumns = { @JoinColumn(name = "movie_id") },
		inverseJoinColumns = { @JoinColumn(name = "Actor_id") }
	)
	private List<People> actors= new ArrayList<>();
	
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
	
	
	public void setActor(People actor) {
		this.actors.add(actor);
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
	public List<People> getActors() {
		return actors;
	}
	public void setActors(List<People> actors) {
		this.actors = actors;
	}
	/* ****************************************************************************************
	 * ****************************OVERRIDE****************************************************
	 * ***************************************************************************************/
	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseDate=" + releaseDate + ", studio=" + studio + ", picture=" + picture
				+ ", synopsis=" + synopsis + ", actors=" + actors + ", toString()=" + super.toString() + "]";
	}
	
}
