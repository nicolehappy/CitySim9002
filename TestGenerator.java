package deliverable2;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestGenerator {
	
	private Generator generator = new Generator(9, 5);
	
	/**
	 * The random number should smaller than bound
	 * Input seed 9 and bound 6
	 * The generated number should no less than 0 and larger than 6
	 */
	@Test
	public void testRandomGenerator() {
		assertTrue(generator.randomGenerator()<5 && generator.randomGenerator()>=0);
	}
	
	/**
	 * Five index for visitors should be different
	 * Since they are generated randomly
	 * Rerun the method to produce an int array
	 * Elements in the array should be different
	 */
	@Test
	public void testRandomGenerateVisitor0() {
		int[] tested = generator.randomGenerateVisitor();
		boolean allEqual = true;
		
		for(int i=0; i<5; i++) {
			if(tested[i] != tested[0]) allEqual = false;
		}
		
		assertFalse(allEqual);
	}

}