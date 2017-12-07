package com.usc.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.mockito.Mockito;
import com.usc.ReadCSVFile;

class ReadCSVFileTest {

	@Test
	void testInputFiles() {
		ReadCSVFile readCSVFile = Mockito.spy(new ReadCSVFile());
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
	void test() {
		ReadCSVFile readCSVFile = Mockito.mock(ReadCSVFile.class);
		String [] files = {"BMEN"};
		Mockito.when(readCSVFile.getInputFileNames()).thenReturn(files);
		File initialFile = new File("src/test/resources/BMEN.csv");
		InputStream inputStream = null;
	    try {
			inputStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			fail("BMEN.csv not found at src/test/resources.");
		}
	    
	    try {
			Mockito.when(readCSVFile.getInputFileStream(Mockito.anyString())).thenReturn(inputStream);
		} catch (IOException e1) {
			fail("Another error occured in creating stream");
		}
		
		Map<String, List<String[]>> courseSectionMap = null;
		try {
			courseSectionMap = readCSVFile.readAllFiles();
		} catch (IOException e) {
			fail("An error occured");
		}
		if (courseSectionMap == null) {
			fail("read csv failed");
		}

	}

	@Test
	void testFileNotFound() {
		ReadCSVFile readCSVFile = Mockito.mock(ReadCSVFile.class);
		String [] files = {"BMEN"};
		Mockito.when(readCSVFile.getInputFileNames()).thenReturn(files);
		File initialFile = new File("src/test/resources/BMEN.csv");
		InputStream inputStream = null;
	    try {
			inputStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			fail("BMEN.csv not found at src/test/resources.");
		}
	    
	    try {
			Mockito.when(readCSVFile.getInputFileStream(Mockito.anyString())).thenReturn(null);
		} catch (IOException e1) {
			fail("Another error occured in creating stream");
		}
		
		Map<String, List<String[]>> courseSectionMap = null;
		try {
			courseSectionMap = readCSVFile.readAllFiles();
		} catch (IOException e) {
			fail("An error occured");
		}
		if (courseSectionMap == null) {
			fail("read csv failed");
		}

	}
}
