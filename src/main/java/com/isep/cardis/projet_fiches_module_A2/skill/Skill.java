package com.isep.cardis.projet_fiches_module_A2.skill;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.isep.cardis.projet_fiches_module_A2.sheet.Sheet;

@Entity
public class Skill {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String skill;
	
	@ManyToMany(mappedBy = "skills")
	private Set<Sheet> sheets = new HashSet<>();;
	
	
	public Skill(Integer id,String skill) {
		super();
		this.id = id;
		this.skill = skill;
		//this.sheets = sheet;
	}
	
	public Set<Sheet> getSheets() {
		return sheets;
	}

	public void setSheets(Set<Sheet> sheets) {
		this.sheets = sheets;
	}

	public Skill() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
}
