package com.isep.cardis.projet_fiches_module_A2.purpose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.isep.cardis.projet_fiches_module_A2.sheet.Sheet;

@Entity
public class Purpose {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String contents;
	private String teacherTools;
	private String studentTools;
	
	@OneToOne
	Sheet sheet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getTeacherTools() {
		return teacherTools;
	}

	public void setTeacherTools(String teacherTools) {
		this.teacherTools = teacherTools;
	}

	public String getStudentTools() {
		return studentTools;
	}

	public void setStudentTools(String studentTools) {
		this.studentTools = studentTools;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public Purpose(Integer id, String contents, String teacherTools, String studentTools, Sheet sheet) {
		super();
		this.id = id;
		this.contents = contents;
		this.teacherTools = teacherTools;
		this.studentTools = studentTools;
		this.sheet = sheet;
	}
	public Purpose() {
		
	}
	
}