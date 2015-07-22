package resonance.piano;

import java.util.ArrayList;

/**
 * @author okamiji
 */

public class ActionRecords {
	
	private static ArrayList<int[]> records = null;
	private int index;
	
	private ActionRecords(){}
	
	public void addRecord(int xStart, int yStart, int xEnd, int yEnd){
		if(records == null){
			records = new ArrayList<int[]>();
			index = -1;
		}
		records.add(new int[]{xStart, yStart, xEnd, yEnd});
		index ++;
	}
	
	public int[] getRecord(){
		int[] record = records.remove(index);
		index --;
		if(index == -1){
			return null;
		}
		else{
			return record;
		}
	}
	
}
