package com.usc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usc.WebScrapper;
import com.usc.dto.ResponseDto;
import com.usc.model.Course;
import com.usc.service.CourseService;

@Controller
public class SectionController {
	@Autowired
	private CourseService courseService;

	@PostConstruct
	public void initService() throws Exception {
		courseService.readAllCSVFiles();
	}
	
	@RequestMapping(value = "/ReadAll", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getAll() throws IOException {
		List<Course> courseList = courseService.getAllCourses();
		return ResponseEntity.ok(courseList);
	}

	@RequestMapping(value = "/getAllDep", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getAllDep() throws IOException {
		List<String> depts = courseService.getAllDep();
		return ResponseEntity.ok(depts);
	}

	@RequestMapping(value = "/getInstByDept/{dept}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getProfByDep(@PathVariable("dept") String dept) throws IOException {
		List<String> insts = courseService.getInstsByDep(dept);
		return ResponseEntity.ok(insts);
	}

	@RequestMapping(value = "/fac/{inst:.+}", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getByInst(@PathVariable("inst") String inst) throws IOException {
		ResponseDto dto = courseService.getCoursesByInst(inst);
		return ResponseEntity.ok(dto);
	}

	@RequestMapping(value = "/dept/{dept:.+}", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getByDept(@PathVariable("dept") String dept) throws IOException {
		System.out.print("getByDept");
		ResponseDto dto = courseService.getCoursesByDept(dept);
		return ResponseEntity.ok(dto);
	}

	@RequestMapping(value = "/facSummary", method = RequestMethod.GET)
	public ResponseEntity<List<ResponseDto>> getInstSummary() throws IOException {
		List<ResponseDto> dtoList = courseService.getInstSummary();
		return ResponseEntity.ok(dtoList);
	}

	@RequestMapping(value = "/deptSummary", method = RequestMethod.GET)
	public ResponseEntity<List<ResponseDto>> getDeptSummary() throws IOException {
		List<ResponseDto> dtoList = courseService.getDeptSummary();
		return ResponseEntity.ok(dtoList);
	}

	@RequestMapping(value = "/scrapeSections/{u}/{p}",method = RequestMethod.GET)
	public ResponseEntity<String> scrape(@PathVariable String u, @PathVariable String p) {
		System.out.println("Scrap Data");
		WebScrapper ws = new WebScrapper();
		ws.scrape(u, p);
		
		//return ResponseEntity.ok("Data is currently scrapping. File Created");
		try {
			courseService.readAllCSVFiles(true);
			return ResponseEntity.ok("Data is currently scrapping");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Data scrapping is not currently available");
		}
	}
	
	@RequestMapping(value = "/readScrape",method = RequestMethod.GET)
	public  void readScrape() {
		System.out.println("Read file");
		
		try {
			courseService.readAllCSVFiles(true);
			
		} catch (IOException e) {
			e.printStackTrace();			
		}
	}
}
