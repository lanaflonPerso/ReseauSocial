package com.via.reseauSocial.ctrl;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.via.reseauSocial.beans.People;
import com.via.reseauSocial.dao.PeopleDao;

@Component
public class PeopleCtrl extends Ctrl {

	@Autowired
	private PeopleDao peopleDao;
	
	private String msgPeople;
	private String msgPicture;
	private String msgBiography;
	
	public void AddPeopleCtrl(People people) {
		ctrlFirstName(people.getFirstName());
		ctrlLastName(people.getLastName());
		ctrlPicture(people.getPicture());
		ctrlBirthday(people.getBirthday());
//		ctrlBiogrphy(people.getBiography());
		if(!error) {
			peopleExist(people.getFirstName(), people.getLastName());
		}
	}
	
	public void peopleExist(String firstName, String lastName) {
		People people= peopleDao.findByFirstNameAndLastName(firstName, lastName);
		if(people != null) {
			msgPeople= "Une personnalité avec le mêne nom et prénom et déja en base!";
			error= true;
		} else {
			people.setCreatedDate(new Date());
			people.setType("people");			
		}
	}
	
	public void ctrlBiogrphy(String synopsis) {
		if(synopsis.length() != 0 && synopsis.length() < 10) {
			 msgBiography= "la biographie peut être vide ou elle doit contenir 10 caratères minimum";
			error= true;
		} else if (synopsis.length() > 800) {
			 msgBiography= "la biographie ne peut pas contenir plus de 1500 caratères minimum";
			error= true;
		}
	}
	
	protected void ctrlBirthday(int birthday) {
		LocalDate now= LocalDate.now();
		if(birthday > now.getYear() || birthday < 1830) {
			msgReleaseDate= "Erreur sur la date d'anniversaire";
			error= true;
		}
	}

	public PeopleDao getPeopleDao() {
		return peopleDao;
	}
	public String getMsgPeople() {
		return msgPeople;
	}
	public String getMsgPicture() {
		return msgPicture;
	}
	public String getMsgBiography() {
		return msgBiography;
	}

	@Override
	public String toString() {
		return "peopleCtrl [msgPeople=" + msgPeople + ", msgPicture=" + msgPicture + ", msgBiography=" + msgBiography
				+ ", msgFirstName=" + msgFirstName + ", msgLastName=" + msgLastName + ", msgReleaseDate="
				+ msgReleaseDate + ", error=" + error + "]";
	}
	
}
