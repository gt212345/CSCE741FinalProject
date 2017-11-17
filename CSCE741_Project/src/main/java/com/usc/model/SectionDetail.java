package com.usc.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "section_detail")
public class SectionDetail implements Serializable {
	
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SECTION_DETAIL_ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "SECTION_CRN", referencedColumnName = "SECTION_CRN")
	private Section section;
	
	@Column(name="DAYS")
	private String days; // Which days this section will be held
	
	@Column(name="TIME")
	private String time; // what time this section will be held
	
	@Column(name="INSTRUCTOR")
	private String instructor; // Who will teach this particular section's date, time and location
	
	@Column(name="DATE")
	private String date; // Date allocated for teaching this's course section. 
	
	@Column(name="LOCATION")
	private String location; // Physical location of course's section

	//Getters and setters
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@JsonBackReference
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
}
