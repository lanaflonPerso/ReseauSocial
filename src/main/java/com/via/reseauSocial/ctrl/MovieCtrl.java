package com.via.reseauSocial.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.via.reseauSocial.beans.Movie;
import com.via.reseauSocial.beans.Role;
import com.via.reseauSocial.dao.MovieDao;

@Component
public class MovieCtrl extends Ctrl {

	@Autowired
	private MovieDao movieDao;
		
	private String msgMovie;
	private String msgTitle;
	private String msgPicture;
	private String msgSynopsis;
	
	public void addMovieCtrl(Movie movie) {
		ctrlTitle(movie.getTitle());
		ctrlPicture(movie.getPicture());
		ctrlDate(movie.getReleaseDate());
		ctrlSynopsis(movie.getSynopsis());
		if(movie.getActors() != null) {
			for (int i = 0; i < movie.getActors().size(); i++) {
				Role role= new Role("actor");
				movie.getActors().set(i, peopleExist(movie.getActors().get(i), role));
			}
		}
//		if (movie.getCategorys() != null) {
//			for (Category category : movie.getCategorys()) {
//				categoryExist(category, "video");
//			}
//		}
			
		if(!error) {
			movieExist(movie.getTitle(), movie.getReleaseDate());
		}
	}
	
	public void updateCtrl(Movie movie) {
		ctrlTitle(movie.getTitle());
		ctrlPicture(movie.getPicture());
		ctrlDate(movie.getReleaseDate());
		ctrlSynopsis(movie.getSynopsis());
//		peopleExist(movie);
		
	}
	
	public void movieExist(String title, int releaseDate) {
		Movie movie= movieDao.findByTitleAndReleaseDate(title, releaseDate);
		if(movie != null) {
			msgMovie= "Un film avec le même titre et sortie la même année est déja dans la base!";
			error= true;
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
