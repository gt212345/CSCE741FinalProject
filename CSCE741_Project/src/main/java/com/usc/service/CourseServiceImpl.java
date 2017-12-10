package com.usc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usc.ReadCSVFile;
import com.usc.dto.ResponseDto;
import com.usc.model.Course;
import com.usc.model.Section;
import com.usc.model.SectionDetail;
import com.usc.repository.CourseRepository;
import com.usc.repository.SectionDetailRepository;
import com.usc.repository.SectionRepository;

@Component
public class CourseServiceImpl implements CourseService{
	@Autowired
	private ReadCSVFile readCSVFile;
	
	@Autowired
	public CourseRepository courseRepository;
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Autowired
	private SectionDetailRepository sectionDetailRepository;
	
	public boolean readAllCSVFiles(boolean scrape) throws IOException {
		try {
			List<Course> courseList = null;
			if (scrape) {
				courseList = convertLinesToCourses(readCSVFile.readAllFilesScrape());
			} else {
				courseList = convertLinesToCourses(readCSVFile.readAllFiles());
			}
			for (Course course : courseList)
				courseRepository.save(course);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean readCSVFile(String filename){
		return false;
	}
	
	public List<String> getAllDep(){
		return courseRepository.findDistinctByDepartment();
	}
	
	public List<String> getInstsByDep(String dept){
		return courseRepository.findDistinctInstByDep(dept);
	}
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}

	public List<Course> getCoursesByProf(String prof){
		
		return null;
	}
	
	private List<Course> convertLinesToCourses(Map<String, List<String[]>> lines){	
		Course course = new Course();
		Section section = new Section();
		Set<Section> sections = new HashSet<Section>();
		List<Course> courseList = new ArrayList<Course>();

		Set<String> keys = lines.keySet();
		
		Iterator iterator = lines.keySet().iterator(); 		
		String next = iterator.next().toString();
		
		for(String key: keys){			
		    if (iterator.hasNext())
		 		next = iterator.next().toString();
		 	else
		 		next = "";
			List<String[]> sectionLineList = lines.get(key);
			Set<SectionDetail> sectionDetailSet = new HashSet<SectionDetail>();
			for (int i=0; i<sectionLineList.size(); i++){
				String [] sectionLine = sectionLineList.get(i);
				if (!sectionLine[2].toString().equals("")){
					course = new Course();
					section = new Section();
					course.setDepartment(sectionLine[2].toString());
					course.setCourseNumber(sectionLine[3].toString()+sectionLine[2].toString());
					course.setCampus(sectionLine[5].toString());
					course.setCredit(sectionLine[6]);
					course.setTerm(sectionLine[7].toString());
					course.setTitle(sectionLine[8].toString());
					course.setYear("2017");
					course.setSemester("FALL");
					section.setSectionCRN(Long.parseLong(sectionLine[1]));
					section.setSectionNumber(sectionLine[4]);
					if (sectionLine[11].equals("TBA") || !sectionLine[11].equals("")) {
						section.setCapacity((short) 0);
					} else {
						section.setCapacity(Short.parseShort(sectionLine[11]));
					}

					if (sectionLine[12].equals("TBA") || sectionLine[12].equals("")) {
						section.setActualSeatRes((short) 0);
					} else {
						section.setActualSeatRes(Short.parseShort(sectionLine[12]));
					}

					if (sectionLine[13].equals("TBA") || sectionLine[13].equals("")) {
						section.setRemainingSeat((short) 0);
					} else {					
						section.setRemainingSeat(Short.parseShort(sectionLine[13]));
					}
				}		
				SectionDetail sectionDetail= new SectionDetail();
				sectionDetail.setDays(sectionLine[9].toString());
				sectionDetail.setTime(sectionLine[10].toString());
				sectionDetail.setInstructor(sectionLine[14].toString());
				sectionDetail.setDate(sectionLine[15].toString());
				sectionDetail.setLocation(sectionLine[16].toString());
				sectionDetail.setSection(section);
				sectionDetailSet.add(sectionDetail);
				
				if (i == sectionLineList.size()-1){
					section.setSectionDetails(sectionDetailSet);
					section.setCourse(course);
				}
			}		
			
			if (!key.equals(next))
				sections.add(section);
			if (!key.split("-")[0].equals(next.split("-")[0])){
				course.setSections(sections);
				courseList.add(course);
				sections = new HashSet<Section>();
			}			
		}				
		return courseList;
	}
	
	public ResponseDto getCoursesByInst(String inst){
		List<Section> sectionList = sectionRepository.getSectionByInst(inst);
		List<Course> courseList = courseRepository.getCoursesByInst(inst);
		int numberOfSection = 0;
		int numberOfStudent = 0;
		int numberOfCreditHours =0;
		
		for (int i=0; i<courseList.size(); i++){
			Course course = courseList.get(i);
			numberOfCreditHours += isNumeric(course.getCredit())?Integer.parseInt(course.getCredit()):0 ;
		}
		
		for (int i=0; i<sectionList.size(); i++){
			Section section = sectionList.get(i);
			String credit = section.getCourse().getCredit();
			numberOfSection++;
			numberOfStudent+=section.getActualSeatRes();
		}
		if (sectionList.size()>0){
			ResponseDto dto = new ResponseDto();
			dto.setTitle(inst);
			dto.setNumberOfSection(numberOfSection);
			dto.setNumberOfStudent(numberOfStudent);
			dto.setFTE((numberOfStudent*numberOfCreditHours)/15);
			return dto;
		}
		else
			return null;
	}
	
	public ResponseDto getCoursesByDept(String dept){
		List<Course> courseList = courseRepository.getCoursesByDept(dept);
		
		int numberOfSection = 0;
		int numberOfStudent = 0;
		int numberOfCreditHours =0;
		

		for (int i=0; i<courseList.size(); i++){
			Course course = courseList.get(i);
			numberOfCreditHours += isNumeric(course.getCredit())?Integer.parseInt(course.getCredit()):0;
			Set<Section> sectionSet = course.getSections();
			for (Section section : sectionSet){
				numberOfSection++;
				numberOfStudent+=section.getActualSeatRes();
			}
		}
		
		if (courseList.size()>0){
			ResponseDto dto = new ResponseDto();
			dto.setTitle(dept);
			dto.setNumberOfSection(numberOfSection);
			dto.setNumberOfStudent(numberOfStudent);
			dto.setFTE((numberOfStudent*numberOfCreditHours)/15);
			return dto;
		}
		else
			return null;
	}
		
	public List<ResponseDto> getInstSummary(){
		List<String> listOfInstructor = sectionDetailRepository.findDistinctByInstructor();
		List <ResponseDto> list = new ArrayList<ResponseDto>();
		for (int i=0; i<listOfInstructor.size(); i++){
			ResponseDto dto = getCoursesByInst(listOfInstructor.get(i));
			list.add(dto);
		}
	
		return list;
	}
	
	public List<ResponseDto> getDeptSummary(){
		List<String> departmentList = courseRepository.findDistinctByDepartment();
		List <ResponseDto> list = new ArrayList<ResponseDto>();
		for (int i=0; i<departmentList.size(); i++){
			ResponseDto dto = getCoursesByDept(departmentList.get(i));
			list.add(dto);
		}
		return list;
	}

	
	private boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
