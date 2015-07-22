package net.aegistudio.resonance.uicomponents;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
/**
 * 
 * @author wyt
 * 
 *
 */
public class MyScrollPane extends JScrollPane{
	private static final long serialVersionUID = 1L;
	
	public MyScrollPane(JPanel jp){
		super(jp);
		init();
	}
	public void init(){

		JScrollBar scroll=new JScrollBar();
		scroll.setUI(new MyScrollBarUI());
		this.setBorder(new MatteBorder(1,1,1,1,MyColor.DARKESTGREY.getColor()));
		this.getViewport().setBackground(MyColor.BLACK.getColor());
		this.setVerticalScrollBar(scroll);//
		JLabel jl=new JLabel();
		jl.setBorder(new MatteBorder(1,1,1,1,MyColor.DARKERGREY.getColor()));
		jl.setBackground(MyColor.BLACK.getColor());
		jl.setOpaque(false);
		this.setCorner(UPPER_RIGHT_CORNER, jl);

	}

}
