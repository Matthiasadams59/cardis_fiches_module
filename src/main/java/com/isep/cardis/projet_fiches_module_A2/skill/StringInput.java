package com.isep.cardis.projet_fiches_module_A2.skill;
import javax.servlet.http.HttpServletRequest;

public class StringInput {
	
	private String Input;
	
	public StringInput(HttpServletRequest request) {
		this.Input = request.getParameter("Input");
	}
	
	public StringInput() {
		
	}
	
	public void setStringInput(String Input) {
		this.Input = Input;
	}
	
	public String getStringInput() {
		return this.Input;
	}

}
