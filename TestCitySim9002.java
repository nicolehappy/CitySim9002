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
	
	/**
	 * VALID INTEGER TEST
	 * 0 -- test valid input 
	*/
	@Test
	public void testIsInteger0() {
		String[] testArray = {"5"};
		assertTrue(CitySim9002.isInteger(testArray));
	}
	
	/**
	 * VALID INTEGER TEST
	 * 1 -- test no input 
	*/
	@Test
	public void testIsInteger1() {
		String[] testArray = {};
		assertFalse(CitySim9002.isInteger(testArray));
	}

	/**
	 * VALID INTEGER TEST
	 * 2 -- test string input 
	*/
	@Test
	public void testIsInteger2() {
			
		String[] testArray = {"hihihi"};
		assertFalse(CitySim9002.isInteger(testArray));
	}
	
	
}