package com.via.reseauSocial.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Album")
public class Album extends Likable {
	
	private String title;
	@Column(length = 4)
	private int releaseDate;
	@ManyToOne
	private GroupMusic group;
	@OneToMany(cascade= CascadeType.ALL)
	private List<Song> songs= new ArrayList<>();
	private String picture;
	private String description;
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GroupMusic getGroup() {
		return group;
	}
	public void setGroup(GroupMusic group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		return "Album [title=" + title + ", releaseDate=" + releaseDate + ", songs=" + songs
				+ ", picture=" + picture + ", description=" + description + ", toString()=" + super.toString() + "]";
	}
}
