package com.via.reseauSocial.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Like_Dislike")
public class LikeDislike {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="likable_id", nullable=false)
	private Likable likable;
	
	private int typeVote;
	
	@Column(name = "createdAt", columnDefinition="DATETIME")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	private String type;
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public LikeDislike() {
		
	}
	
	public LikeDislike(User user, Likable likable_id, int typeVote) {
		this.user= user;
		this.likable= likable_id;
		this.typeVote= typeVote;
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getTypeVote() {
		return typeVote;
	}
	public void setTypeVote(int typeVote) {
		this.typeVote = typeVote;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Likable getLikable() {
		return likable;
	}
	public void setLikable(Likable likable) {
		this.likable = likable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "LikeDislike [id=" + id + ", "
				+ "\t user=" + user + ", "
				+ "\t likable=" + likable + ", typeVote=" + typeVote+ ", createdAt=" + createdAt + ", type=" + type + "]";
	}
	
}
