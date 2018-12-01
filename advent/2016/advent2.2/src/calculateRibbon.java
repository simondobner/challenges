import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class calculateRibbon {

	public static void main(String[] args) {
		
		/*
		 * 
		 * http://adventofcode.com/day/2
		 * 
		 * --- Part Two ---

			The elves are also running low on ribbon. Ribbon is all the same width, so they only have to 
			worry about the length they need to order, which they would again like to be exact.
			The ribbon required to wrap a present is the shortest distance around its sides, or the 
			smallest perimeter of any one face. Each present also requires a bow made out of ribbon
			 as well; the feet of ribbon required for the perfect bow is equal to the cubic feet of 
			 volume of the present. Don't ask how they tie the bow, though; they'll never tell.
		 * 
		 * 
		 */
		
		String box;
		ribbon elvesRibbon = new ribbon();
		
		
		String file = "C:\\cygwin64\\home\\u25387\\challenges\\advent\\advent2.1\\src\\present_list.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    while ((box = br.readLine()) != null) {
		    	// 	process this box.
		    	elvesRibbon.calculateRibbon(box);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// and now we can see the total amount needed.
		elvesRibbon.printTotal();
		
		
		

	}

}
