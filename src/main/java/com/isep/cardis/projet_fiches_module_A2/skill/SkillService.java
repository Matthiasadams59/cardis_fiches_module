package com.isep.cardis.projet_fiches_module_A2.skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;
	
	public List<Skill> getAllSkills() {
		return (List<Skill>) skillRepository.findAll();
	}
	
	public void addSkill(Skill skill){
		skillRepository.save(skill);
	}
	
	public void deleteSkill(Integer id){
		skillRepository.deleteById(id);
	}
}
