package com.via.reseauSocial.web.controler;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.via.reseauSocial.beans.Brick;
import com.via.reseauSocial.beans.Comment;
import com.via.reseauSocial.beans.User;
import com.via.reseauSocial.ctrl.ShortMessageCtrl;
import com.via.reseauSocial.dao.UserDao;
import com.via.reseauSocial.dao.WallDao;
import com.via.reseauSocial.dao.commentDao;

@RestController
public class WallControler {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private WallDao wallDao;
	
	@Autowired
	private commentDao commentDao;
	
	@Autowired
	private ShortMessageCtrl shortMessageCtrl;
		
	@PostMapping(value= "/wall/add")
    public ResponseEntity<Object> addSh(@RequestBody Brick brick) {
		shortMessageCtrl.addShCtrl(brick.getHtml());
		
    	if(!shortMessageCtrl.isError()) {
    		/* *******************************************************************************
    		 * --------------------------------- A EFFACER -----------------------------------
    		 *********************************************************************************/
    		User user= userDao.findById(1);
    		
    		brick.setCreatedDate(new Date());
    		brick.setLikable(user);
    		brick.setShare(true);
    		brick.setUser(user);
    		
    		Brick newBrick= wallDao.save(brick);
    		URI location= ServletUriComponentsBuilder
    				.fromCurrentRequest()
    				.path("/{id}")
    				.buildAndExpand(newBrick.getId())
    				.toUri();
    		
    		return ResponseEntity.created(location).build();
    	}
    	return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
	            .body("Erreur dans le formulaire de création de film");
	}
	
	@GetMapping(value= "/wall")
	public List<Brick> viewAllWall(){
		/* *******************************************************************************
		 * --------------------------------- A EFFACER -----------------------------------
		 *********************************************************************************/
		User user= userDao.findById(11);
		
		return wallDao.findByFollowersAndShare(user, true);
	}
	
	@PostMapping(value="/wall/{id}/add")
	public ResponseEntity<Object> addComment(@PathVariable int id, @RequestBody Comment comment) {
		/* *******************************************************************************
		 * --------------------------------- A EFFACER -----------------------------------
		 *********************************************************************************/
		User user= userDao.findById(1);
		
		Brick brick= wallDao.findById(id);
		comment.setCreatedDate(new Date());
		comment.setUser(user);
		comment.setWall(brick);
		Comment newComment= commentDao.save(comment);
		
		URI location= ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newComment.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
