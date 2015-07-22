package net.aegistudio.resonance.uicomponents;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.plaf.metal.MetalSliderUI;
/**
 * 
 * @author wyt
 *
 */
public class MySliderUI extends MetalSliderUI  {
    /** *//**
     * 绘制指示物
     */
	
    public void paintThumb(Graphics g)  {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
        g2d.fillRect(thumbRect.x, thumbRect.y+thumbRect.height/4,thumbRect.width/5, thumbRect.height/2);
        g2d.setPaint(MyColor.WHITE.getColor());

    }
        protected void paintHorizontalLabel(Graphics g, int v, Component l)  {
        	  l=new JLabel();
               super.paintHorizontalLabel(g, v, l);
        }
    /** *//** 
     * 绘制刻度轨迹
     */
    public void paintTrack(Graphics g)  {
        int cy, cw;
        Rectangle trackBounds = trackRect;
        if (slider.getOrientation() == JSlider.HORIZONTAL)  {
            Graphics2D g2 = (Graphics2D) g;
            cy = (trackBounds.height / 2) ;
            cw = trackBounds.width;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.translate(trackBounds.x, trackBounds.y );

            // 背景设为灰色
            g2.setPaint(MyColor.DARKESTGREY.getColor());
            g2.fillRect(0, -cy/2, cw, cy / 2);

            g2.setPaint(slider.getBackground());

            g2.setPaint(MyColor.DARKWHITE.getColor());
            g2.drawLine(0, cy, cw, cy);

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_OFF);
            g2.translate(-trackBounds.x, -(trackBounds.y ));
        } else  {
            super.paintTrack(g);
        }
    }
}
