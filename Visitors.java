package deliverable2;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Visitors {
	
	private static int VISITING_TIME = 5;
	
	private List<String> studentLikes;
	private List<String> professorLikes;
	private List<String> businessLikes;
	private List<String> bloggerLikes;
	
	private HashMap<String, List<String>> visitorsInfo;
	
	private List<String> visitorTypes;
	
	//Initializae
	public Visitors() {
		
		visitorsInfo = new HashMap<String, List<String>>();
		//Student information
		studentLikes = new ArrayList<String>();
		studentLikes.add("Squirrel Hill");
		studentLikes.add("Downtown");
		studentLikes.add("The Point");
		visitorsInfo.put("Student", studentLikes);
		
		//Professor information
		professorLikes = new ArrayList<String>();
		professorLikes.add("The Cathedral of Learning");
		professorLikes.add("Squirrel Hill");
		professorLikes.add("Downtown");
		professorLikes.add("The Point");
		visitorsInfo.put("Professor", professorLikes);
		
		//Business Person information
		businessLikes = new ArrayList<String>();
		businessLikes.add("Squirrel Hill");
		businessLikes.add("Downtown");
		visitorsInfo.put("Business Person", businessLikes);
		
		//Blogger information
		bloggerLikes = new ArrayList<String>();
		visitorsInfo.put("Blogger", bloggerLikes);
		
		visitorTypes = new ArrayList<String>();
		visitorTypes.add("Student");
		visitorTypes.add("Professor");
		visitorTypes.add("Business Person");
		visitorTypes.add("Blogger");
	}
	
	
	/**
	 * Randomly generating five visitors
	 * @param generator
	 * @return visitors
	 */
	public String[] fiveVisiting(Generator generator) {
		
		String[] visitors = new String[VISITING_TIME];
		int[] visitorIndex = generator.randomGenerateVisitor();
		
		for(int i =0; i<VISITING_TIME; i++) {
			visitors[i] = visitorTypes.get(visitorIndex[i]);
		}
		
		return visitors;
	}
	
	/**
	 * Randomly produce next visitor
	 * @param generator
	 * @return next selected visitor
	 */
	public String nextVisitor(Generator generator) {

		return visitorTypes.get(generator.randomGenerator());
	}
	
	/**
	 * Detemine whether the visitor likes this location
	 * @param visitor
	 * @param location
	 * @return true - like ; false - not like
	 */
	public boolean likeLocation(String visitor, String location) {

		return visitorsInfo.get(visitor).contains(location);
	}
	
}
