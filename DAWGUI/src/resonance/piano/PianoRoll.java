package resonance.piano;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author okamiji
 */

@SuppressWarnings("serial")
public class PianoRoll extends JPanel{
	
	private int width;
	private int height;
	
	@SuppressWarnings("unused")
	private PianoRoll(){}
	
	public PianoRoll(int getWidth, int getHeight){
		
		this.width = getWidth;
		this.height = getHeight;
		
		this.setLayout(null);
		this.setSize(width, height);
		
		init_components();
		
	}
	
	private void init_components(){

		Piano piano = new Piano();
		piano.setSize(piano.getSize());
		piano.setLocation(20, 0);
		this.add(piano);
		
		GridChooser chooser = new GridChooser();
	//	MyScrollPane msp = new MyScrollPane(chooser);
		JScrollPane msp = new JScrollPane(chooser);
		
		msp.setLocation((int) piano.getSize().getWidth() + 20, 0);
		msp.setSize((int) (width - piano.getSize().getWidth() - 20), height);
		msp.setBorder(null);
		msp.setBackground(new Color(0, 0, 0, 0));
		msp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		msp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		msp.setOpaque(true);

		chooser.setPreferredSize(new Dimension((int) chooser.getSize().getWidth() + 10, (int) chooser.getSize().getHeight() + 10));
		msp.setPreferredSize(new Dimension(500, 500));
		
		this.add(msp);
		msp.revalidate();
		msp.repaint();
		
		thread.start();
	}

	Thread thread = new Thread(){
		public void run(){
			while(true){
				try{
					repaint();
					Thread.sleep(10);
				}catch(Exception e){
					e.printStackTrace();
				}	
			}	
		} 
	};
	
}
