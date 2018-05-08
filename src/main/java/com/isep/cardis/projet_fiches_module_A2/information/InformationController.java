package com.isep.cardis.projet_fiches_module_A2.information;

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
public class InformationController {
	
	@Autowired
	private InformationService informationService;
	
	@GetMapping("/Informations")
	public List<Information> getAllInformations() {
		return informationService.getAllInformations();
	}
	
	@RequestMapping("/Informations/{id}")
	public Optional<Information> getInformation(@PathVariable Integer id) {
		return informationService.getInformation(id);
	}
	
	@RequestMapping("Users/{id_user}/Informations/")
	public List<Information> getInformationByUser(@PathVariable Integer id_user) {
		return informationService.getInformationByUser(id_user);
	}
	
	@PostMapping("/Informations")
	public void addInformation(@RequestBody Information information) {
		informationService.addInformation(information);
	}
	
	@PutMapping("/Informations/{id}")
	public void updateInformation(@RequestBody Information information) {
		informationService.updateInformation(information);
	}
	
	@DeleteMapping("/Informations/{id}")
	public void deleteInformation(@PathVariable Integer id) {
		informationService.deleteInformation(id);
	}
}
