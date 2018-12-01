package lg;

import java.util.ArrayList;
import java.util.List;


/*
You just finish implementing your winning light pattern when you realize you mistranslated Santa's message from Ancient Nordic Elvish.

The light grid you bought actually has individual brightness controls; each light can have a brightness of zero or more. The lights all start at zero.

The phrase turn on actually means that you should increase the brightness of those lights by 1.

The phrase turn off actually means that you should decrease the brightness of those lights by 1, to a minimum of zero.

The phrase toggle actually means that you should increase the brightness of those lights by 2.

What is the total brightness of all lights combined after following Santa's instructions?

*/
	
	
public class lightTable {
	// got the list of integer lists from here
	// http://stackoverflow.com/questions/9068940/how-does-one-access-an-arraylist-of-arraylists-generics
	private List<List<Integer>> lightTable;

	public void createTable(int tableLength, int tableWidth) {

		this.lightTable = new ArrayList<>();

		for (int i = 0; i < tableWidth; i++) {
			List<Integer> columns = new ArrayList<>();
			for (int j = 0; j < tableLength; j++) {
				// columns.add(new String("row" + i + ":col" + j ));
				columns.add(new Integer(0));
			}
			this.lightTable.add(columns);
		}
	}
	
	
	//turn on, off and toggle method, state is the desired state, on, off or toggle
	public void adjustLights(int toprow, int leftcolumn, int  bottomrow, int rightcolumn , String state){
		int row, col;
		//this is how to turn on a single light ( 1,1)
		List<Integer> column = this.lightTable.get(1);
		//column.set(1, 1);
		
		// now change a range from top/left to bottom/right	( the puzzle starts at 0,0 )	
		for (  row = toprow; row <= bottomrow; row++) {
			column = this.lightTable.get(row);
			for ( col = leftcolumn ; col <= rightcolumn; col++ ) {

				switch ( state ) {
					case  "turn on ":
						column.set(col, 1);
						break;
					case "turn off ":
						column.set(col, 0);
						break;
					case "toggle ":
						if ( column.get(col)  == 1 ) {
							column.set(col, 0);
						} else {
							column.set(col, 1);
						}
						break;	
				}
			}
		}
	}
	
	

	
	
	
	public void countTurnedOnLights() {
		int row, col, lightCounter = 0;
		List<Integer> column;
	
		for (  row = 0; row <= 999; row++) {
			column = this.lightTable.get(row);
			for ( col = 0 ; col <= 999; col++ ) {
				if ( column.get(col)  == 1 ) {
					lightCounter++;
				}
			}
		}
		
		System.out.println("the number of turned on lights is : "  + lightCounter );
	}
	
	

	// the following functions display the table contents
	public void displayRow(int row) {
		System.out.println(this.lightTable.get(row));
	}

	public void displayColumn(int column) {
		for (int i = 0; i < this.lightTable.size(); i++) {
			System.out.println("[" + this.lightTable.get(i).get(column) + "]");
		}
	}

	public void displayEntireTable() {

		for (int i = 0; i < this.lightTable.size(); i++) {
			System.out.println(this.lightTable.get(i));
		}
	}

}
