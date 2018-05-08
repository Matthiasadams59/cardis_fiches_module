package com.isep.cardis.projet_fiches_module_A2.modality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Modality {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String evaluation;
	private String learning;
	private String language;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String getLearning() {
		return learning;
	}
	public void setLearning(String learning) {
		this.learning = learning;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Modality(Integer id, String evaluation, String learning, String language) {
		super();
		this.id = id;
		this.evaluation = evaluation;
		this.learning = learning;
		this.language = language;
	}
	
	public Modality() {
	}
}
