package com.usc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.usc.dto.DepartmentResponseDto;
import com.usc.dto.InstructorResponseDto;
import com.usc.model.Course;

 
public interface CourseService {
	public boolean readAllCSVFiles() throws IOException;
	public boolean readCSVFile(String filename);
	public List<Course> getAllCourses();
	public DepartmentResponseDto getCoursesByDept(String dept);
	public InstructorResponseDto getCoursesByInst(String inst);
	public List<DepartmentResponseDto> getDeptSummary();
	public List<InstructorResponseDto> getInstSummary();
}
