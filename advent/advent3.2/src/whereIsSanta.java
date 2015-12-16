
public class whereIsSanta {
	Integer santasCurrentAddressPartOne = 0;
	Integer santasCurrentAddressPartTwo = 0;
	
	Integer roboSantasCurrentAddressPartOne = 0;
	Integer roboSantasCurrentAddressPartTwo = 0;
	
	
	// Move Regular Santa
	public void moveSantaNorth() {
		santasCurrentAddressPartOne++;
	}
	
	public void moveSantaSouth() {
		santasCurrentAddressPartOne--;
	}
	
	public void moveSantaEast() {
		santasCurrentAddressPartTwo++;
	}
	
	public void moveSantaWest() {
		santasCurrentAddressPartTwo--;
	}
	
	//move ROBO santa
	public void moveRoboSantaNorth() {
		roboSantasCurrentAddressPartOne++;
	}
	
	public void moveRoboSantaSouth() {
		roboSantasCurrentAddressPartOne--;
	}
	
	public void moveRoboSantaEast() {
		roboSantasCurrentAddressPartTwo++;
	}
	
	public void moveRoboSantaWest() {
		roboSantasCurrentAddressPartTwo--;
	}
	
	
	
	
	public Integer getSantasCurrentAddressPartOne() {
		return santasCurrentAddressPartOne;
	}
	

	public Integer getSantasCurrentAddressPartTwo() {
		return santasCurrentAddressPartTwo;
	}
	
	
	public Integer getRoboSantasCurrentAddressPartOne() {
		return roboSantasCurrentAddressPartOne;
	}
	
	
	public Integer getRoboSantasCurrentAddressPartTwo() {
		return roboSantasCurrentAddressPartTwo;
	}
	
	
}
