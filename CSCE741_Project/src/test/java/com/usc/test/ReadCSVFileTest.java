package com.usc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.usc.ReadCSVFile;

public class ReadCSVFileTest {

	@Test
	public void testReadAllFilesScrape() {
		ReadCSVFile readCSVFile = new ReadCSVFile();
		try {
			Map<String, List<String[]>> map = readCSVFile.readAllFilesScrape();
			System.out.println(map.keySet());
			assertTrue(map.keySet().contains("ARAB 122-47502"));
			assertEquals(32, map.keySet().size());
		} catch (IOException e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testInputFiles() {
		ReadCSVFile readCSVFile = new ReadCSVFile();
		String[] inputFiles = readCSVFile.getInputFileNames();
		assertEquals(7, inputFiles.length);
		assertTrue(Arrays.asList(inputFiles).contains("BMEN"));
		assertTrue(Arrays.asList(inputFiles).contains("CSCE"));
		assertTrue(Arrays.asList(inputFiles).contains("ECHE"));
		assertTrue(Arrays.asList(inputFiles).contains("ECIV"));
		assertTrue(Arrays.asList(inputFiles).contains("ELCT"));
		assertTrue(Arrays.asList(inputFiles).contains("EMCH"));
		assertTrue(Arrays.asList(inputFiles).contains("MATH"));
		
	}
	
	
	@Test
	public void test() {
		ReadCSVFile readCSVFile = Mockito.mock(ReadCSVFile.class);
		String [] files = {"BMEN"};
		Mockito.when(readCSVFile.getInputFileNames()).thenReturn(files);
		File initialFile = new File("src/test/resources/BMEN.csv");
		InputStream inputStream = null;
	    try {
			inputStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			assertTrue(false);
		}
	    
	    try {
			Mockito.when(readCSVFile.getInputFileStream(Mockito.anyString())).thenReturn(inputStream);
		} catch (IOException e1) {
			assertTrue(false);
		}
		
		Map<String, List<String[]>> courseSectionMap = null;
		try {
			courseSectionMap = readCSVFile.readAllFiles();
		} catch (IOException e) {
			assertTrue(false);
		}
		if (courseSectionMap == null) {
			assertTrue(false);
		}

	}

	@Test
	public void testFileNotFound() {
		ReadCSVFile readCSVFile = Mockito.mock(ReadCSVFile.class);
		String [] files = {"BMEN"};
		Mockito.when(readCSVFile.getInputFileNames()).thenReturn(files);
		File initialFile = new File("src/test/resources/BMEN.csv");
		InputStream inputStream = null;
	    try {
			inputStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			assertTrue(false);
		}
	    
	    try {
			Mockito.when(readCSVFile.getInputFileStream(Mockito.anyString())).thenReturn(null);
		} catch (IOException e1) {
			assertTrue(false);
		}
		
		Map<String, List<String[]>> courseSectionMap = null;
		try {
			courseSectionMap = readCSVFile.readAllFiles();
		} catch (IOException e) {
			assertTrue(false);
		}
		if (courseSectionMap == null) {
			assertTrue(false);
		}

	}
}
