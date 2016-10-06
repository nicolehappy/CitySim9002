package deliverable2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCitySim9002 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//----------------------------------
	// VALID INTEGER TEST - 0
	//----------------------------------
	//Return true if it is a valid integer
	@Test
	public void testIsInteger0() {
		String[] testArray = {"8"};
		assertTrue(CitySim9002.isInteger(testArray));
	}

	
	// VALID INTEGER TEST - 1
	//Return false if the input has 0 integer
	@Test
	public void testIsInteger1() {
		String[] testArray = {};
		assertFalse(CitySim9002.isInteger(testArray));
	}
	
	// VALID INTEGER TEST - 2
	// Return false if the input has more than one integer 
	@Test
	public void testIsInteger2() {
		
		String[] testArray = {"7", "2"};
		assertFalse(CitySim9002.isInteger(testArray));
	}
	
	// VALID INTEGER TEST - 3
	// Return false if the input is not integer
	@Test
	public void testIsInteger3() {
			
		String[] testArray = {"NotInteger"};
		assertFalse(CitySim9002.isInteger(testArray));
	}
	
	
}