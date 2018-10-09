package com.via.reseauSocial.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.via.reseauSocial.beans.Brick;
import com.via.reseauSocial.beans.Category;
import com.via.reseauSocial.beans.LikeDislike;
import com.via.reseauSocial.beans.Movie;
import com.via.reseauSocial.dao.LikeDislikeDao;

public class BrickBo {
	
	private Brick brick= new Brick();

	public void searchForMovie(LikeDislike like, String type, LikeDislikeDao likeDao) {
		List<LikeDislike> list= new ArrayList<>();
		//L'utilisateur lui même
		list.addAll(likeDao.findByUser(like.getUser()));
		//followers de l'utilisateur
		list.addAll(likeDao.findByLikableAndTypeVote(like.getUser(), 1));
		//followers du film
		list.addAll(likeDao.findByLikableAndTypeVote(like.getLikable(), 1));
		
		Movie m= (Movie) like.getLikable();
		for (Category  category: m.getCategorys()) {
			//followers des genres du film /* thriller, horreur, action */
			list.addAll(likeDao.findByLikableAndTypeVote(category, 1));
		}
		
		for (LikeDislike likeDislike : list) {
			System.out.println(likeDislike);
			brick.setFollower(likeDislike.getUser());
		}
		brick.setCreatedDate(new Date());
		brick.setLikable(like.getLikable());
		brick.setShare(true);
		brick.setType(type);
		brick.setUser(like.getUser());
	}

	public Brick getBrick() {
		return brick;
	}
}
