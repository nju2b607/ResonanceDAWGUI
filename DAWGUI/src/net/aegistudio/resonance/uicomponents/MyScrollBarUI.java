package net.aegistudio.resonance.uicomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
/**
 * 
 * @author wyt
 * a newly-defined scrollbar
 * 
 * -------------------example code-----------------------
 * JScrollPane sp = new JScrollPane(list,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	JScrollBar scroll=new JScrollBar();
	scroll.setUI(new MyScrollBarThinUI());
	sp.setVerticalScrollBar(scroll);
 *
 */
public class MyScrollBarUI extends BasicScrollBarUI{
	public MyScrollBarUI(){
		super();
	}

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        
    	   Graphics2D g2 = (Graphics2D) g;
           int w = thumbBounds.width - 1;
           int h = thumbBounds.height - 1;
           Paint oldPaint = g2.getPaint();

//           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                   RenderingHints.VALUE_ANTIALIAS_ON);

           g2.translate(thumbBounds.x, thumbBounds.y);

           Shape arcRect= new Rectangle2D.Float(0.0f, 0.0f, (float) w, (float) h);
           if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
        	   arcRect = new Rectangle2D.Float(0.0f, 0.0f, (float) w, (float) h);
           }else if(scrollbar.getOrientation() == JScrollBar.HORIZONTAL){
        	   arcRect = new Rectangle2D.Float(0.0f, 0.0f, (float) h, (float) w);
           }

           g2.fill(arcRect);
           g2.setColor( MyColor.DARKWHITE.getColor());
           g2.draw(arcRect);
           g2.setPaint(oldPaint);
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
    	   Graphics2D g2 = (Graphics2D) g;
           Paint backgroupRectPaint = null;

//           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                   RenderingHints.VALUE_ANTIALIAS_ON);
               backgroupRectPaint = new GradientPaint(0, 0,MyColor.GREY.getColor(),
                       trackBounds.width, 0,MyColor.GREY.getColor());
           g2.setPaint(backgroupRectPaint);
           g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
           
           g2.setColor(MyColor.GREY.getColor());
           g2.drawRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }
    protected javax.swing.JButton createDecreaseButton(int orientation) {
        return new BasicArrowButton(orientation) {

            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void paint(Graphics g) {
				super.paint(g);
                GradientPaint backgroupRectPaint = null;
                if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                    backgroupRectPaint = new GradientPaint(0, 0,  MyColor.DARKWHITE.getColor(),
                            getWidth(), 0,  MyColor.DARKWHITE.getColor());
                } else {
                    backgroupRectPaint = new GradientPaint(0, 0,  MyColor.DARKWHITE.getColor(),
                            0, getHeight(),  MyColor.DARKWHITE.getColor());
                }
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(backgroupRectPaint);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.drawRect(0, 0, getWidth(), getHeight());
                // Draw the arrow
                MyScrollBarUI.this.paintTriangle(g2, getSize(), direction);
            }
        };
    }

    public void paintTriangle(Graphics2D g2, Dimension buttonSize,
            int direction) {
        int x, y, w, h, size;

        w = buttonSize.width;
        h = buttonSize.height;
        size = Math.min((h - 4) / 3, (w - 4) / 3);
        size = Math.max(size, 2);
        x = (w - size) / 2;
        y = (h - size) / 2;

        Color oldColor = g2.getColor();
        int mid, i, j;

        j = 0;
        size = Math.max(size, 2) + 2;
        mid = (size / 2) - 1;

        g2.translate(x, y);
        g2.setColor(MyColor.GREY.getColor());
        switch (direction) {
            case NORTH:
                for (i = 0; i < size; i++) {
                    g2.drawLine(mid - i, i, mid + i, i);
                }
                break;
            case SOUTH:
                j = 0;
                for (i = size - 1; i >= 0; i--) {
                    g2.drawLine(mid - i, j, mid + i, j);
                    j++;
                }
                break;
            case WEST:
                for (i = 0; i < size; i++) {
                    g2.drawLine(i, mid - i, i, mid + i);
                }
                break;
            case EAST:
                j = 0;
                for (i = size - 1; i >= 0; i--) {
                    g2.drawLine(j, mid - i, j, mid + i);
                    j++;
                }
                break;
        }
        g2.translate(-x, -y);
        g2.setColor(oldColor);
    }

    @Override
    protected javax.swing.JButton createIncreaseButton(int orientation) {

        return new BasicArrowButton(orientation) {

            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void paint(Graphics g) {
				super.paint(g);
                GradientPaint backgroupRectPaint = null;
                if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                    backgroupRectPaint = new GradientPaint(0, 0,  MyColor.DARKWHITE.getColor(),
                            getWidth(), 0,  MyColor.DARKWHITE.getColor());
                } else {
                    backgroupRectPaint = new GradientPaint(0, 0,  MyColor.DARKWHITE.getColor(),
                            0, getHeight(), MyColor.DARKWHITE.getColor());
                }
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(backgroupRectPaint);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.drawRect(0, 0, getWidth(), getHeight());
                MyScrollBarUI.this.paintTriangle(g2, getSize(), direction);
            }
        };
    }
}
