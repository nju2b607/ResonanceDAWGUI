package resonance.piano;

import java.util.ArrayList;

/**
 * @author okamiji
 */

public class ActionRecords {
	
	private static final int CAPACITY = 30;
	
	private static ArrayList<int[]> records = null;
	private int index;
	
	private ActionRecords(){}
	
	public void addRecord(int xStart, int yStart, int xEnd, int yEnd){
		if((index + 1) == CAPACITY){
			records.remove(0);
			index -- ;
		}
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
