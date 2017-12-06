package com.usc;

public class SectionScrapper {
	private String crn;
	private String subj;
	private String course;
	private String sec;
	private String campus;
	private String cred;
	private String term;
	private String title;
	private String days;
	private String time;
	private String capacity;
	private String actual;
	private String remaing;
	private String instructor;
	private String date;
	private String location;
	private String attribute;

	public SectionScrapper() {

	}

	public SectionScrapper(String crn, String subj, String course, String sec, String campus, String cred, String term,
			String title, String days, String time, String capacity, String actual, String remaing, String instructor,
			String date, String location, String attribute) {
		super();
		this.crn = crn;
		this.subj = subj;
		this.course = course;
		this.sec = sec;
		this.campus = campus;
		this.cred = cred;
		this.term = term;
		this.title = title;
		this.days = days;
		this.time = time;
		this.capacity = capacity;
		this.actual = actual;
		this.remaing = remaing;
		this.instructor = instructor;
		this.date = date;
		this.location = location;
		this.attribute = attribute;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getSubj() {
		return subj;
	}

	public void setSubj(String subj) {
		this.subj = subj;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSec() {
		return sec;
	}

	public void setSec(String sec) {
		this.sec = sec;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getCred() {
		return cred;
	}

	public void setCred(String cred) {
		this.cred = cred;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public String getRemaing() {
		return remaing;
	}

	public void setRemaing(String remaing) {
		this.remaing = remaing;
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

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String toString() {

		return this.crn + ";" + this.subj + ";" + this.course + ";" + this.sec + ";" + this.campus + ";" + this.cred
				+ ";" + this.term + ";" + this.title + ";" + this.days + ";" + this.time + ";" + this.capacity + ";"
				+ this.actual + ";" + this.remaing + ";" + this.instructor + ";" + this.date + ";" + this.location + ";"
				+ this.attribute;
	}

}
