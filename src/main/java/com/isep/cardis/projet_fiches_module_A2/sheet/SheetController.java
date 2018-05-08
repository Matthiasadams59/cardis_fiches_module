package com.isep.cardis.projet_fiches_module_A2.sheet;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SheetController {
	
	@Autowired
	private SheetService sheetService;
	
	@GetMapping("/Sheets")
	public String getSheetsPublised(ModelMap model) {
		List<Sheet> sheets = sheetService.findByIsPublished(true);
		model.addAttribute("sheets",sheets);
		return "Sheets";
	}
	
	@GetMapping("/Sheets/{id}")
	public String getOneSheet(ModelMap model,@PathVariable Integer id) {
		Optional<Sheet>  sheet = sheetService.getOneSheet(id);
		model.addAttribute("sheet", sheet.get());
		return "sheet";
	}
}
