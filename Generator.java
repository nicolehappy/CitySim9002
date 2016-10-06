package deliverable2;


import java.util.Random;

public class Generator {
	
	private int seed;
	private int bound;
	
	public Generator(int s, int b) {
		this.seed = s;
		this.bound = b;
	}
	
	//Randomly generate number
	public int randomGenerator() {
			
		int random = 0;
			
		Random generator = new Random(seed);
		random = generator.nextInt(bound);
			
		return random;
	}
	
	//Randomly generating visitors for five times
	public int[] randomGenerateVisitor() {
		int[] visitorList = new int[5];
		
		Random generator = new Random(seed);
		for(int i=1; i<=5; i++) {
			visitorList[i-1] = generator.nextInt(bound);
		}
		
		return visitorList;
	}
	
}
