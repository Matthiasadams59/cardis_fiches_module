package com.isep.cardis.projet_fiches_module_A2.sheet;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.isep.cardis.projet_fiches_module_A2.skill.Skill;
import com.isep.cardis.projet_fiches_module_A2.skill.SkillService;
import com.isep.cardis.projet_fiches_module_A2.user.User;
import com.isep.cardis.projet_fiches_module_A2.user.UserService;

@Controller
public class SheetController {
	
	@Autowired
	private SheetService sheetService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private UserService userService;
	
	@GetMapping(value= {"Sheets", "sheets"})
	public List<Sheet> getSheetsPublised(ModelMap model) {
		List<Sheet> sheets = sheetService.findByIsPublished(true);
		model.addAttribute("sheets",sheets);
		return sheets;
	}
	@GetMapping(value= {"All/Sheets", "all/sheets"})
	public String getAllSheets(ModelMap model) {
		List<Sheet> sheets = sheetService.getAllSheets();
		model.addAttribute("sheets",sheets);
		return "sheets";
	}
	
	@GetMapping(value= {"/sheets/{id}", "/Sheets/{id}", "/Sheet/{id}", "/sheet/{id}"})
	public String getOneSheet(ModelMap model,@PathVariable Integer id) {
		Optional<Sheet>  sheet = sheetService.getOneSheet(id);
		model.addAttribute("sheet", sheet.get());
		return "sheet";
	}
	
	@GetMapping(value= {"/sheet/delete/{id}"})
	public String deleteOneSheet(ModelMap model,@PathVariable Integer id) {
		sheetService.deleteSheet(id);
		return "redirect:/sheets";
	}
	
	@GetMapping(value= {"/sheet/create"})
	public String createOneSheet(ModelMap model) {
		List<Skill> skills = skillService.getAllSkills();
		List<User> teachers  = userService.getAllUsersByRole("teacher");
		Sheet newSheet = new Sheet();
		model.addAttribute("sheet", newSheet);
		model.addAttribute("skills", skills);
		model.addAttribute("teachers", teachers);
		return "formSheet";
	}
	
	@PostMapping("/sheet/add")
	public String createOneSheet(@ModelAttribute Sheet sheet, HttpServletRequest request) {
		sheet.setPublished(false);
		System.out.println(sheet.getUser());
		//Optional<User>  responsable = userService.getUser();
		sheetService.addSheet(sheet);
		return "redirect:/all/sheets";
	}
}
