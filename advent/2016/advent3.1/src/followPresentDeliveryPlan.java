import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class followPresentDeliveryPlan {
	
	private Map<String, Integer> houses = new HashMap<>();	
	private String thePlan = "";
	
	
	followPresentDeliveryPlan() {
		loadPlan();
		followInstructions();
		countUpVisits();
	}
	
	
	
	void addHouse(Integer partOne, Integer partTwo){
		
		// convert the address Integer coordinates to a string for the hashmap
		String thisHouse = partOne.toString()  + "," + partTwo.toString();
		
		if ( houses.containsKey(thisHouse)) {
			houses.put(thisHouse, houses.get(thisHouse) + 1 );
		} else {
			houses.put(thisHouse, 1);
		}
		
		//System.out.print( "--->" + thisHouse + " :: "+ houses.get(thisHouse) + "\n");
		
	}
	
	
	void followInstructions() {
		Integer addressPartOne = 0;
		Integer addressPartTwo = 0;
		
		// add the first house, this one counts...
		addHouse (addressPartOne,addressPartTwo );
		 
		Integer planStep = 0;
		
		while ( planStep < thePlan.length() ) {
			//System.out.print("-: " + thePlan.substring(planStep, planStep+1 ) + "\n");
			
			switch (thePlan.substring(planStep, planStep+1 ).charAt(0) ) {
			 case  '^':
				 // santa goes north
				 addressPartOne++;
				 break;
			 case  'v':
				 // santa goes south
				 addressPartOne--;
				 break;
			 case  '<':
				 // santa goes east
				 addressPartTwo++;
				 break;
			 case  '>':
				 // santa goes west
				 addressPartTwo--;
				 break;
			}
			System.out.print(addressPartOne + "," + addressPartTwo  + "\n");
			addHouse (addressPartOne,addressPartTwo );			
			planStep++ ;			
		}
	}
	
	
	void countUpVisits() {
		Integer visitedMultiTimesCount = 0;
		
		Iterator<?> it = houses.entrySet().iterator();
		
		while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        //System.out.println(pair.getKey() + " = " + pair.getValue());
	        if ( !pair.getValue().equals(1)  ) {
	        	visitedMultiTimesCount++;
	        }
		}
		
				
		System.out.print("count of houses visited more than once--->" +  visitedMultiTimesCount + "\n");
		
		// How many houses receive at least one present? 
		System.out.print("How many houses receive at least one present -->" + houses.size()  + "\n");
		
	}
	
	void loadPlan() {
		
	
		String file = "C:\\cygwin64\\home\\u25387\\challenges\\advent\\advent3.1\\src\\deliveryplan.txt";
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			// there is only one line in the file ( should really have error handling, but... )
		    thePlan = br.readLine();
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("count of steps in plan is  plan is : " +  thePlan.length() + "\n");
	}
	
}
