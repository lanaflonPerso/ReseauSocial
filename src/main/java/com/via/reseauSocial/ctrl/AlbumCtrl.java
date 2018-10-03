package com.via.reseauSocial.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.via.reseauSocial.beans.Album;
import com.via.reseauSocial.beans.GroupMusic;
import com.via.reseauSocial.dao.GroupDao;

@Component
public class AlbumCtrl extends Ctrl {

	@Autowired
	private GroupDao groupDao;
	
	private String msgBandName;
	private String msgTitle;
	private String msgPicture;
	
	public void addAlbumCtrl(Album album) {
		ctrlTitle(album.getTitle());
		ctrlPicture(album.getPicture());
		ctrlDate(album.getReleaseDate());
		if(!error) {
			GroupExist(album.getGroup());
		}
	}
	
	private void ctrlTitle(String title) {
		if(title.length() < 1) {
			msgTitle= "Le nom de l'album est obligatoire";
			error= true;
		}	
	}

	public void GroupExist(GroupMusic group) {
		GroupMusic newGroup= groupDao.findByBandName(group.getBandName());
		if(newGroup != null) {
			System.out.println("le groupe existe!");
			group.setId(newGroup.getId());
		}
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public String getMsgBandName() {
		return msgBandName;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public String getMsgPicture() {
		return msgPicture;
	}
}
