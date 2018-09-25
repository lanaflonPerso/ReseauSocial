package com.via.reseauSocial.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.InheritanceType;

@Entity  
@Table(name = "Likable")  
@Inheritance(strategy=InheritanceType.JOINED) 
public class Likable {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)     
	@Column(name = "id")  
	private Integer id;
	private String type;
	private int likeCount;
	private int dislikeCount;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createdDate;
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Likable() {
		super();
	}

	public Likable(int id) {
		super();
		this.id = id;
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public Integer getId() {
		return id;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getDislikeCount() {
		return dislikeCount;
	}
	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/* ****************************************************************************************
	 * ****************************OVERRIDES***************************************************
	 * ***************************************************************************************/
	@Override
	public String toString() {
		return "Likable [id=" + id + ", type=" + type + ", likeCount=" + likeCount + ", dislikeCount=" + dislikeCount
				+ "]";
	}
}
