package com.usc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.usc.dto.ResponseDto;
import com.usc.model.Course;

 
public interface CourseService {
	public boolean readAllCSVFiles() throws IOException;
	public boolean readCSVFile(String filename);
	public List<String> getAllDep();
	public List<String> getInstsByDep(String dept);
	public List<Course> getAllCourses();
	public ResponseDto getCoursesByDept(String dept);
	public ResponseDto getCoursesByInst(String inst);
	public List<ResponseDto> getDeptSummary();
	public List<ResponseDto> getInstSummary();
}
