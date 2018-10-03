package com.via.reseauSocial.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "Brick")
public class Brick {
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	@ManyToOne
	@JoinColumn(name="likable_id", nullable=false)
	private Likable likable;
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
		name= "Brick_Follower",
		joinColumns = { @JoinColumn(name = "brick_id") },
		inverseJoinColumns = { @JoinColumn(name = "follower_id") }
	)
	private Set<User> followers= new HashSet<>();
	private boolean share;
	@Column(length = 500)
	private String html;
	@OneToMany(mappedBy = "brick")
	private List<Comment> comments= new LinkedList<>();
	@Temporal(value=TemporalType.DATE)
	private Date createdDate;
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Brick() {
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	public void setFollower(User follower) {
		this.followers.add(follower);
	}
	
	public int countComment() {
		return comments.size();
	}
	
	public void setComment(Comment comment) {
		this.comments.add(comment);
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
	public Set<User> getFollowers() {
		return followers;
	}
	public void setFollowers(Set<User> followers) {
		this.followers.addAll(followers);
	}
	public boolean isShare() {
		return share;
	}
	public void setShare(boolean share) {
		this.share = share;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/* ****************************************************************************************
	 * ****************************OVERRIDE****************************************************
	 * ***************************************************************************************/
	@Override
	public String toString() {
		return "Mur [id=" + id + ", user=" + user + ", likable=" + likable + ", followers=" + followers + ", share="
				+ share + ", html=" + html + "]";
	}
}
