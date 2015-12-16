import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class followPresentDeliveryPlan {
	
	private Map<String, Integer> houses = new HashMap<>(); //hashmap to store the address of houses vistied	
	private String thePlan = ""; // string to hold the actual delivery plan	
	// create a whereIsSanta object so we can track the current location of both Santas
	private whereIsSanta santasLocation = new whereIsSanta();
	
	
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
		// santa goes first
		//Integer turnChooser = 0; // so we can work out whose turn it is to go next
		Integer planStep = 0; // keep track of the current step in the plan

		// add the first house, this one counts too
		addHouse (0,0 );
		
		while ( planStep < thePlan.length() ) {
			//System.out.print("-: " + thePlan.substring(planStep, planStep+1 ) + "\n");
			if ( planStep%2 == 0 ){
				//System.out.print("sending Santa: " + thePlan.substring(planStep, planStep+1 ) + "\n");
				sendSantaToNextHouse(planStep);
			} else {
				//System.out.print("sending RoboSanta: " + thePlan.substring(planStep, planStep+1 ) + "\n");
				sendRoboSantaToNextHouse(planStep);
			}
			planStep++ ;
			
		}
	}



	private void sendSantaToNextHouse(Integer planStep) {
		// send Santa to the next house and log the visit 
		
		switch (thePlan.substring(planStep, planStep+1 ).charAt(0) ) {
		 case  '^':
			 santasLocation.moveSantaNorth();
			 break;
		 case  'v':
			 santasLocation.moveSantaSouth();
			 break;
		 case  '<':
			 santasLocation.moveSantaEast();
			 break;
		 case  '>':
			 santasLocation.moveSantaWest();
			 break;
		}
		//System.out.print(addressPartOne + "," + addressPartTwo  + "\n");
		addHouse (santasLocation.getSantasCurrentAddressPartOne(),
					santasLocation.getSantasCurrentAddressPartTwo());			

	}
	

	private void sendRoboSantaToNextHouse(Integer planStep) {
		// send Robo Santa to the next house and log the visit 
		
		switch (thePlan.substring(planStep, planStep+1 ).charAt(0) ) {
		 case  '^':
			 santasLocation.moveRoboSantaNorth();
			 break;
		 case  'v':
			 santasLocation.moveRoboSantaSouth();
			 break;
		 case  '<':
			 santasLocation.moveRoboSantaEast();
			 break;
		 case  '>':
			 santasLocation.moveRoboSantaWest();
			 break;
		}
		//System.out.print( "adding robosanta house"  + "\n");
		addHouse (santasLocation.getRoboSantasCurrentAddressPartOne(),
					santasLocation.getRoboSantasCurrentAddressPartTwo());			

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
		
		//thePlan = "^v^v^v^v^v";
		System.out.print("count of steps in plan is  plan is : " +  thePlan.length() + "\n");
		
		
	}
	
}
