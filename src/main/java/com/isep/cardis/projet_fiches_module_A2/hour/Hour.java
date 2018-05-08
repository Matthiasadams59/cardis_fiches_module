package com.isep.cardis.projet_fiches_module_A2.hour;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hour {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private int total;
	private int tutorial;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTutorial() {
		return tutorial;
	}
	public void setTutorial(int tutorial) {
		this.tutorial = tutorial;
	}
	
	public Hour(Integer id, int total, int tutorial) {
		super();
		this.id = id;
		this.total = total;
		this.tutorial = tutorial;
	}
	
	public Hour() {
		
	}
}
