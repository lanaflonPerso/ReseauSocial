package com.via.reseauSocial.ctrl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.via.reseauSocial.beans.User;
import com.via.reseauSocial.dao.UserDao;

@Component
public class UserCtrl extends Ctrl {
	
	private String msgUser;
	private String msgEmail;
	private String msgPassword;
	private String msgCity;
	
	public void signUpCtrl(User user, UserDao userDao) {
		ctrlFirstName(user.getFirstName());
		ctrlLastName(user.getLastName());	
		ctrlEmail(user.getEmail());
		ctrlPasswordEquals(user.getPassword(), user.getPass2());
		ctrlPasswordLength(user.getPassword());
		if (!error) {
			userExist(user.getEmail(), userDao);
		}
	}

	public void userExist(String email, UserDao userDao) {
		User userExist= userDao.findByEmail(email);
		if (userExist != null) {
			msgUser= "l'adresse email est déja utilisée";
			error= true;
		}
	}

	public void ctrlPasswordLength(String password) {
		if(password.length() < 8) {
			msgPassword= "le mot de passe doit comporter 8 caractères minimum";
			error= true;
		}
	}
	
	public void ctrlPasswordEquals(String pass1, String pass2) {
		if (!pass1.equals(pass2)) {
			msgPassword= "Les mots de passe ne sont pas identique";
			error= true;
		}
	}
	
	public void ctrlEmail(String email) {
		Pattern p= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(email);
		if(!matcher.find()) {
			msgEmail= "l'adresse email n'est pas valide!";
			error= true;
		}
		
	}
	
	public String getMsgEmail() {
		return msgEmail;
	}
	public String getMsgPassword() {
		return msgPassword;
	}
	public String getMsgCity() {
		return msgCity;
	}
	public void setMsgCity(String msgCity) {
		this.msgCity = msgCity;
	}
	public String getMsgUser() {
		return msgUser;
	}

	@Override
	public String toString() {
		return "UserCtrl [msgUser=" + msgUser + ", msgEmail=" + msgEmail + ", msgPassword="
				+ msgPassword + ", msgCity=" + msgCity + ", msgFirstName=" + msgFirstName + ", msgLastName="
				+ msgLastName + ", msgReleaseDate=" + msgReleaseDate + ", error=" + error + "]";
	}
}
