package com.usc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.usc.controller.SectionController;
import com.usc.model.Course;
import com.usc.model.Section;
import com.usc.repository.CourseRepository;
import com.usc.service.CourseService;
import com.usc.service.CourseServiceImpl;

@RunWith(SpringRunner.class)
public class SectionControllerTest {
	SectionController sectionController;
	CourseRepository mockCourseRepository;

	@Before
	public void setup() {
		sectionController = new SectionController();
		CourseServiceImpl courseService = new CourseServiceImpl();
		mockCourseRepository = Mockito.mock(CourseRepository.class);
		courseService.courseRepository = mockCourseRepository;
		//Mockito.mock(CourseServiceImpl.class);
		
		sectionController.setCourseService(courseService);
		
	}
	
	@Test
	public void testGetAll() {
	
		List<Course> courses = new ArrayList<Course>();
		Course course1 = new Course();
		course1.setTitle("course1");
		course1.setCampus("campus1");
		course1.setDepartment("dep1");
		course1.setTerm("term1");
		Section section1 = new Section();
		section1.setActualSeatRes((short) 10);
		section1.setCapacity((short) 15);
		section1.setRemainingSeat((short) 5);
		Set<Section> sections1 = new HashSet<Section>();
		course1.setSections(sections1);
		courses.add(course1);
		
		Course course2 = new Course();
		course2.setTitle("course2");
		course2.setCampus("campus2");
		course2.setDepartment("dep2");
		course2.setTerm("term2");
		Section section2 = new Section();
		section2.setActualSeatRes((short) 10);
		section2.setCapacity((short) 15);
		section2.setRemainingSeat((short) 5);
		Set<Section> sections2 = new HashSet<Section>();
		course2.setSections(sections2);
		courses.add(course2);
		Mockito.when(mockCourseRepository.findAll()).thenReturn(courses);
		
		try {
			ResponseEntity<List<Course>> response = sectionController.getAll();
			assertEquals(org.springframework.http.HttpStatus.OK, response.getStatusCode());
			List<Course> coursesInResponse = response.getBody();
			assertNotNull(coursesInResponse);
			assertEquals(2, coursesInResponse.size());
		} catch (IOException e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetAllDep() {
		List<String> depts = new ArrayList<String>();
		depts.add("dep1");
		depts.add("dep2");
		Mockito.when(mockCourseRepository.findDistinctByDepartment()).thenReturn(depts);
		
		try {
			ResponseEntity<List<String>> response = sectionController.getAllDep();
			assertEquals(org.springframework.http.HttpStatus.OK, response.getStatusCode());
			List<String> deptsInResponse = response.getBody();
			assertEquals(2, deptsInResponse.size());
			assertTrue(deptsInResponse.contains("dep1"));
			assertTrue(deptsInResponse.contains("dep2"));
		} catch (IOException e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetProfByDept() {
		List<String> insts = new ArrayList<String>();
		insts.add("inst1");
		insts.add("inst2");
		insts.add("inst3");
		Mockito.when(mockCourseRepository.findDistinctInstByDep(Mockito.anyString())).thenReturn(insts);
		
		try {
			ResponseEntity<List<String>> response = sectionController.getProfByDep("Dep1");
			assertEquals(org.springframework.http.HttpStatus.OK, response.getStatusCode());
			assertEquals(3, response.getBody().size());
			assertTrue(response.getBody().contains("inst1"));
			assertTrue(response.getBody().contains("inst2"));
			assertTrue(response.getBody().contains("inst3"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
