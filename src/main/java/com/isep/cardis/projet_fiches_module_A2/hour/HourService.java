package com.isep.cardis.projet_fiches_module_A2.hour;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HourService {
	
	@Autowired
	private HourRepository hourRepository;

	public List<Hour> getAllHours() {
		return (List<Hour>) hourRepository.findAll();
	}
	
	public Optional<Hour> getHour(Integer id) {
		return hourRepository.findById(id);
	}
	
	public void addHour(Hour hour) {
		hourRepository.save(hour);
	}
	
	public void updateHour(Hour hour) {
		hourRepository.save(hour);
	}
	
	public void deleteHour(Integer id) {
		hourRepository.deleteById(id);
	}
}
