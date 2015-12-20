package lg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LightGrid {

	public static void main(String[] args) {
		
		
		
		// Just testing a few functions.
    	lightTable lights = new lightTable();
    	lights.createTable(1000, 1000);
        
        //lights.displayRow(7);
        //lights.displayColumn(4);
        //lights.displayEntireTable();
//
//    	lights.adjustLights(2,2,8,8,"on");
//    	lights.adjustLights(3,3,6,5,"off");
//    	lights.adjustLights(5,5,8,8,"toggle");

        loadPlan(lights);
        lights.displayEntireTable();

	}
	
	static void loadPlan(lightTable lights) {
		
		
		String file = "/Users/sdobner/tmp/challenges/advent/advent6.1/src/lg/instructions.txt";
		String nextStep;//next step in the instructions
		Integer topRow, topColumn, bottomRow, bottomColumn;
		String instruction;
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			// there is only one line in the file ( should really have error handling, but... )
		    
			while ((nextStep = br.readLine()) != null) {
				System.out.println(nextStep);
				//get the actual instruction step
				Pattern p_instruction = Pattern.compile("[a-z ]*"); // find all the chars and spaces up to the first non-lower char (number)
				Matcher m = p_instruction.matcher(nextStep);
				m.find();
				//System.out.println("match->" + m.group());
				instruction = m.group();

				
				//get the coordinates
				Pattern p_numbers = Pattern.compile("\\d+");
				m = p_numbers.matcher(nextStep);

				m.find();
				topRow = Integer.parseInt(m.group());
				m.find();
				topColumn = Integer.parseInt(m.group());
				m.find();
				bottomRow = Integer.parseInt(m.group());
				m.find();
				bottomColumn = Integer.parseInt(m.group());

				//System.out.print(topRow + ":" +  topColumn+ ":" + bottomRow+ ":" + bottomColumn+ ":" + instruction);
				lights.adjustLights(topRow, topColumn, bottomRow, bottomColumn, instruction);

				
			}
				 
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.print("count of steps in plan is  plan is : " +  thePlan.length() + "\n");
	}

}
