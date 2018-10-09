package com.via.reseauSocial.web.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.via.reseauSocial.beans.Likable;
import com.via.reseauSocial.beans.LikeDislike;
import com.via.reseauSocial.beans.User;
import com.via.reseauSocial.bo.LikeBo;
import com.via.reseauSocial.dao.BrickDao;
import com.via.reseauSocial.dao.LikableDao;
import com.via.reseauSocial.dao.LikeDislikeDao;
import com.via.reseauSocial.dao.UserDao;

@RestController
public class LikeControler {
	
	@Autowired
	private LikeDislikeDao likeDao;
	@Autowired
	private LikableDao likableDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BrickDao brickDao;
	
	@GetMapping(value= "/like-dislike/{id}")
	public LikeDislike searchLike(@PathVariable("id") int id) {
		/* *******************************************************************************
		 * --------------------------------- A EFFACER -----------------------------------
		 *********************************************************************************/
		User user= userDao.findByFirstNameAndLastName("vianney", "bailleux");
		
		Likable likable= likableDao.findById(id);
		return  likeDao.findByUserAndLikable(user, likable);
	}
	

	@GetMapping(value= "/like/{id}")
    public void addLike(@PathVariable("id") int id) {
		/* *******************************************************************************
		 * --------------------------------- A EFFACER -----------------------------------
		 *********************************************************************************/
		User user= userDao.findByFirstNameAndLastName("vianney", "bailleux");

		Likable likable= likableDao.findById(id);
		LikeDislike myLike= likeDao.findByUserAndLikable(user, likable);
		LikeBo lBo= new LikeBo(likeDao,brickDao);
		lBo.createLike(likable, myLike, user, 1);
    }
	
	@GetMapping(value= "/dislike/{id}")
    public void addDislike(@PathVariable int id) {
		/* *******************************************************************************
		 * --------------------------------- A EFFACER -----------------------------------
		 *********************************************************************************/
		User user= userDao.findByFirstNameAndLastName("vianney", "bailleux");
		
		Likable likable= likableDao.findById(id);
		LikeDislike myLike= likeDao.findByUserAndLikable(user, likable);
		LikeBo lBo= new LikeBo(likeDao,brickDao);
		lBo.createLike(likable, myLike, user, -1);
    }
}
