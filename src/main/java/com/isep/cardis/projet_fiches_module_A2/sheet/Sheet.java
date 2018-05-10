package com.isep.cardis.projet_fiches_module_A2.sheet;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import com.isep.cardis.projet_fiches_module_A2.skill.Skill;
import com.isep.cardis.projet_fiches_module_A2.user.User;

@Entity
public class Sheet {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String title;
	private int ects;
	private String login;
	private String hours;
	private boolean isteamwork;
	private String description;
	private String requirement;
	private String content;
	private String teacherTools;
	private String studentTools;
	private String nextModule;
	private String learningMethod;
	private String grade_rating;
	private String language;
	private String bibliography;
	private String keywords;
	private boolean isPublished;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "course_skills", 
        joinColumns = { @JoinColumn(name = "sheet_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
    Set<Skill> skills = new HashSet<>();;

	@OneToOne
	User user;
	
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects = ects;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public boolean isIsteamwork() {
		return isteamwork;
	}
	public void setIsteamwork(boolean isteamwork) {
		this.isteamwork = isteamwork;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getNextModule() {
		return nextModule;
	}
	public void setNextModule(String nextModule) {
		this.nextModule = nextModule;
	}
	public String getLearningMethod() {
		return learningMethod;
	}
	public void setLearningMethod(String learningMethod) {
		this.learningMethod = learningMethod;
	}
	public String getGrade_rating() {
		return grade_rating;
	}
	public void setGrade_rating(String grade_rating) {
		this.grade_rating = grade_rating;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getBibliography() {
		return bibliography;
	}
	public void setBibliography(String bibliography) {
		this.bibliography = bibliography;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Set<Skill> getSkills() {
		return skills;
	}
	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isPublished() {
		return isPublished;
	}
	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Sheet(String title, int ects, String login, String hours, boolean isteamwork, String description,
			String requirement, String content, String teacherTools, String studentTools, String nextModule,
			String learningMethod, String grade_rating, String language, String bibliography, String keywords,
			boolean isPublished, Set<Skill> skills, User user) {
		super();
		this.title = title;
		this.ects = ects;
		this.login = login;
		this.hours = hours;
		this.isteamwork = isteamwork;
		this.description = description;
		this.requirement = requirement;
		this.content = content;
		this.teacherTools = teacherTools;
		this.studentTools = studentTools;
		this.nextModule = nextModule;
		this.learningMethod = learningMethod;
		this.grade_rating = grade_rating;
		this.language = language;
		this.bibliography = bibliography;
		this.keywords = keywords;
		this.isPublished = isPublished;
		this.skills = skills;
		this.user = user;
	}
	public Sheet() {

	}	
}
