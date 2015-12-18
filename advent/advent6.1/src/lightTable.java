import java.util.ArrayList;
import java.util.List;

public class lightTable {

	// got the list of integer lists from here
	// http://stackoverflow.com/questions/9068940/how-does-one-access-an-arraylist-of-arraylists-generics
	private List<List<Integer>> newTable;

	public void createTable(int tableLength, int tableWidth) {

		this.newTable = new ArrayList<>();

		for (int i = 0; i < tableWidth; i++) {
			List<Integer> columns = new ArrayList<>();
			for (int j = 0; j < tableLength; j++) {
				// columns.add(new String("row" + i + ":col" + j ));
				columns.add(new Integer(0));
			}
			this.newTable.add(columns);
		}
	}
	
	
	//turn on, off and toggle methods
	public void turnOn(int row) {
		//turn on 0,0 through 2,2
		
		//first, how do we turn on a single lamp, ie, 1,1
		this.newTable.get
		
		//loop from 0 to 2
		
			// loop from 0 to 2
			
				//turn on lights in ranges
		
		
		
	}
	

	// the following functions display the table contents
	public void displayRow(int row) {
		System.out.println(this.newTable.get(row));
	}

	public void displayColumn(int column) {
		for (int i = 0; i < this.newTable.size(); i++) {
			System.out.println("[" + this.newTable.get(i).get(column) + "]");
		}
	}

	public void displayEntireTable() {

		for (int i = 0; i < this.newTable.size(); i++) {
			System.out.println(this.newTable.get(i));
		}
	}
}
