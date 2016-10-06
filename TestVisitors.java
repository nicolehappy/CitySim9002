package deliverable2;


import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class TestVisitors {
	
	private Visitors visitors = new Visitors();

	/**
	 * Double + Stub
	 * Mock the random generator
	 * Set the random number to be 1
	 * Five visitors should be the same 
	 */
	@Test
	public void testNextVisitor0() {
		
		Generator mockGenerator = Mockito.mock(Generator.class);
		Mockito.when(mockGenerator.randomGenerator()).thenReturn(1);
		
		Visitors visitors = new Visitors();
		String visitorList[] = new String[5];
		
		for(int i=0; i<5; i++) {
			visitorList[i] = visitors.nextVisitor(mockGenerator);
		}
		
		boolean areEqual = true;
		for(int i=0; i<5; i++) {
			if(visitorList[i] != visitorList[0]) areEqual = false;
		}
		
		assertTrue(areEqual);
	}
	
	/**
	 * Using real random and visitor class
	 * generator classes will be called five times
	 * accordingly five integers should be generated
	 * Generated Visitors shouldn't be the same 
	 */
	@Test
	public void testNextVisitor1() {
		
		Generator generator = new Generator(9, 4);
		
		Visitors visitors = new Visitors();
		String visitorList[] = new String[5];
		
		for(int i=0; i<5; i++) {
			visitorList[i] = visitors.nextVisitor(generator);
		}
		
		boolean areEqual = true;
		for(int i=0; i<5; i++) {
			if(visitorList[i] != visitorList[0]) areEqual = false;
		}
		
		assertFalse(areEqual);
	}
	
	/**
	 * Every element has unique index in visitors list
	 * Mock the visitors generator
	 * Set the random array to be {3, 2, 1, 3, 0}
	 * fiveVisiting should return a string array
	 */
	@Test
	public void testFiveVisiting1() {
		
		Generator mockGenerator = Mockito.mock(Generator.class);
		int[] indexArr = {3, 2, 1, 3, 0};
		Mockito.when(mockGenerator.randomGenerateVisitor()).thenReturn(indexArr);
		
		String[] arr = {"Blogger", "Business Person", "Professor", "Blogger", "Student"};
		assertArrayEquals(arr, visitors.fiveVisiting(mockGenerator));
		
	}
	
	//Business Person should like 2 - Squirrel Hill
	//Given the visitor to be Business Person
	//Given the location to be 2
	//The likeLocation function should return true
	@Test
	public void testLikeLocation0() {
		
		String visitor = "Business Person";
		String location = "Squirrel Hill";
		
		assertTrue(visitors.likeLocation(visitor, location));
	}
	
	//Student shouldn't like 1 - The Cathedral of Learning
	//Given the visitor to be Student
	//Given the location to be 1
	//The likeLocation function should return false
	@Test
	public void testLikeLocation1() {
		
		String visitor = "Student";
		String location = "The Cathedral of Learning";
		
		assertFalse(visitors.likeLocation(visitor, location));
	}

}