package com.via.reseauSocial.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Follower extends Likable {

	@ManyToMany(mappedBy = "followers")
	private List<Brick> bricks= new ArrayList<>();

	public List<Brick> getBricks() {
		return bricks;
	}
	public void setBricks(List<Brick> bricks) {
		this.bricks = bricks;
	}
}
