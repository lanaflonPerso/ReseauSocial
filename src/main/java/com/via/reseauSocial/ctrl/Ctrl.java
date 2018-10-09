package com.via.reseauSocial.ctrl;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.via.reseauSocial.beans.Category;
import com.via.reseauSocial.beans.People;
import com.via.reseauSocial.beans.Role;
import com.via.reseauSocial.dao.CategoryDao;
import com.via.reseauSocial.dao.PeopleDao;
import com.via.reseauSocial.dao.RoleDao;

public class Ctrl {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PeopleDao peopleDao;

	
	protected String msgFirstName;
	protected String msgLastName;
	protected String msgReleaseDate;
	protected boolean error= false;
	
	
	public Category categoryExist(Category category, String type) {
		Category result= category;
		Category newCategory= categoryDao.findByNameAndType(category.getName(), type);
		if(newCategory != null) {
			result= newCategory;
		} else {
			result.setCreatedDate(new Date());
			result.setType(type);
		}
		return result;
	}
	
	public Role roleExist(String roleName) {
		Role result= new Role(roleName);
		Role newRole= roleDao.findByRoleName(roleName);
		if(newRole != null) {
			result= newRole;
		} 
		return result;
	}
	
	public People peopleExist(People people, Role role) {
		People result= null;
		
		People newPeople= peopleDao.findByFirstNameAndLastName(people.getFirstName(), people.getLastName());
		if(newPeople != null) {
			result= newPeople;
		} else {
			people.setType("people");
			people.setCreatedDate(new Date());
			people.setRole(role);
			result= people;
		}
		return result;
	}
	
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
