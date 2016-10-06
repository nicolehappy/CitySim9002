package deliverable2;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestGenerator {
	
	private Generator generator = new Generator(3, 5);
	
	/**
	 * Set seed to 3 and bound to 6
	 * The generated number should in the bound
	 */
	@Test
	public void testRandomGenerator() {
		assertTrue(generator.randomGenerator()<5 && generator.randomGenerator()>=0);
	}
	
	/**
	 * Generated number should be different
	 * Rerun an array
	 */
	@Test
	public void testRandomNumber() {
		int[] tested = generator.randomGenerateVisitor();
		boolean allEqual = true;
		
		for(int i=0; i<5; i++) {
			if(tested[i] != tested[0]) allEqual = false;
		}
		
		assertFalse(allEqual);
	}

}