package lg;

public class LightGrid {

	public static void main(String[] args) {
		
		
		// Just testing a few functions.
    	lightTable lights = new lightTable();
    	lights.createTable(10, 10);
        
        //lights.displayRow(7);
        //lights.displayColumn(4);
        //lights.displayEntireTable();

    	
    	lights.adjustLights(2,2,8,8,"on");
    	lights.adjustLights(3,3,6,5,"off");
    	lights.adjustLights(5,5,8,8,"toggle");

        lights.displayEntireTable();

    	
    	
	}

}
