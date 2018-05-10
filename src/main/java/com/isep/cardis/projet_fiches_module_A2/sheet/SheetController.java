package com.isep.cardis.projet_fiches_module_A2.sheet;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SheetController {
	
	@Autowired
	private SheetService sheetService;
	
	@GetMapping(value= {"Sheets", "sheets"})
	public List<Sheet> getSheetsPublised(ModelMap model) {
		List<Sheet> sheets = sheetService.findByIsPublished(true);
		model.addAttribute("sheets",sheets);
		return sheets;
	}
	@GetMapping(value= {"/sheets/{id}", "/Sheets/{id}", "/Sheet/{id}", "/sheet/{id}"})
	public String getOneSheet(ModelMap model,@PathVariable Integer id) {
		Optional<Sheet>  sheet = sheetService.getOneSheet(id);
		model.addAttribute("sheet", sheet.get());
		return "sheet";
	}
}
