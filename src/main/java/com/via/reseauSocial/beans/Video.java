package com.via.reseauSocial.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


public class Video extends Likable {
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinTable(
		name= "Video_People",
		joinColumns = { @JoinColumn(name = "Video_id") },
		inverseJoinColumns = { @JoinColumn(name = "people_id") }
	)
	private List<People> actors= new ArrayList<>();
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinTable(
		name= "Video_Category",
		joinColumns = { @JoinColumn(name = "video_id") },
		inverseJoinColumns = { @JoinColumn(name = "Category_id") }
	)
	private List<Category> categorys= new ArrayList<>();
	
	
	public Video() {
		super();
	}
	public Video(int id) {
		super(id);
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	
	public void setActor(People actor) {
		actors.add(actor);
	}
	public void setCategory(Category category) {
		categorys.add(category);
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/	
	public List<Category> getCategorys() {
		return categorys;
	}
	
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	
	public void setActors(List<People> actors) {
		this.actors = actors;
	}	
	public List<People> getActors() {
		return actors;
	}
	@Override
	public String toString() {
		return "Video [actors=" + actors + ", categorys=" + categorys + ", toString()=" + super.toString() + "]";
	}
}
