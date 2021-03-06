package deliverable2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class TestVisitors {
	
	private Visitors visitors = new Visitors();
	
	/**
	 * Using mocks
	 * Mock the visitors generator
	 * Set the array to be {0, 2, 1, 3, 0}
	 * fiveVisiting() should return the exact same array
	 */
	@Test
	public void testFiveVisiting() {
		
		Generator mockGenerator = Mockito.mock(Generator.class);
		int[] indexArr = {0, 2, 1, 3, 0};
		Mockito.when(mockGenerator.randomGenerateVisitor()).thenReturn(indexArr);
		
		String[] arr = {"Student", "Business Person", "Professor", "Blogger", "Student"};
		assertArrayEquals(arr, visitors.fiveVisiting(mockGenerator));
		
	}
	

	/**
	 * Using stubs
	 * Set the random number to be 1
	 * Five visitors should be the same 
	 */
	@Test
	public void testNextVisitor() {
		
		Generator mockGenerator = Mockito.mock(Generator.class);
		//stub the randomGenerator() method
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
	
	
	
	/**A Blogger should dislike all locations.
	 * Given the visitor to be Blogger
	 * Given the location to be Squirrel Hill
	 * The likeLocation function should return false
	*/
	@Test
	public void testLikeLocation0() {
		
		String visitor = "Blogger";
		String location = "Squirrel Hill";
		
		assertFalse(visitors.likeLocation(visitor, location));
	}
	
	/**A Student should like Squirrel Hill.
	 * Given the visitor to be Student
	 * Given the location to be Squirrel Hill
	 * The likeLocation function should return false
	*/
	@Test
	public void testLikeLocation1() {
		
		String visitor = "Student";
		String location = "Squirrel Hill";
		
		assertTrue(visitors.likeLocation(visitor, location));
	}
	
	

}