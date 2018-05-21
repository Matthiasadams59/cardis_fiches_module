package com.isep.cardis.projet_fiches_module_A2.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {
	
	@Autowired
	private SkillService skillService;

	@GetMapping("/skills/all")
	public List<Skill> getAllSkills() {
		return skillService.getAllSkills();
	}
}
