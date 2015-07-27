package resonance.piano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author okamiji
 */

@SuppressWarnings("serial")
public class GridChooser extends JPanel{

	private int beatsPerMeasure;
	private ActionRecords records;
	
	private final int whiteKeyHeight = KeyParam.whiteKeyHeight;

	private final int SCALE_COUNT = KeyParam.SCALE_COUNT;
	private final int SIZE_OF_WHITE_KEY = KeyParam.SIZE_OF_WHITE_KEY;
	private final int SIZE_OF_BLACK_KEY = KeyParam.SIZE_OF_BLACK_KEY;
	private final int SIZE_OF_SCALE = KeyParam.SIZE_OF_SCALE;
	
	private int gridHeightThree;
	private int gridHeightFive;
	
	private int width;
	private int height;
	
	private int[] vlineLocation;
	private int[] hlineLocation;
	
	private int gridCount;
	private int gridInterval;
	
	private int[][] state;
	private final int IDLE = 0;
	private final int PRESSED = 1;
	private int sign;
	private int theX;
	private int theY;
	
	public GridChooser(){
		
		beatsPerMeasure = 4;
		records = new ActionRecords();
		
		gridHeightThree = whiteKeyHeight * 3 / 5;
		gridHeightFive = whiteKeyHeight * 4 / 7;
		
		width = 1500; 
		height = whiteKeyHeight * SCALE_COUNT * SIZE_OF_WHITE_KEY;
		
		gridCount = 40;
		gridInterval = 50;
		
		vlineLocation = new int[SCALE_COUNT * SIZE_OF_SCALE + 1];
		hlineLocation = new int[gridCount + 1];
		
		int[] whiteState = new int[SCALE_COUNT * SIZE_OF_WHITE_KEY];
		int[] blackState = new int[SCALE_COUNT * SIZE_OF_BLACK_KEY];
		state = new int[2][];
		state[0] = whiteState;
		state[1] = blackState;
		
		for(int i=0; i<state[0].length; i++){
			state[0][i] = 0;
		}
		for(int i=0; i<state[1].length; i++){
			state[1][i] = 0;
		}
		
		sign = IDLE;
		theX = 0;
		theY = 0;
		
		this.setSize(width, height);
		
		this.addMouseListener(adapter);
				
	}
	
	public Dimension getSize(){
		return new Dimension(width, height);
	}
	
	public void setGridCount(int newCount){
		this.gridCount = newCount;
	}
	public int getGridCount(){
		return gridCount;
	}	
	public void setGridInterval(int newInterval){
		this.gridInterval = newInterval;
	}
	public int getGridInterval(){
		return gridInterval;	
	}
	
	public void setBeatPerMeasure(int setBeat){
		this.beatsPerMeasure = setBeat;
	}
	public int getBeatPerMeasure(){
		return beatsPerMeasure;
	}
	
	public void paint(Graphics g){
		//vertical lines
		int vindex = 0;
		
		g.setColor(Color.gray);
		
		int lineHeight = 0;
		vlineLocation[vindex] = lineHeight; vindex ++;
		g.drawLine(0, lineHeight, width, lineHeight);
		
		for(int i=0; i<SCALE_COUNT; i++){
			for(int j1=0; j1<6; j1++){
				lineHeight += gridHeightFive;
				vlineLocation[vindex] = lineHeight; vindex ++;
				g.drawLine(0, lineHeight, width, lineHeight);
			}
			lineHeight = lineHeight - gridHeightFive * 6 + whiteKeyHeight * 4;
			vlineLocation[vindex] = lineHeight; vindex ++;
			g.drawLine(0, lineHeight, width, lineHeight);
			for(int j2=0; j2<4; j2++){
				lineHeight += gridHeightThree;
				vlineLocation[vindex] = lineHeight; vindex ++;
				g.drawLine(0, lineHeight, width, lineHeight);
			}
			lineHeight = lineHeight - gridHeightFive * 4 + whiteKeyHeight * 3;
			vlineLocation[vindex] = lineHeight; vindex ++;
			g.drawLine(0, lineHeight, width, lineHeight);
		}
		
		//horizontal line
		int lineWidth = 0;
		hlineLocation[0] = lineWidth; 
		g.setColor(Color.gray);
		for(int i=0; i<gridCount; i++){
			g.drawLine(lineWidth, 0, lineWidth, height);
			lineWidth += gridInterval;
			hlineLocation[i + 1] = lineWidth;
		}
		
		//change color of grid
	/*	int changingIsWhite = getKey(theY)[0];
		int changingKeyIndex = getKey(theY)[1];
		
		int x1 = theX / gridInterval;
		x1 *= gridInterval;
		int x2 = x1 + gridInterval;
		int xStart = getHorizontalLocation(theX, x1, x2, beatsPerMeasure);
		int[] yValue = getVerticalLocation(theY, vlineLocation);
		int yStart = yValue[0];
		int yHeight = yValue[1];
		int beatIndex = yValue[2];
		g.setColor(Color.blue);
		g.fillRect(xStart, yStart, x2 - xStart, yHeight);
		*/
		
	}
	
	private void paintNewGrid(){

		int changingIsWhite = getKey(theY)[0];
		int changingKeyIndex = getKey(theY)[1];
		
		int x1 = theX / gridInterval;
		x1 *= gridInterval;
		int x2 = x1 + gridInterval;
		int xStart = getHorizontalLocation(theX, x1, x2, beatsPerMeasure);
		int[] yValue = getVerticalLocation(theY, vlineLocation);
		int yStart = yValue[0];
		int yHeight = yValue[1];
		int beatIndex = yValue[2];
		
		Grid grid = new Grid(xStart, yStart, x2 - xStart, yHeight,
				changingIsWhite, changingKeyIndex, beatIndex, beatsPerMeasure);
		
		this.add(grid);
		
		addRecord(grid);
	}
	
	private void paintSelectedGrids(){
		for(Grid grid : getRecords()){
			
		}
	}
	
	private void addRecord(Grid g){
		records.addRecord(g);
	}
	private ArrayList<Grid> getRecords(){
		return records.getAllRecords();
	}
	private Grid removeRecord(){
		return records.removeRecord();
	}
	
	private MouseAdapter adapter = new MouseAdapter(){
		
		public void mousePressed(MouseEvent e){
			theX = e.getX();
			theY = e.getY();
			
			sign = PRESSED;
			repaint();
		}
		public void mouseReleased(MouseEvent e){
			theX = e.getX();
			theY = e.getY();
			
			sign = IDLE;
		}
		
	};	
	
	private int[] getKey(double y){
		int isWhite = 0;
		int keyIndex = -1;
		int scaleIndex = (int) (y / (whiteKeyHeight * SIZE_OF_WHITE_KEY));
		for(int i=0; i<(SCALE_COUNT + 1); i++){
			if((y > vlineLocation[i + scaleIndex * SCALE_COUNT]) &&
					(y <= vlineLocation[i + scaleIndex * SCALE_COUNT + 1])){
				keyIndex = i;
				break;
			}
		}
		if(keyIndex < 7){
			if(keyIndex % 2 == 1){
				isWhite = 1;
				keyIndex = (keyIndex - 1) / 2;
			}
			else{
				keyIndex = keyIndex / 2;
			}
		}
		else{
			if(keyIndex % 2 == 0){
				isWhite = 1;
				keyIndex = keyIndex / 2 - 1;
			}
			else{
				keyIndex = (keyIndex + 1) / 2;
			}
		}
		
		return new int[]{isWhite, keyIndex};
	}

	private int getHorizontalLocation(int x, int i1, int i2, int beatsPerMeasure){
		int return_value = -1;
		for(int i=0; i<beatsPerMeasure; i++){
			if((x > i1 + (i2 - i1) / beatsPerMeasure * i) && 
					(x <= i1 + (i2 - i1) / beatsPerMeasure * (i + 1))){
				return_value = i1 + (i2 - i1) / beatsPerMeasure * i;
				break;
			}
		}
		return return_value;
	}
	private int[] getVerticalLocation(int y, int[] lineLocation){
		int startLocation = -1;
		int height = -1;
		int beatIndex = -1;
		for(int i=0; i<lineLocation.length; i++){
			if((y > lineLocation[i]) && 
					(y <= lineLocation[i + 1])){
				startLocation = lineLocation[i];
				height = lineLocation[i + 1] - lineLocation[i];
				beatIndex = i;
				break;
			}
		}
		return new int[]{startLocation, height, beatIndex};
	}
	
	
}
