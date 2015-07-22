package net.aegistudio.resonance.uicomponents; 
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D; 
/** 
 *  @author wyt
 *  closeButton.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			frame.dispose();	
			System.exit(0);
		}
	});
 */ 
public class CloseButton extends JButton{ 

 private static final long serialVersionUID = 1L; 

 private Dimension dem = new Dimension(15,15); 
 public CloseButton(){ 
  this.setForeground(MyColor.BLACK.getColor());
  this.setPreferredSize(dem); 
  this.setToolTipText("¹Ø±Õ");
  this.setBorderPainted(true);
  this.setBorder(new MatteBorder(1,1,1,1,MyColor.DARKESTGREY.getColor()));
 
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
 protected void paintComponent(Graphics g) 
 { 
    
  Graphics2D g2d = (Graphics2D)g.create(); 
  Rectangle2D.Float re = new Rectangle2D.Float(0,0,getWidth(),getHeight()); 
  Line2D.Float L1 = new Line2D.Float(new Point(3,3),new Point(12,12) ); 
  
  Line2D.Float L2 = new Line2D.Float(new Point(12,3),new Point(3,12) ); 

  g2d.draw(re); 
  g2d.fill(re); 
  
  g2d.setColor(MyColor.GREY.getColor()); 
  g2d.setStroke(new BasicStroke(2F)); 
  g2d.draw(L1); 
  g2d.setStroke(new BasicStroke(2F)); 
  g2d.draw(L2); 
  g2d.dispose(); 
    
 } 
   
}  

