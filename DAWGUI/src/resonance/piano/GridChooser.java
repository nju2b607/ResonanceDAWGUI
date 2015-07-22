package resonance.piano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

import net.aegistudio.resonance.uicomponents.MyScrollPane;

/**
 * @author okamiji
 */

@SuppressWarnings("serial")
public class GridChooser extends JPanel{
	
	private final int whiteKeyHeight = KeyParam.whiteKeyHeight;

	private final int SCALE_COUNT = KeyParam.SCALE_COUNT;
	private final int SIZE_OF_WHITE_KEY = KeyParam.SIZE_OF_WHITE_KEY;

	
	private int gridHeightThree;
	private int gridHeightFive;
	
	private JPanel panel;
	private MyScrollPane msp;
	
	int width;
	int height;
	
	public GridChooser(){
		gridHeightThree = whiteKeyHeight * 3 / 5;
		gridHeightFive = whiteKeyHeight * 5 / 7;
		
		width = 500; 
		height = whiteKeyHeight * SCALE_COUNT * SIZE_OF_WHITE_KEY;

//		this.setBackground(Color.red);
		this.setSize(width, height + 25);
		
		JPanel panel = new JPanel();
		MyScrollPane msp = new MyScrollPane(panel);
		msp.setSize(width - 50, height);
		msp.setBorder(null);
		msp.setBackground(new Color(0, 0, 0, 0));
		msp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		msp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		msp.setOpaque(true);
		
		panel.setPreferredSize(new Dimension(width, height));
		msp.setLocation(0, 0);
		
		this.add(msp);
		msp.setLocation(0, 0);
		msp.revalidate();
		msp.repaint();	
	}
	/*
	public void paint(Graphics g){
		
	}*/
	
}
