package deliverable2;

import java.util.Random;

public class CitySim9002 {
	
	private static int VISITOR_SIZE = 4;
	private static int LOCATION_SIZE = 5;

	public static void main(String[] args) {
		
		int seed = 0;
		
		if(isInteger(args))
			//initialize seed
			seed = Integer.parseInt(args[0]); 	
		else {
			System.out.println("Please enter one integer argument (seed)");
			System.exit(0);
		}
		
		System.out.println("Welcome to CitySim!  Your seed is " + seed + ".");	
		

		Locations locations = new Locations();
		String nextLocation = "";

		Visitors visitors = new Visitors();	
		String nextVisitor = "";
		
		Generator visGenerator = new Generator(seed, VISITOR_SIZE);
		
		String[] visitorList = visitors.fiveVisiting(visGenerator);
		
		Random generator = new Random(seed);
		
		for(int i=1; i<=5; i++) {
			
			//select a visitor
			nextVisitor = visitorList[i-1];		
			System.out.println("Visitor " + i + " is a " + nextVisitor);
			
			//Randomly visit
			nextLocation = locations.getLocation(generator.nextInt(LOCATION_SIZE) + 1);
			
			//The visitor shouldn't leave in the first time.
			while(nextLocation.compareTo("left") == 0) {
				nextLocation = locations.getLocation(generator.nextInt(LOCATION_SIZE) + 1);
			}
			
			while(nextLocation.compareTo("left") != 0) {
				System.out.println("Visitor " + i + " is going to " + nextLocation + "!");
				
				if(visitors.likeLocation(nextVisitor, nextLocation))
					System.out.println("Visitor " + i + " did like " + nextLocation + ".");
				else
					System.out.println("Visitor " + i + " did not like " + nextLocation + ".");
				
				nextLocation = locations.getLocation(generator.nextInt(LOCATION_SIZE) + 1);
			}
			
			System.out.println("Visitor " + i + " has left the city.");
			
			System.out.println("***");
		}
	}
	
	
	//Determine if the input is valid
	public static boolean isInteger(String[] arg) {
		
		//Only one integer can be accepted
		if(arg.length != 1) return false;
		
		try{
			Integer.parseInt(arg[0]);
		} catch(NumberFormatException e) {
			return false;
		} catch(NullPointerException e) {
			return false;
		}
	
		return true;
	}

}
