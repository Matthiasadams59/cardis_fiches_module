package com.isep.cardis.projet_fiches_module_A2.sheet;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SheetService {
	
	@Autowired
	private SheetRepository sheetRepository;
	
	public List<Sheet> getAllSheets() {
		return (List<Sheet>) sheetRepository.findAll();
	}

	public List<Sheet> findByIsPublished(boolean statut) {
		return (List<Sheet>) sheetRepository.findByIsPublished(statut);
	}
	
	public Optional<Sheet>  getOneSheet(Integer id) {
		return (Optional<Sheet>) sheetRepository.findById(id);
	}
}
