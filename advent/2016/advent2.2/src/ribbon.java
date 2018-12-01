import java.util.ArrayList;
import java.util.Collections;

public class ribbon {

	// each present needs a certain amount of ribbon
	
	/*
	 * The ribbon required to wrap a present is the shortest distance around its sides, 
	 * or the smallest perimeter of any one face. 
	 * 
	 * Each present also requires a bow made out of ribbon as well; 
	 * 	the feet of ribbon required for the perfect bow is equal to the cubic feet of volume of the present
	 * 
	 * 
	 * For example:

			A present with dimensions 2x3x4 requires 2+2+3+3 = 10 feet of ribbon to wrap 
			the present plus 2*3*4 = 24 feet of ribbon for the bow, for a total of 34 feet.
			
			A present with dimensions 1x1x10 requires 1+1+1+1 = 4 feet of ribbon to wrap 
			the present plus 1*1*10 = 10 feet of ribbon for the bow, for a total of 14 feet

	 */
	
	private int totalRibbon = 0 ;

	void calculateRibbon(String box) {
		// take a box, and add the ribbon it needs to the class running total
		
		// split the dimension string into usable elements 
		String[] dimensions = box.split("x");
		
		// make a list to hold the dimensions
		ArrayList<Integer> sides = new ArrayList<Integer>(3);

		// extract the dimensions from the split string
		sides.add( Integer.parseInt( dimensions[0]) );
		sides.add( Integer.parseInt( dimensions[1]) );
		sides.add( Integer.parseInt( dimensions[2]) );
		
		// sort the box to make getting  the 2 smallest sides easy
		Collections.sort(sides);
		
		// so now, elements 0 and 1 are the two smallest, so we  add em up
		totalRibbon = totalRibbon + sides.get(0) + sides.get(0) + sides.get(1) + sides.get(1) ;
		
		// and now calculate the ribbon for the bow ( side 1 * side 2 * side 3 )
		totalRibbon = totalRibbon + sides.get(0) * sides.get(1) * sides.get(2);
		
	}
	
	void printTotal() {
		System.out.print("total Ribbon needed is " + totalRibbon);
	}
	
	
}
