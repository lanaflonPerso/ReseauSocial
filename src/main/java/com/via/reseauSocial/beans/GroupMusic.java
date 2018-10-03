package com.via.reseauSocial.beans;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GroupMusic")
public class GroupMusic extends Likable {

	private String bandName;
	@ManyToMany
	private List<People> members= new ArrayList<>();
	@OneToMany
	private List<Album> albums= new LinkedList<>();
	@Column(length=1000)
	private String biography;
	
	/* ****************************************************************************************
	 * ***************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public GroupMusic() {
	}
	public GroupMusic(String bandName) {
		super();
		this.bandName = bandName;
	}
	
	
	public void setAlbum(Album album) {
		this.albums.add(album);
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public List<People> getMembers() {
		return members;
	}
	public void setMembers(List<People> members) {
		this.members = members;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	@Override
	public String toString() {
		return "GroupMusic [bandName=" + bandName + ", members=" + members + ", albums=" + albums + ", biography="
				+ biography + ", toString()=" + super.toString() + "]";
	}
}
