package com.isep.cardis.projet_fiches_module_A2.hour;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HourController {
	
	@Autowired
	private HourService hourService;
	
	@GetMapping("/Hours")
	public List<Hour> getAllHours() {
		return hourService.getAllHours();
	}
	
	@RequestMapping("/Hours/{id}")
	public Optional<Hour> gethour(@PathVariable Integer id) {
		return hourService.getHour(id);
	}
	
	@PostMapping("/Hours")
	public void addhour(@RequestBody Hour hour) {
		hourService.addHour(hour);
	}
	
	@PutMapping("/Hours/{id}")
	public void updatehour(@RequestBody Hour hour) {
		hourService.updateHour(hour);
	}
	
	@DeleteMapping("/Hours/{id}")
	public void deletehour(@PathVariable Integer id) {
		hourService.deleteHour(id);
	}
}
