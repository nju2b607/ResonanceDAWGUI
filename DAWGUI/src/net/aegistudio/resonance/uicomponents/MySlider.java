package net.aegistudio.resonance.uicomponents;

import java.awt.Graphics;

import javax.swing.JSlider;
/**
 * @author wyt
 */
public class MySlider extends JSlider{

	
	private static final long serialVersionUID = 1L;
	public MySlider(int a,int b,int c){
		super(a,b,c);
		init();
	}
	public MySlider(){
		super();
		init();
	}
	private void init(){
		setUI(new MySliderUI());
	}
	public void paintComponent(Graphics g){
		this.setBackground(MyColor.BLACK.getColor());
	    super.paintComponent(g);
	}
}
