package com.via.reseauSocial.ctrl;

import java.time.LocalDate;

public class Ctrl {

	protected String msgFirstName;
	protected String msgLastName;
	protected String msgReleaseDate;
	protected boolean error= false;

	protected void ctrlDate(int releaseDate) {
		LocalDate now= LocalDate.now();
		if(releaseDate > now.getYear() || releaseDate < 1900) {
			msgReleaseDate= "Erreur sur la l'année de sortie";
			error= true;
		}
	}
	
	public void ctrlFirstName(String firstName) {
		if(firstName.length() < 3) {
			msgFirstName= "le prénom doit comporter plus de 2 caractères";
			error= true;
		}
	}
	public void ctrlLastName(String lastName) {
		if (lastName.length() < 3) {
			msgLastName= "le nom doit comporter plus de 2 caractères";
			error= true;
		}
	}
	
	public void ctrlPicture(String picture) {
		
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public boolean isError() {
		return error;
	}
	public String getMsgReleaseDate() {
		return msgReleaseDate;
	}
	public String getMsgFirstName() {
		return msgFirstName;
	}
	public String getMsgLastName() {
		return msgLastName;
	}

	@Override
	public String toString() {
		return "Ctrl [msgReleaseDate=" + msgReleaseDate + ", error=" + error + "]";
	}
	
}
