
public class deliveryPlan {
	
//	For example:
//
//		(()) and ()() both result in floor 0.
//		((( and (()(()( both result in floor 3.
//		))((((( also results in floor 3.
//		()) and ))( both result in floor -1 (the first basement level).
//		))) and )())()) both result in floor -3.
	
	
	private String planSteps = "()(((()))(()()()((((()(((())(()(()((((((()(()(((())))((()(((()))((())(()((()()()()(((())(((((((())))()()(()(()(())(((((()()()((())(((((()()))))()(())(((())(())((((((())())))(()())))()))))()())()())((()()((()()()()(()((((((((()()())((()()(((((()(((())((())(()))()((((()((((((((())()((()())(())((()))())((((()())(((((((((((()()(((((()(()))())(((()(()))())((()(()())())())(()(((())(())())()()(()(()((()))((()))))((((()(((()))))((((()(()(()())())()(((()((((())((((()(((()()(())()()()())((()((((((()((()()))()((()))()(()()((())))(((()(((()))((()((()(()))(((()()(()(()()()))))()()(((()(((())())))))((()(((())()(()(())((()())))((((())))(()(()(()())()((()())))(((()((()(())()()((()((())(()()((())(())()))()))((()(())()))())(((((((()(()()(()(())())))))))(()((((((())((((())((())())(()()))))()(())(()())()())((())(()))))(()))(()((()))()(()((((((()()()()((((((((()(()(())((()()(()()))(())()())()((())))()))()())(((()))(())()(())()))()((()((()(()()())(())()()()((())())))((()()(()()((()(())()()())(((()(()()))))(())))(()(()())()))()()))))))()))))((((((())))())))(()(())())(()())))))(()))()))))))()((()))))()))))(()(()((()())())(()()))))(((())()))())())())(((()(()()))(())()(())(())((((((()()))))((()(()))))))(()))())(((()()(()))()())()()()())))))))))))))(())(()))(()))((()(())(()())(())())(()())(())()()(()())))()()()))(())())()))())())(())((())))))))(())))(())))))()))))((())(()(((()))))(()))()((()(())))(()())(((((()))()())()()))))()))))()))())(()(()()()))()))))))((()))))))))))()((()))((()(())((())()()(()()))()(()))))()()(()))()))(((())))(())()((())(())(()())()())())))))))())))()((())))()))(()))()()))(((((((()))())(()()))(()()(()))()(()((()())()))))))(((()()()())))(())()))()())(()()))()()))))))))(())))()))()()))))))()))()())))()(())(())))))()(())()()(()()))))())((()))))()))))(()(((((()))))))))())))())()(())()()))))(())))())()()())()()())()(()))))()))()))))))))())))((()))()))()))())))()())()()())))())))(()((())()((()))())))))())()(())((())))))))))))())()())(())())())(()))(()))()))())(()(())())()())()()(()))))(()(())))))))(())))())(())))))))())()()(())())())))(())))))()))()(()())()(()))())())))))()()(()))()))))())))))))))()))))()))))))())()())()()))))()())))())))))))))))()()))))()()(((()))()()(())()))))((()))))(()))(())())))(())()))))))(()))()))))(())())))))()))(()())))))))))))))())))))))))()((()())(()())))))))((()))))(())(())))()(()())())))())())(()()()())))()))))))())))))())()()())))))))))))()()(()))))()())()))((()())(()))))()(()))))))))))()())())(((())(()))))())()))()))()))))))()))))))(()))))()))))()(())))(())))(()))())()()(()()))()))(()()))))))))()))(()))())(()()(()(()())()()))()))))))))(())))))((()()(()))())())))))()))())(()())()()))())))()(()()()()))((())())))())()(()()))()))))))))(()))(())))()))))(()(()())(()))))()())())()))()()))())))))))))))())()))))))()))))))))())))))()))))())(()())))(())()))())())))))()()(()()())(()())))()()))(((()))(()()()))))()))))()))))((())))()((((((()()))))))())))))))))))(((()))))))))))))(())())))))())(()))))))(()))((()))())))()(()((()))()))()))))))))))())()))()(()()))))())))())(())()(()))()))())(()))()))))(()()))()()(())))))()))(())(()(()()))(()()())))))(((()))))))()))))))))))))(())(()))))()())())()()((()()))())))))(()))))())))))))()()()))))))))())))()(((()()))(())))))(((())())))))((()))()(()))(()))))(()())))(()))())))))()))))(())(())))()((()))(())())))()()))()))))))))()))(()()()(()()()(()))())(())()())(((()))(())))))))))(((()())))()()))))))))()(())(()))()((((())(())(()())))()))(((())()()()))((()))(()))())())))())))(()))())()())())(()(())())()()()(())))())(())))(())))(())()))()))(()((()))))))))())(()))))))())(()()))()()))()(()(()())))()()(()((()((((((()))(())))()()()))())()))((()()(()))())((()(()(()))(()()))))()())))()))()())))))))()()((()())(())))()))(()))(())(()))())(()(())))()()))))))(((()(((()()))()(()(())())((()()))()))()))()))()(()()()(()))((()())()(())))()()))(((())()()())(())()((()()()()(()(())(()()))()(((((()())))((())))))(()()()))))(((()(())))()))((()((()(())()(()((())))((()())()(()))(((()())()()(()))(())(((()((()())()((())()())(((()()))((()((())(()))(()())(()()()))((()))(())(()((()()())((()))(())))(())(())(())))(()())))(((((()(()(((((()())((((()(()())(())(()()(((())((()(((()()(((()()((((((())))())(()((((((()(()))()))()()((()((()))))()(()()(()((()()))))))(((((()(((((())()()()(())())))))))()))((()()(())))(())(()()()())))))(()((((())))))))()()(((()(()(()(()(()())()()()(((((((((()()())()(()))((()()()()()(((((((()())()((())()))((((((()(()(()(()())(((()(((((((()(((())(((((((((())(())())()))((()(()))(((()()())(())(()(()()(((()(())()))())))(())((((((())(()()())()()(((()(((())(()(((())(((((((()(((((((((()))(())(()(()(()))))((()))()(())())())((()(()((()()))((()()((()(())(())(()((())(((())(((()()()((((((()()(())((((())()))))(())((()(()((())))(((((()(()()())())((())())))((())((()((()()((((((())(((()()(()())())(()(()))(()(()))())())()(((((((()(((()(())()()((())((()(()()((()(()()(((((((((((())((())((((((())((()((((()(()((((()(((((((())()((()))))())()((()((((()(()(((()((()())))(())())(((()(((())((((((()(((((((((()()(())))(()(((((()((((()())))((()((()((()(()()(((())((((((((((((()(((())(()(((((()))(()()(()()()()()()((())(((((((())(((((())))))())()(()()(()(()(((()()(((((())(()((()((()(((()()((()((((())()))()((((())(())))()())(((())(())(()()((()(((()()((((((((((()()(()())())(((((((((())((((()))()()((((())(()((((()(((())())(((((((((((()((((())))(())(()(((()(((()((())(((((()((()()(()(()()((((((()((((()((()(()((()(()((((((()))))()()(((((()((()(()(())()))(())(((((((()((((()())(()((()((()(()))())))(())((()))))(((((((()()()())(()))(()()((()())()((()((()()()(()(()()))(()())(())(((((()(((((((((((()((()(((()(((((((()()((((((()(((((()(()((()(((((())((((((()))((((())((()()((())(((())()(((((()()(((((()((()(()(((((((()(((((()((()((()((())(())((())(()))()()))(()()(()(()()(((((((()(((()(((())()(((((()((((((()())((((())()((()((()(()()())(()))((((()()((((((()((()(()(()((((()((()((())((((((()(()(())((((((()((((((((((()((())()))()(()(()(((((()()()))((())))()(()((((((((((((((()(((()((((()((())((()((()(((()()(()(((()((())(()()())))()(()(()(((((()()(()(()((((()(((((())()(()(()))(((((()()(((()()(())((((((((((((((())((())(((((((((((())()()()(())()(()(()(((((((((())(((()))(()()())(()((((()(())(((((()())(())((((((((())()((((()((((((())(()((()(())(((()((((()))(((((((((()()))((((()(())()()()(())(()((())((()()))()(((())(((((())((((((()()))(((((((((()((((((())))(((((((()((()(()(())))())(()(()))()(((((()())(()))()(()(())(((()))))())()())))(((((()))())()((()(()))))((()()()((((((()))()()((((((((())((()(()(((()(()((())((()())(()((((())(()(((()()()(()(()()))())())((((((((((())())((()))()((())(())(())))())()(()()(())))())(()))(((()(()()(((()(((())))()(((()(())()((((((())()))()))()((((((()(()(((((()())))()))))())()()(((()(((((())((()()(()((()((()(()(()(())))(()()()()((()(())(((()((()))((((()))())(())))())(()))()()()())()))(((()()())()((())))(())(()()()()(()())((()(()()((((())))((()((()(())((()(()((())()(()()(((()())()()())((()))((())(((()()(())))()()))(((()((())()(((((()())(())((())()())())((((((()(()(((((()))(()(";
	private int currentFloor = 0;
	
	
	deliveryPlan () {
	

			
		System.out.print("Plan is : " + planSteps + "\n" );
		
		while (planSteps.length() > 0 ) {
			findNextFloor();	
		}
		
		System.out.print("Final Floor Found. It is "  + currentFloor +  "\n" );

	}
	
	 void findNextFloor() {
		//An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), 
		//means he should go down one floor.

		switch ( planSteps.charAt(0) ) {
			case  '(':
				//santa goes up
				currentFloor++;
				System.out.print("santa goes up to " + currentFloor + "\n");
				break;
			
			case  ')':
				//santa goes down
				currentFloor--;
				System.out.print("santa goes down to " + currentFloor +  "\n");
				break;

			default:
				//santas got a bad plan - he is lost
				System.out.print("\n"  + "This shouldn't happen - now Santas lost, plan had something other than ( or ) in it");
				System.exit(99);
		}

		//now pop off this step to expose the next one
		planSteps = planSteps.substring(1);
		
		
	}
	
	
	
}
