package com.isep.cardis.projet_fiches_module_A2.sheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.isep.cardis.projet_fiches_module_A2.information.Information;
import com.isep.cardis.projet_fiches_module_A2.user.User;
import com.isep.cardis.projet_fiches_module_A2.description.Description;

@Entity
public class Sheet {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private int dateCreation;
	private boolean isPublished;
	private String academicYear;
	
	@OneToOne
	User user;
	@OneToOne
	Information information;
	@OneToOne
	Description description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(int dateCreation) {
		this.dateCreation = dateCreation;
	}
	public boolean isPublished() {
		return isPublished;
	}
	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Information getInformation() {
		return information;
	}
	public void setInformation(Information information) {
		this.information = information;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	
	public Sheet(Integer id, String title, int dateCreation, boolean isPublished, String academicYear, User user,
			Information information, Description description) {
		super();
		this.id = id;
		this.title = title;
		this.dateCreation = dateCreation;
		this.isPublished = isPublished;
		this.academicYear = academicYear;
		this.user = user;
		this.information = information;
		this.description = description;
	}
	
	public Sheet() {

	}	
}
