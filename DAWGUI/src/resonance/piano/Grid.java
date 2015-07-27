package resonance.piano;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/**
 * @author okamiji
 */

@SuppressWarnings("serial")
public class Grid extends JPanel{
	
	private int xStart;
	private int yStart;
	private int width;
	private int height;
	
	private int isWhite;
	private int keyIndex;
	private int beatIndex;
	private int beatsPerMeasure;
	
	@SuppressWarnings("unused")
	private Grid(){}
	
	public Grid(int _xStart_, int _yStart_, int _width_, int _height_, int _isWhite_, int _keyIndex_, int _beatIndex_, int _beatsPerMeasure_){
		
		this.xStart = _xStart_;
		this.yStart = _yStart_;
		this.width = _width_;
		this.height = _height_;
		
		this.isWhite = _isWhite_;
		this.keyIndex = _keyIndex_;
		this.beatIndex = _beatIndex_;
		this.beatsPerMeasure = _beatsPerMeasure_;
		
		this.setLocation(xStart, yStart);
		this.setSize(width, height);
		
		this.addMouseMotionListener(new MouseAdapter() {
		    private boolean left = false;
		    private boolean right = false;
		    private Point draggingAnchor = null;
            
		    public void mouseMoved(MouseEvent e) {
            	if(Math.abs(e.getPoint().getX()) <= 5){
            		getGrid().setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
            		left = true;
            	}
            	else if(Math.abs(e.getPoint().getX() - getGrid().getSize().getWidth()) <= 5){
            		getGrid().setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
            		right = true;
            	}
            	else{
            		getGrid().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            		draggingAnchor = new Point((int) (e.getX() - getGrid().getLocation().getX()), (int) (e.getY() - getGrid().getLocation().getY()));
 
            		left = false;
            		right = false;
            	}
            }
            
            public void mouseDragged(MouseEvent e) {
            	
            	Dimension currentSize = getGrid().getSize();
            	
            	if(left){
            		currentSize.setSize(currentSize.getWidth() - e.getX(), currentSize.getHeight());
            		getGrid().setSize(currentSize);
            		getGrid().setLocation((int) getGrid().getLocation().getX() + e.getX(), (int) getGrid().getLocation().getY());
            	}
            	else if(right){
            		currentSize.setSize(e.getX(), currentSize.getHeight());
            		getGrid().setSize(currentSize);
            	}
            	else{
            		getGrid().setLocation(e.getX() - draggingAnchor.x, (int) getGrid().getLocation().getY());
            	}

        		getGrid().setWidth((int) currentSize.getWidth());
        		getGrid().setHeight((int) currentSize.getHeight());
        		
            }
            
        });
		
	}

	public void paint(Graphics g){
		
		g.setColor(Color.yellow);
		
		g.drawLine(0, 0, width - 1, 0);
		g.drawLine(0, 0, 0, height - 1);
		g.drawLine(width - 1, 0, width - 1, height - 1);
		g.drawLine(0, height - 1, width - 1, height - 1);
		
	}

	private Grid getGrid(){
		return this;
	}
	
	private void setWidth(int _width_){
		this.width = _width_;
	}
	private void setHeight(int _height_){
		this.height = _height_;
	}
	
	protected int[] getProperties(){
		/**
		 * @return xStart, yStart, width, height, isWhite, keyIndex, beatIndex, beatsPerMeasure
		 */
		return new int[]{xStart, yStart, width, height, isWhite, keyIndex, beatIndex, beatsPerMeasure};
	}
	
}
