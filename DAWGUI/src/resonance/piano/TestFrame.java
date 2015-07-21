package resonance.piano;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

import ResonanceComponents.MyScrollPane;

@SuppressWarnings("serial")
public class TestFrame extends JFrame{
	
	public TestFrame(){
		super();
		
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setBounds(350, 100, 700, 500);		
		
		init_components();
		
	}
	
	public void init_components(){

		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 600, 1771);
	//	panel.setBackground(Color.RED);
		
		Piano piano = new Piano();
		piano.setSize(piano.getSize());
		piano.setLocation(20, 0);
		panel.add(piano);
		
		MyScrollPane msp = new MyScrollPane(panel);
		msp.setBounds(0, 0, 600, 400);
		msp.setBorder(null);
		msp.setBackground(new Color(0, 0, 0, 0));
		msp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		msp.setOpaque(true);
		
		panel.setPreferredSize(new Dimension(msp.getWidth() - 50, 1771));
		

		this.add(msp);
		msp.revalidate();
		msp.repaint();		
		
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		TestFrame.class.newInstance();
	}
	
}
