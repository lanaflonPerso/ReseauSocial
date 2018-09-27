package com.via.reseauSocial.ctrl;

import java.time.LocalDate;

public class Ctrl {

	protected String msgReleaseDate;
	protected boolean error= false;

	protected void ctrlDate(int releaseDate) {
		LocalDate now= LocalDate.now();
		if(releaseDate > now.getYear() || releaseDate < 1900) {
			msgReleaseDate= "Erreur sur la l'année de sortie";
			error= true;
		}
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

	@Override
	public String toString() {
		return "Ctrl [msgReleaseDate=" + msgReleaseDate + ", error=" + error + "]";
	}
	
}
