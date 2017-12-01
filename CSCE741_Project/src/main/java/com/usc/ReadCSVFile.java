package com.usc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.usc.model.Section;
import com.usc.model.SectionDetail;
import com.usc.model.Course;

@Component
public class ReadCSVFile {	
	@Autowired
	public ResourceLoader resourceLoader;	
	private String []files={"BMEN","CSCE","ECHE","ECIV","ELCT","EMCH","MATH"};	
	public static String DEPT="DEPT";
	public static String INST="INST";
	
	public Map<String, List<String []>> readAllFiles() throws IOException{		
		//Initilization to read CSV.
		Map<String, List<String[]>> csvValues = new TreeMap<String, List<String[]>>();
		for (String file : getInputFileNames()){
			InputStream is = getInputFileStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));	
			br.readLine(); // Skipping header line	
			//reading all lines in CSV file and extract each attribute
			for (String next, line = br.readLine(); line != null; line = next) {
			        next = br.readLine();
		        	String[] p=line.replaceAll("\\(P\\)","").replaceAll("\\s+(?=[,])", "").split(",");	
		    		List<String[]> sectionValues = new ArrayList<String[]>(); 
		        	String courseValue= p[2].toString()+" "+p[3].toString()+"-"+p[1].toString();     	
		        	sectionValues.add(p);
		        	
		  		  	if (next!=null){
		  		  		String [] p2=null;
		  		  		do{	
		  		  			p2 = next.replaceAll("\\s+(?=[,])", "").replaceAll("\\(P\\)","").replaceAll("\\s+(?=[,])", "").split(",");
		  		  			if (!p2[2].equals(""))
		  		  				break;
		  		  			String next2;
		  		  			sectionValues.add(p2);
				            next=br.readLine();
		  		  		}while(next != null);
			        	csvValues.put(courseValue, sectionValues);
		  		  	}
		  		  	else 
			        	csvValues.put(courseValue, sectionValues);
		     }	    	
		     br.close(); // close the buffer reader
		}
   		 return csvValues; // Return list of all section objects. 
	}

	public InputStream getInputFileStream(String file) throws IOException {
		Resource resource = resourceLoader.getResource("classpath:"+file+".csv");
		InputStream is = resource.getInputStream();
		return is;
	}
	
	public String [] getInputFileNames() {
		return this.files;
	}
	
	public List<String []> getCoursesByWhere(String where, String value) throws IOException{		
		//Initilization to read CSV.
		InputStream is = resourceLoader.getResource("").getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));			
		// List of all sections loaded from CSV file.
		List<String []> courseList = new ArrayList<String []>();
		List <String> checkList = new ArrayList <String>();

		int index = (where.equals(DEPT)?2:14);
		
		br.readLine(); // Skipping header line
		//reading all lines in CSV file and extract each attribute
		for (String next, line = br.readLine(); line != null; line = next) {
		        next = br.readLine();
	        	String[] p=line.replaceAll("\\s+(?=[,])", "").split(",");	        	
	        	
	        	// Loading each value to its respective attribute
	        	String course = p[2].toString()+" "+p[3].toString();
	        	String instructor = p[14].toString();
	        	String title =  p[8].toString();		        	
	        	
	        	String checkValue= course+" "+instructor;
	        		        	
	        	if (p[index].toString().contains(value) && !checkList.contains(checkValue)){
	        		courseList.add(new  String []{course, instructor, title});
	        		checkList.add(checkValue);
	        	}
	  		  	// if the next line is related to current section: this is the only special case found in CSV file. 
	  		  	// There is no occurrence more than twice for each section.
	        	if (next!=null){
			        	String[] p2=next.replaceAll("\\s+(?=[,])", "").split(",");  
			        	// if the next line related to current one. In this file case, if there is no value, it means there is other info. for this section needs to be extracted.
			            if (p2[0].equals("")){
			            	if(p2[index].toString().contains(value) && !checkList.contains(checkValue)){ 
			            		courseList.add(new  String []{course, instructor, title});
			            		checkList.add(checkValue);	  	 			      
			            	}
			            	next=br.readLine();	
			            }        		
	  		  	}	  		
		 }	    	
	     br.close(); // close the buffer reader
		 return courseList; // Return list of all section objects. 
	}
}





