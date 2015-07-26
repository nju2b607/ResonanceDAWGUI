package resonance.piano;

import javax.swing.ImageIcon;

/**
 * @author okamiji
 */

public interface KeyParam {

	int SCALE_COUNT = 11;
	int SIZE_OF_SCALE = 12;
	int SIZE_OF_WHITE_KEY = 7;
	int SIZE_OF_BLACK_KEY = 5;
	
	int whiteKeyWidth = new ImageIcon("picture/whiteKeyIdle.png").getIconWidth();
	int whiteKeyHeight = new ImageIcon("picture/whiteKeyIdle.png").getIconHeight();
	int blackKeyWidth = new ImageIcon("picture/blackKeyIdle.png").getIconWidth();
	int blackKeyHeight = new ImageIcon("picture/blackKeyIdle.png").getIconHeight();
	
}
