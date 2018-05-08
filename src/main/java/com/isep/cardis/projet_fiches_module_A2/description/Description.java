package com.isep.cardis.projet_fiches_module_A2.description;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.isep.cardis.projet_fiches_module_A2.modality.Modality;
import com.isep.cardis.projet_fiches_module_A2.purpose.Purpose;

@Entity
public class Description {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String description;
	private String bibliography;
	
	@OneToOne
	Modality modality;
	@OneToOne 
	Purpose purpose;
	public Description() {
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Description(Integer id, String description, String bibliography, Modality modality, Purpose purpose) {
		super();
		this.id = id;
		this.description = description;
		this.bibliography = bibliography;
		this.modality = modality;
		this.purpose = purpose;
	}

	public Modality getModality() {
		return modality;
	}

	public void setModality(Modality modality) {
		this.modality = modality;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBibliography() {
		return bibliography;
	}
	public void setBibliography(String bibliography) {
		this.bibliography = bibliography;
	}
}