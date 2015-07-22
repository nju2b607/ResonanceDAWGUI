package net.aegistudio.resonance.uicomponents;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
/**
 * 
 * @author wyt
 *
 */
public class MyComboBox extends JComboBox<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyComboBox(Vector<String> list) {
		super();
		init();
	}
	public MyComboBox(ArrayList<String> list) {
		super();
		init();
	}
	public MyComboBox(ComboBoxModel<Object> model) {
		super(model);
		init();
	}

	public MyComboBox(Object[] items) {
		super(items);
		init();
	}
	
	public MyComboBox(DefaultComboBoxModel<String> model){
		super();
		init();
	}

	private void init() {
		setOpaque(false);
		setUI(new MyComboBoxUI());
		setRenderer(new MyComboBoxRenderer());
	}

	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}
}