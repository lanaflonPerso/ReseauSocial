package com.via.reseauSocial.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.via.reseauSocial.beans.Album;
import com.via.reseauSocial.beans.GroupMusic;
import com.via.reseauSocial.beans.Song;
import com.via.reseauSocial.dao.AlbumDao;
import com.via.reseauSocial.dao.GroupDao;

@Component
public class AlbumCtrl extends Ctrl {

	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private AlbumDao albumDao;
	
	private String msgAlbum;
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
	
	public void updateCtrl(Album album) {
		addAlbumCtrl(album);
		int i= 1;
		for (Song song : album.getSongs()) {
			ctrlSongTitle(song.getTitle());
			song.setNumber(i);
			i++;
		}
	}
	
	private void ctrlSongTitle(String title) {
		if(title.length() < 1) {
			msgTitle= "Le titre est obligatoire";
			error= true;
		}
	}
	
	private void ctrlTitle(String title) {
		if(title.length() < 1) {
			msgTitle= "Le nom de l'album est obligatoire";
			error= true;
		}	
	}
	
	public void AlbumExistById(int id) {
		Album newAlbum= albumDao.findById(id);
		if(newAlbum == null) {
			msgAlbum= "l'album n'exsite pas Update Impossible";
			error= true;
		}
	}

	public void GroupExist(GroupMusic group) {
		GroupMusic newGroup= groupDao.findByBandName(group.getBandName());
		if(newGroup != null) {
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
	public String getMsgAlbum() {
		return msgAlbum;
	}
	
}
