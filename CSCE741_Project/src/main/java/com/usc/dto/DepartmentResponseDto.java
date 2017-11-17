package com.usc.dto;

public class DepartmentResponseDto {
		public String department;
		public int numberOfSection;
		public int numberOfStudent;
		public int fte;
		
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
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
			this.fte =  fte;
		} 
}