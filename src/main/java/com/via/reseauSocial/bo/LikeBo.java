package com.via.reseauSocial.bo;

import java.util.Date;

import com.via.reseauSocial.beans.Likable;
import com.via.reseauSocial.beans.LikeDislike;
import com.via.reseauSocial.beans.User;
import com.via.reseauSocial.dao.LikeDao;

public class LikeBo {
	
	public void createLike(Likable likable, LikeDislike like, User user, int myLike, LikeDao likeDao) {
		if(like == null) {
			like= new LikeDislike();
			if(myLike == 1) {
				likable.setLikeCount(likable.getLikeCount()+1);
			} else {
				likable.setDislikeCount(likable.getDislikeCount()+1);
			}			
			like.setLikable(likable);
			like.setUser(user);
			like.setType(likable.getType());
			like.setCreatedAt(new Date());
		} else {
			if (like.getTypeVote() != myLike && myLike == -1) {
				like.getLikable().setDislikeCount(likable.getDislikeCount()+1);
				like.getLikable().setLikeCount(likable.getLikeCount()-1);
			} else if (like.getTypeVote() != myLike && myLike == 1) {
				like.getLikable().setLikeCount(likable.getLikeCount()+1);
				like.getLikable().setDislikeCount(likable.getDislikeCount()-1);
			}
		}
		like.setTypeVote(myLike);
		likeDao.save(like);
	}
}
