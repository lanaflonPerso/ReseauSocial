package com.via.reseauSocial.web.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.via.reseauSocial.dao.MessageDao;
import com.via.reseauSocial.dao.UserDao;

@RestController
public class MessageController {
	
	@Autowired
	private MessageDao messageDao;
	
//	@Autowired
//	private MessageCtrl messageCtrl;
//	
//	@GetMapping(value = "/messages/count")
//	public long MessagesCount() {
//		return messageDao.countBySender(1);
//	}
//	
//	@PostMapping(value = "/messages/add")
//	public ResponseEntity<Object> addMessages(@RequestBody Message message) {
//		messageCtrl.addmessageCtrl(message);
//    	if(!messageCtrl.isError()) {
//    		/* *******************************************************************************
//    		 * --------------------------------- A EFFACER -----------------------------------
//    		 *********************************************************************************/
//    		User user= userDao.findById(1);
//    		
//    		message.setSender(user);
//    		Message newMessage= messageDao.save(message);
//    		URI location= ServletUriComponentsBuilder
//    				.fromCurrentRequest()
//    				.path("/{id}")
//    				.buildAndExpand(newMessage.getId())
//    				.toUri();
//    		
//    		return ResponseEntity.created(location).build();
//    	}
//    	return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
//	            .body("Erreur dans le formulaire de création du message");
//    	
//    }
}
