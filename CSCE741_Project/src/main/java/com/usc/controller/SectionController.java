package com.usc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.usc.dto.DepartmentResponseDto;
import com.usc.dto.InstructorResponseDto;
import com.usc.model.Course;
import com.usc.model.Section;
import com.usc.repository.CourseRepository;
import com.usc.service.CourseService;

@Controller
public class SectionController {	
	@Autowired
	private CourseService courseService;

	@PostConstruct
	public void initService() throws Exception {
		courseService.readAllCSVFiles();
	}
	
	@RequestMapping(value="/ReadAll", method=RequestMethod.GET)		
	public ResponseEntity<List<Course>> getAll() throws IOException {
	    List<Course> courseList = courseService.getAllCourses();
		return  ResponseEntity.ok(courseList);
	}
	
	@RequestMapping(value = "/fac/{inst:.+}", method = RequestMethod.GET)
	public ResponseEntity<InstructorResponseDto> getByInst(@PathVariable("inst") String inst) throws IOException {
	    InstructorResponseDto dto = courseService.getCoursesByInst(inst);
		return  ResponseEntity.ok(dto);
	}
	
	@RequestMapping(value = "/dept/{dept:.+}", method = RequestMethod.GET)
	public ResponseEntity<DepartmentResponseDto> getByDept(@PathVariable("dept") String dept) throws IOException {
	    DepartmentResponseDto dto = courseService.getCoursesByDept(dept);
		return  ResponseEntity.ok(dto);
	}
	
	@RequestMapping(value = "/facSummary", method = RequestMethod.GET)
	public ResponseEntity<List<InstructorResponseDto>> getInstSummary() throws IOException {
	    List<InstructorResponseDto> dtoList = courseService.getInstSummary();
		return  ResponseEntity.ok(dtoList);
	}
	
	@RequestMapping(value = "/deptSummary", method = RequestMethod.GET)
	public ResponseEntity<List<DepartmentResponseDto>> getDeptSummary() throws IOException {
		List<DepartmentResponseDto> dtoList = courseService.getDeptSummary();
		return  ResponseEntity.ok(dtoList);
	}
}
