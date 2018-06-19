package com.isep.cardis.projet_fiches_module_A2.sheet;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import com.isep.cardis.projet_fiches_module_A2.skill.Skill;
import com.isep.cardis.projet_fiches_module_A2.skill.SkillService;
import com.isep.cardis.projet_fiches_module_A2.user.User;
import com.isep.cardis.projet_fiches_module_A2.user.UserService;
import com.isep.cardis.projet_fiches_module_A2.pdf.PdfGeneratorUtil;

@Controller
public class SheetController {
	
	@Autowired
	private SheetService sheetService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private UserService userService;
	@Autowired
	private PdfGeneratorUtil PdfGeneratorUtil;
	
	
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
	public String getOneSheet(ModelMap model,@PathVariable Integer id) throws Exception {
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
	@GetMapping(value= {"/sheet/edit/{id}"})
	public String editOneSheet(ModelMap model, @PathVariable Integer id) {
		List<Skill> skills = skillService.getAllSkills();
		List<User> teachers  = userService.getAllUsersByRole("teacher");
		Sheet Sheet = sheetService.getOneSheet(id).get();
		model.addAttribute("sheet", Sheet);
		model.addAttribute("skills", skills);
		model.addAttribute("teachers", teachers);
		return "editSheet";
	}
	@GetMapping(value= {"/sheet/export/{id}"})
	public String exportOneSheet(ModelMap model, @PathVariable Integer id, HttpServletResponse response) throws Exception {
		Sheet  Sheet = sheetService.getOneSheet(id).get();
		model.addAttribute("sheet", Sheet);
		Map<String,Sheet> data = new HashMap<String,Sheet>();
	    data.put("sheet",Sheet);
	    PdfGeneratorUtil.createPdf("sheet", data, Sheet);
	    PdfGeneratorUtil.DownloadPDF(response, Sheet);
	    return "export";
	}
	@PostMapping(value= {"/sheet/update/{id}"})
	public String editOneUpdate(@ModelAttribute Sheet sheet, @PathVariable Integer id) {
		sheet.setId(id);
		sheetService.updateSheet(sheet);
		return "redirect:/all/sheets";
	}
	@PutMapping("/sheet/add")
	public String createOneSheet(@ModelAttribute Sheet sheet) {
		sheet.setPublished(false);
		sheetService.addSheet(sheet);
		return "redirect:/all/sheets";
	}
}
