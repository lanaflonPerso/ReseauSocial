package com.via.reseauSocial.web.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.via.reseauSocial.beans.Album;
import com.via.reseauSocial.beans.GroupMusic;
import com.via.reseauSocial.ctrl.AlbumCtrl;
import com.via.reseauSocial.dao.AlbumDao;
import com.via.reseauSocial.dao.GroupDao;

@RestController
public class MusicController {
		
	@Autowired
	private AlbumDao albumDao;
	
	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private AlbumCtrl albumCtrl;
	
	
	@GetMapping(value = "/music/groups/seach/{name}")
	public List<GroupMusic> searchGroup(@PathVariable String name) {
	    return groupDao.findByBandNameContaining(name);		
	}
	
	@PostMapping(value = "music/albums/add")
	public void addAlbum(@RequestBody Album album ) {
		albumCtrl.addAlbumCtrl(album);
		if(!albumCtrl.isError()) {
			albumDao.save(album);
		}
	}
}
