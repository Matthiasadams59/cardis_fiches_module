package com.isep.cardis.projet_fiches_module_A2.information;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService {
	
	@Autowired
	private InformationRepository informationRepository;

	public List<Information> getAllInformations() {
		return (List<Information>) informationRepository.findAll();
	}
	
	public List<Information> getInformationByUser(Integer id) {
		return informationRepository.findByUserId(id);
	}
	
	public Optional<Information> getInformation(Integer id) {
		return informationRepository.findById(id);
	}
	
	public void addInformation(Information Information) {
		informationRepository.save(Information);
	}
	
	public void updateInformation(Information Information) {
		informationRepository.save(Information);
	}
	
	public void deleteInformation(Integer id) {
		informationRepository.deleteById(id);
	}
	
}
