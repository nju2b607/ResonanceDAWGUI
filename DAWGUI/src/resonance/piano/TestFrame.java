package resonance.piano;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

import net.aegistudio.resonance.uicomponents.MyScrollPane;

/**
 * @author okamiji
 */

@SuppressWarnings("serial")
public class TestFrame extends JFrame{
	
	public TestFrame(){
		super();
		
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setBounds(350, 50, 800, 1000);		
		
	//	init_components();
		
		PianoRoll roll = new PianoRoll(500, 500);
		roll.setLocation(0, 0);
		this.add(roll);
		
		this.revalidate();
		this.repaint();
	}
	
	public void init_components(){

		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 700, 1771);
	//	panel.setBackground(Color.RED);
		
		Piano piano = new Piano();
		piano.setSize(piano.getSize());
		piano.setLocation(20, 18);
		panel.add(piano);

		GridChooser chooser = new GridChooser();
		chooser.setLocation((int) piano.getLocation().getX() + KeyParam.whiteKeyWidth, (int) piano.getLocation().getY() - 23);
		panel.add(chooser);
		
		MyScrollPane msp = new MyScrollPane(panel);
		msp.setBounds(0, 0, 600, 500);
		msp.setBorder(null);
		msp.setBackground(new Color(0, 0, 0, 0));
		msp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		msp.setOpaque(true);
		
		//TODO
	/*	msp.doLayout();
		msp.getVerticalScrollBar().setValue(panel.getSize().height / 2);
	*/	
		panel.setPreferredSize(new Dimension(msp.getWidth() - 50, 1771 + 50));
		
		this.add(msp);
		msp.revalidate();
		msp.repaint();		
		
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		TestFrame.class.newInstance();
	}
	
}
