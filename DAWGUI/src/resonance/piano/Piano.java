package resonance.piano;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

/**
 * @author okamiji
 */
@SuppressWarnings("serial")
public class Piano extends Component{

	final int SCALE_COUNT = 11;
	final int SIZE_OF_SCALE = 12;
	final int SIZE_OF_WHITE_KEY = 7;
	final int SIZE_OF_BLACK_KEY = 5;
	
	final ImageIcon[] whiteKey = {new ImageIcon("picture/whiteKeyIdle.png"), new ImageIcon("picture/whiteKeyPressed.png")};
	final ImageIcon[] blackKey = {new ImageIcon("picture/blackKeyIdle.png"), new ImageIcon("picture/blackKeyPressed.png")};
	
	int[] stateOfWhiteKey;
	int[] stateOfBlackKey;
	int[][] state;
	
	int whiteKeyWidth;
	int whiteKeyHeight;
	int blackKeyWidth;
	int blackKeyHeight;
	
	String[] whiteKeyName = {};
	String[] blackKeyName = {};
			
	int[] blackKeyLocation;
	
	public Piano(){		
		whiteKeyWidth = new ImageIcon("picture/whiteKeyIdle.png").getIconWidth();
		whiteKeyHeight = new ImageIcon("picture/whiteKeyIdle.png").getIconHeight();
		blackKeyWidth = new ImageIcon("picture/blackKeyIdle.png").getIconWidth();
		blackKeyHeight = new ImageIcon("picture/blackKeyIdle.png").getIconHeight();

		stateOfWhiteKey = new int[SIZE_OF_WHITE_KEY * SCALE_COUNT];
		for(int i=0; i<SIZE_OF_WHITE_KEY * SCALE_COUNT; i++){
			stateOfWhiteKey[i] = 0;
		}
		stateOfBlackKey = new int[SIZE_OF_BLACK_KEY * SCALE_COUNT];
		for(int i=0; i<SIZE_OF_BLACK_KEY * SCALE_COUNT; i++){
			stateOfBlackKey[i] = 0;
		}
		state = new int[2][];
		state[0] = stateOfWhiteKey;
		state[1] = stateOfBlackKey;
		
		this.setSize(whiteKeyWidth, whiteKeyHeight * SIZE_OF_SCALE * SCALE_COUNT);
		
		this.addMouseListener(adapter);
	}
	
	public Dimension getSize(){
		return new Dimension(whiteKeyWidth, whiteKeyHeight * SIZE_OF_SCALE * SCALE_COUNT);
	}
	
	public void paint(Graphics g) {
		//draw white keys
		for(int i=0; i<SIZE_OF_WHITE_KEY * SCALE_COUNT; i++){
			g.drawImage(whiteKey[state[0][i]].getImage(), 0, whiteKeyHeight * i, this);
		}
		//draw black keys & get location of each single black key
		int location = - blackKeyHeight / 2;
		blackKeyLocation = new int[SIZE_OF_BLACK_KEY * SCALE_COUNT];
		for(int i=0; i<SIZE_OF_BLACK_KEY * SCALE_COUNT; i++){
			if(i % 5 == 3 || (i % 5 == 0)){
				location += whiteKeyHeight;
			}
			blackKeyLocation[i] = location;
			g.drawImage(blackKey[state[1][i]].getImage(), 0, location, this);
			location += whiteKeyHeight;
		}
	}

	MouseAdapter adapter = new MouseAdapter(){
		public void mousePressed(MouseEvent e) {
			double x = e.getX();
			double y = e.getY();
//			System.out.println("x:  " + x + "  y : " + y + " " + whiteKeyWidth + " " + whiteKeyHeight);
			int[] key = getKey(x, y);
			int isWhite = key[0];
			int keyIndex = key[1];
			state[isWhite][keyIndex] = 1;
			repaint();
//			System.out.println(isWhite + " " + keyIndex);
		}
		
		public void mouseReleased(MouseEvent e){
			double x = e.getX();
			double y = e.getY();
			int[] key = getKey(x, y);
			int isWhite = key[0];
			int keyIndex = key[1];
	//		System.out.println(isWhite + " " + keyIndex);
			if(keyIndex != -1){
				state[isWhite][keyIndex] = 0;
			}
			else{
				for(int i=0; i<2; i++){
					for(int j=0; j<state[i].length; j++){
						if(state[i][j] == 1){
							state[i][j] = 0;
							repaint();
						}
					}
				}
			}
			repaint();
		}
		
	};
	
	private int[] getKey(double x, double y){
		int isWhite = 0;
		int keyIndex = -1;
		if((x >= 0) && (x <= whiteKeyWidth) && (y >= 0) && (y <= whiteKeyHeight * SIZE_OF_SCALE * SCALE_COUNT)){
			if(x <= blackKeyWidth){
				for(int i=0; i<SIZE_OF_BLACK_KEY * SCALE_COUNT; i++){
					if((y >= blackKeyLocation[i]) && (y <= (blackKeyLocation[i] + blackKeyHeight))){
						isWhite = 1;
						keyIndex = i;
						break;
					}
				}
				if(isWhite == 0){
					keyIndex = (int) (y / whiteKeyHeight);
				}
			}
			else{
				keyIndex = (int) (y / whiteKeyHeight);
			}
		}
		return new int[]{isWhite, keyIndex};
	}
	
}
	
