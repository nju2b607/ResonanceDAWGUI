package net.aegistudio.resonance.uicomponents;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
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
	public MyScrollPane(JTree tree){
		super(tree);
		init();
	}
	public void init(){

		JScrollBar scroll1=new JScrollBar();
		scroll1.setUI(new MyScrollBarUI());
		JScrollBar scroll2=new JScrollBar(JScrollBar.HORIZONTAL);
		scroll2.setUI(new MyScrollBarUI());
		this.setBorder(new MatteBorder(1,1,1,1,MyColor.DARKESTGREY.getColor()));
		this.getViewport().setBackground(MyColor.BLACK.getColor());
		this.setVerticalScrollBar(scroll1);//
		this.setHorizontalScrollBar(scroll2);
		this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JLabel jl=new JLabel();
		jl.setBorder(new MatteBorder(1,1,1,1,MyColor.DARKERGREY.getColor()));
		jl.setBackground(MyColor.BLACK.getColor());
		jl.setOpaque(false);
		this.setCorner(UPPER_RIGHT_CORNER, jl);

	}

}
