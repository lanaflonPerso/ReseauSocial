package com.via.reseauSocial.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.via.reseauSocial.beans.Movie;
import com.via.reseauSocial.beans.People;
import com.via.reseauSocial.dao.MovieDao;
import com.via.reseauSocial.dao.PeopleDao;

@Component
public class MovieCtrl extends Ctrl {

	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private PeopleDao peopleDao;
	
	private String msgMovie;
	private String msgTitle;
	private String msgPicture;
	private String msgSynopsis;
	
	public void addMovieCtrl(Movie movie) {
		ctrlTitle(movie.getTitle());
		ctrlPicture(movie.getPicture());
		ctrlDate(movie.getReleaseDate());
		ctrlSynopsis(movie.getSynopsis());
		if(!error) {
			movieExist(movie.getTitle(), movie.getReleaseDate());
		}
	}
	
	public void updateCtrl(Movie movie) {
		ctrlTitle(movie.getTitle());
		ctrlPicture(movie.getPicture());
		ctrlDate(movie.getReleaseDate());
		ctrlSynopsis(movie.getSynopsis());
		for (People actor : movie.getActors()) {
			peopleExist(actor);
		}
		
	}
	
	public void movieExist(String title, int releaseDate) {
		Movie movie= movieDao.findByTitleAndReleaseDate(title, releaseDate);
		if(movie != null) {
			msgMovie= "Un film avec le même titre et sortie la même année est déja dans la base!";
			error= true;
		}
	}
	
	public void peopleExist(People people) {
		People newPeople= peopleDao.findByFirstNameAndLastName(people.getFirstName(), people.getLastName());
		if(newPeople != null) {
			System.out.println("people EXIST");
			people= newPeople;
		}
	}
	
	public void ctrlTitle(String title) {
		if(title.length() < 2) {
			msgTitle= "le titre doit comporter 2 caractères minimum";
			error= true;
		}
	}
	
	public void ctrlSynopsis(String synopsis) {
		if(synopsis.length() != 0 && synopsis.length() < 10) {
			msgSynopsis= "le synopsis peut être vide ou il doit contenir 10 caratères minimum";
			error= true;
		} else if (synopsis.length() > 1500) {
			msgSynopsis= "le synopsis ne peut pas contenir plus de 1500 caratères minimum";
			error= true;
		}
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public MovieDao getMovieDao() {
		return movieDao;
	}
	public String getMsgMovie() {
		return msgMovie;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public String getMsgPicture() {
		return msgPicture;
	}
	public String getMsgSynopsis() {
		return msgSynopsis;
	}

	@Override
	public String toString() {
		return "MovieCtrl [msgMovie=" + msgMovie + ", msgTitle=" + msgTitle + ", msgPicture="
				+ msgPicture + ", msgSynopsis=" + msgSynopsis + ", msgReleaseDate=" + msgReleaseDate + ", error="
				+ error + "]";
	}
}
