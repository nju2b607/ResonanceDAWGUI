package net.aegistudio.resonance.uicomponents;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.border.MatteBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MyDragableTree extends JTree{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyDragableTree(){
		super();
		init();
	}
	public MyDragableTree(DefaultTreeModel model){
		super(model);
		init();
	}
	public MyDragableTree(DefaultMutableTreeNode node){
		super(node);
		init();
	}
	private void init(){
		this.setBackground(MyColor.BLACK.getColor());
		this.setBorder(new MatteBorder(1,1,1,1,MyColor.DARKESTGREY.getColor()));
		this.setForeground(MyColor.WHITE.getColor());

		this.setCellRenderer(new MyTreeCellRenderer());		 
		
	    GhostGlassPane glassPane;
	    GhostComponentAdapter componentAdapter;
        glassPane = new GhostGlassPane();
        componentAdapter = new GhostComponentAdapter(null,null);
	    this.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "Œ“ «≥¨º∂JPanel"));
	    this.addMouseMotionListener(new GhostMotionAdapter(glassPane));

	}

}
