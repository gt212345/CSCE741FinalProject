package com.usc.model;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "course")
public class Course implements Serializable {
	//Attributes

	@Id
	@Column(name="COURSE_NUMBER")
	private String courseNumber;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	
	@Column(name="CAMPUS")
	private String campus; 
	
	@Column(name="CREDIT")
	private String credit;
	
	@Column(name="TERM")
	private String term;
	
	@Column(name="YEAR")
	private String year;
	
	@Column(name="SEMESTER")
	private String semester;
	
	@Column(name="TITLE")
	private String title;
	
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
	private Set<Section> sections; 
	
	//Getters and setters	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String course) {
		this.courseNumber = course;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonManagedReference
	public Set<Section> getSections() {
		return sections;
	}
	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
}