import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class calculatePaper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l
		//plus extra - the area of the smallest side
		
		//2x3x4 requires 2*6 + 2*12 + 2*8 = 52
		// plus extra  6 square feet of slack,
		 
		//String box = "2x3x4";
		String box = "1x1x10";
		int paperRequired = 0;
		
		String file = "C:\\cygwin64\\home\\u25387\\challenges\\advent\\advent2.1\\src\\present_list.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    while ((box = br.readLine()) != null) {
		    	// 	process this box.
		    	paperRequired = calculateArea(paperRequired, box);

		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		

		System.out.print("Total Paper Required is " + paperRequired);
		
	}
	
	
	

	private static int calculateArea(int paperRequired, String box) {
		// work out the paper required for this box.
		
		// split the dimension string into usable elements 
		String[] dimensions = box.split("x");
		
		// make a list to hold the dimensions
		ArrayList<Integer> sides = new ArrayList<Integer>(3);

		
		// extract the dimensions from the split string
		sides.add( Integer.parseInt( dimensions[0]) );
		sides.add( Integer.parseInt( dimensions[1]) );
		sides.add( Integer.parseInt( dimensions[2]) );
		
		System.out.print(sides.get(0)  + ":" + sides.get(1) + ":" + sides.get(2) + "\n");

		// work out the area of the box
		int boxArea =  (2 * sides.get(0) * sides.get(1))  
						+  (2 * sides.get(1) * sides.get(2))  
						+  (2 * sides.get(2) * sides.get(0));

		System.out.print("area = " + boxArea + "\n");

		// sort the array to get the smallest 2 edges, and thence the area of the smallest side
		Collections.sort(sides);
		
		int additionalPaper = sides.get(0) * sides.get(1) ;
		
		paperRequired = paperRequired + boxArea + additionalPaper;
		
		return paperRequired;
	}

}
