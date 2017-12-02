package com.usc.dto;

public class ResponseDto {
		public String title;
		public int numberOfSection;
		public int numberOfStudent;
		public int fte;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
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