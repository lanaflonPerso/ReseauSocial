package com.via.reseauSocial.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "Comment")
public class Comment {

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Brick brick;
	@ManyToOne
	private User user;
	@Column(length=500)
	private String contenu;
	@Temporal(value=TemporalType.DATE)
	private Date createdDate;
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String textValue) {
		this.contenu = textValue;
	}
	public Brick getBrick() {
		return brick;
	}
	public void setWall(Brick brick) {
		this.brick = brick;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
