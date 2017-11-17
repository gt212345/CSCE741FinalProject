package com.usc.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "section")
public class Section implements Serializable {
	
	//Attributes
	@Id
	@Column(name="SECTION_CRN")
	private Long sectionCRN;  
	
	@Column(name="SECTION_NUMBER")
	private String sectionNumber;
	
	@ManyToOne 
    @JoinColumn(name = "COURSE_NUMBER", referencedColumnName = "COURSE_NUMBER")
	private Course course;
	
	@OneToMany(mappedBy = "section", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<SectionDetail> sectionDetails; 
	
	@Column(name="CAPACITY")
	private short capacity; //  Total seat capacity available for this section
	
	@Column(name="ACTUAL_SEAT_RES")
	private short actualSeatRes; //Actual seat reserved
	
	@Column(name="REMAINING_SEAT")
	private short remainingSeat; //Remaining seat for registration
	
	
	//Getters and setters
	public String getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(String sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	public Long getSectionCRN() {
		return sectionCRN;
	}
	public void setSectionCRN(Long CRN) {
		this.sectionCRN = CRN;
	}
	public short getCapacity() {
		return capacity;
	}
	public void setCapacity(short capacity) {
		this.capacity = capacity;
	}
	public short getActualSeatRes() {
		return actualSeatRes;
	}
	public void setActualSeatRes(short actualSeatRes) {
		this.actualSeatRes = actualSeatRes;
	}
	public short getRemainingSeat() {
		return remainingSeat;
	}
	public void setRemainingSeat(short remainingSeat) {
		this.remainingSeat = remainingSeat;
	}
	
    @JsonBackReference
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@JsonManagedReference
	public Set<SectionDetail> getSectionDetails() {
		return sectionDetails;
	}
	public void setSectionDetails(Set<SectionDetail> sectionDetails) {
		this.sectionDetails = sectionDetails;
	}

	
}
