package net.aegistudio.resonance.uicomponents;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D; 
/**
 * 
 * @author wyt
 * 
 * 没有监听，在调用的地方添加上一句
 *
	
	miniButton.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			frame.setExtendedState(JFrame.ICONIFIED);
		}
	});
 */
public class MiniButton extends JButton{

	 private static final long serialVersionUID = 1L; 
	 private Dimension dem = new Dimension(15,15); 
	 public MiniButton(){ 

	  this.setForeground(MyColor.BLACK.getColor());
	  this.setToolTipText("最小化"); 
	  this.setBorderPainted(true);
	  this.setBorder(new MatteBorder(1,1,1,1,MyColor.DARKESTGREY.getColor()));
	  this.setPreferredSize(dem);  
	  this.addMouseListener(new MouseAdapter(){
		  public void mouseEntered(MouseEvent e){
			  setForeground(MyColor.WHITE.getColor()); 
		  }
		  public void mouseExited(MouseEvent e){
			  setForeground(MyColor.BLACK.getColor()); 
		  }
	  });
	 } 
	 @Override 
	 protected void paintComponent(Graphics g) { 
	  Graphics2D g2d = (Graphics2D)g.create(); 
	  Rectangle2D.Float re = new Rectangle2D.Float(0,0,getWidth(),getHeight()); 
	  Line2D.Float L2 = new Line2D.Float(new Point(4,7),new Point(11,7) ); 
	 
	  g2d.draw(re); 
	  g2d.fill(re); 
	  
	  g2d.setColor(MyColor.DARKESTGREY.getColor()); 
	  g2d.setStroke(new BasicStroke(2.3F)); 
	  g2d.draw(L2); 
	  g2d.dispose(); 
	    
	 } 
	   
}
