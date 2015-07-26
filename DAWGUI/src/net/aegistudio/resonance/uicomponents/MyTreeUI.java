package net.aegistudio.resonance.uicomponents;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.AbstractLayoutCache;
import javax.swing.tree.TreePath;
/**
 * 
 * @author wyt
 * 
 * this is used to change the width of nodes in jtree,which depends on the width of jscrollpane that jree is in
 * 
 * you can ignore this class
 *
 */
public class MyTreeUI extends BasicTreeUI {
	
	private int wid;
	
	public MyTreeUI(int width){
		this.wid=width;
	}

    @Override
    protected AbstractLayoutCache.NodeDimensions createNodeDimensions() {
        return new NodeDimensionsHandler() {
            @Override
            public Rectangle getNodeDimensions(
                    Object value, int row, int depth, boolean expanded,
                    Rectangle size) {
                Rectangle dimensions = super.getNodeDimensions(value, row,
                        depth, expanded, size);
                dimensions.width =wid;
                return dimensions;
            }
        };
    }

    @Override
    protected void paintHorizontalLine(Graphics g, JComponent c,
                                       int y, int left, int right) {
        // do nothing.
    }

    @Override
    protected void paintVerticalPartOfLeg(Graphics g, Rectangle clipBounds,
                                          Insets insets, TreePath path) {
        // do nothing.
    }
}
