package com.via.reseauSocial.bo;

public class PeopleBo {

	public String returnRole(String role) {
		String result = null;
		switch (role) {
		case "actor":
			result= "movie";
			break;

		default:
			break;
		}
		
		return result;
	}
}
