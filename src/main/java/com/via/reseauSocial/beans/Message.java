package com.via.reseauSocial.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="message")
public class Message {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)     
	@Column(name = "id")
	private Integer id;
	@ManyToOne
	private User sender;
	@ManyToOne
	private User receiver;
	@Column(length=500)
	private String contents;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createdAt;
	private boolean wasRead;
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS PERSO*************************************
	 * ***************************************************************************************/	
	public String getIntroContents() {
		if (contents.length() > 40) {
			return contents.substring(0, 40);
		}
		return contents;
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
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public boolean isWasRead() {
		return wasRead;
	}
	public void setWasRead(boolean wasRead) {
		this.wasRead = wasRead;
	}	
}
