package com.isep.cardis.projet_fiches_module_A2.skill;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping("/skills/all")
	public String getAllSkills(ModelMap model){
		List<Skill> Skills = skillService.getAllSkills();
		model.addAttribute("skills", Skills);
		return "delSkills";
	}
	
	@GetMapping(value= {"/skill/delete/{id}"})
	public String deleteOneSheet(ModelMap model,@PathVariable Integer id) {
		skillService.deleteSkill(id);
		return "redirect:/skills/all";
	}
	
	@GetMapping(value= {"/Skills", "/Skills"})
	public String Skills(ModelMap model){
		List<Skill> Skills = skillService.getAllSkills();
		model.addAttribute("skills", Skills);
		return "Skills";
		
	}
	
	@GetMapping(value= {"/Skill", "/Skill"})
	public String Skill(){
		return "Skill";
	}
	
	@PutMapping("/skill/add")
	public String AddSkills(HttpServletRequest request) throws ServletException, IOException{
		StringInput Input = new StringInput(request);
		Skill Skill = new Skill();
		Skill.setSkill(Input.getStringInput());
		skillService.addSkill(Skill);
		return "redirect:/all/sheets";
	}
}
