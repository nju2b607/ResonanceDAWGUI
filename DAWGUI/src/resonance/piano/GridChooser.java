package resonance.piano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import net.aegistudio.resonance.uicomponents.MyScrollPane;

/**
 * @author okamiji
 */

@SuppressWarnings("serial")
public class GridChooser extends JPanel{
	
	private final int whiteKeyHeight = KeyParam.whiteKeyHeight;

	private final int SCALE_COUNT = KeyParam.SCALE_COUNT;
	private final int SIZE_OF_WHITE_KEY = KeyParam.SIZE_OF_WHITE_KEY;
	private final int SIZE_OF_SCALE = KeyParam.SIZE_OF_SCALE;
	
	private int gridHeightThree;
	private int gridHeightFive;
	
	private int width;
	private int height;
	
	private int[] vlineLocation;
	private int[] hlineLocation;
	
	private int measureWidth;
	private int gridCount;
	private int gridInterval;
	
	public GridChooser(){
		gridHeightThree = whiteKeyHeight * 3 / 5;
		gridHeightFive = whiteKeyHeight * 4 / 7;
		
		width = 1500; 
		height = whiteKeyHeight * SCALE_COUNT * SIZE_OF_WHITE_KEY;
		
		measureWidth = gridInterval;
		gridCount = 40;
		gridInterval = 50;
		
		vlineLocation = new int[SCALE_COUNT * SIZE_OF_SCALE];
		hlineLocation = new int[gridCount];
		
//		this.setBackground(Color.red);
		this.setSize(width, height);
		
		
		
		
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
	
	public void paint(Graphics g){
		//vertical lines
		int vindex = 0;
		
		g.setColor(Color.gray);
		
		int lineHeight = 0;
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
		g.setColor(Color.gray);
		for(int i=0; i<gridCount; i++){
			g.drawLine(lineWidth, 0, lineWidth, height);
			lineWidth += gridInterval;
			hlineLocation[i] = lineWidth;
		}
		
		
	}
	
	public Dimension getSize(){
		return new Dimension(width, height);
	}
	
	
}

