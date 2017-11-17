package com.usc.dto;


public class InstructorResponseDto {
	public String instructor;
	public int numberOfSection;
	public int numberOfStudent;
	public int fte;
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getNumberOfSection() {
		return numberOfSection;
	}
	public void setNumberOfSection(int numberOfSection) {
		this.numberOfSection = numberOfSection;
	}
	public int getNumberOfStudent() {
		return numberOfStudent;
	}
	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}
	public int getFTE() {
		return fte;
	}
	public void setFTE(int fte) {
		this.fte = fte;
	} 
	 
	
}