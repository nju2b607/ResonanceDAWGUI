package resonance.piano;

import java.util.ArrayList;

/**
 * @author okamiji
 */

public class ActionRecords {
	
	private ArrayList<Grid> records;
	private int index;
	
	protected ActionRecords(){
		records = new ArrayList<Grid>();
		index = -1;
	}
	
	protected void addRecord(Grid grid){
		records.add(grid);
		index ++;
	}
	
	protected Grid removeRecord(){
		Grid grid = records.remove(index);
		index --;
		if(index == -1){
			return null;
		}
		else{
			return grid;
		}
	}
	
	protected ArrayList<Grid> getAllRecords(){
		return records;
	}
	
}
