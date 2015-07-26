package net.aegistudio.resonance.uicomponents;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.border.MatteBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyTreeCellRenderer extends DefaultTreeCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private static final Icon fileIcon = new ImageIcon("picture/fileNodeIcon.png");

    private static final Icon leafIcon = new ImageIcon("picture/leafNodeIicon.png");

	public MyTreeCellRenderer(){
	this.setFont(new Font("ºÚÌå",Font.PLAIN,14));
	
	this.setBackgroundNonSelectionColor(MyColor.BLACK.getColor());
	this.setTextNonSelectionColor(MyColor.DARKWHITE.getColor());
	this.setBorder(new MatteBorder(1,1,1,1,MyColor.BLACK.getColor()));
	  
	this.setTextSelectionColor(MyColor.WHITE.getColor());
	this.setBackgroundSelectionColor(MyColor.BLUE.getColor());
	this.setBorderSelectionColor(MyColor.BLACK.getColor());
	
	this.setSize(new Dimension(this.getWidth(),20));

}
	@Override
	  public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
	    super.getTreeCellRendererComponent(tree, value, leaf, expanded, leaf, row, hasFocus);
	    DefaultMutableTreeNode node=(DefaultMutableTreeNode)value;
	    if(node.isLeaf()){
	    	setIcon(leafIcon);
	    }else{
		    setIcon(fileIcon);
	    }
	    return this;
	  }

}
