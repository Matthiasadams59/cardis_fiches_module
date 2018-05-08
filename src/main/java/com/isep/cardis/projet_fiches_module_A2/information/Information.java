package com.isep.cardis.projet_fiches_module_A2.information;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.isep.cardis.projet_fiches_module_A2.hour.Hour;
import com.isep.cardis.projet_fiches_module_A2.user.User;

@Entity
public class Information {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String login;
	private Boolean isTeamWork;
	private String tag;
	private String devices;
	
	@OneToOne
	private User user;
	@OneToOne
	private Hour hour;
	
	public Information() {
	}
	
	public Information(Integer id, String login, Boolean isTeamWork, String tag, String devices, User user, Hour hour) {
		super();
		this.id = id;
		this.login = login;
		this.isTeamWork = isTeamWork;
		this.tag = tag;
		this.devices = devices;
		this.user = user;
		this.hour = hour;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Boolean getIsTeamWork() {
		return isTeamWork;
	}
	public void setIsTeamWork(Boolean isTeamWork) {
		this.isTeamWork = isTeamWork;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDevices() {
		return devices;
	}
	public void setDevices(String devices) {
		this.devices = devices;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Hour getHour() {
		return hour;
	}
	public void setHour(Hour hour) {
		this.hour = hour;
	}
	public Integer getUserById() {
		return user.getId();
	}
	public Integer getHourById() {
		return hour.getId();
	}
	
}
