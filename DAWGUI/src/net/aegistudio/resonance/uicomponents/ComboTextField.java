package net.aegistudio.resonance.uicomponents;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 * 
 * @author WYT
 *
 */
public class ComboTextField extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JComboBox<String> jcb;
	private ArrayList<String> items;
	private String result = "";

	public ComboTextField(ArrayList<String> list) {
		this.items = list;
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		jcb = new JComboBox<String>(model){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
		} ;
		 jcb.setOpaque(false);
		
		 jcb. setUI(new MyComboBoxUI());
		 jcb.setRenderer(new MyComboBoxRenderer());
		jcb.setSelectedItem(null);
		jcb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!isAdjusting(jcb)) {
					if (jcb.getSelectedItem() != null) {
						result = jcb.getSelectedItem().toString();
						setText(result);
					}
				}
			}
		});
		this.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				updateList();
			}

			public void removeUpdate(DocumentEvent e) {
				updateList();
			}

			public void changedUpdate(DocumentEvent e) {
				updateList();
			}

			private void updateList() {
				setAdjusting(jcb, true);
				model.removeAllElements();
				String input = getText();
				if (!input.isEmpty()) {
					for (String item : items) {
						if (item.toLowerCase().startsWith(input.toLowerCase())) {
							model.addElement(item);
						}
					}
				}
				jcb.setPopupVisible(model.getSize() > 0);
				setAdjusting(jcb, false);
			}
		});
		addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				setAdjusting(jcb, true);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (jcb.isPopupVisible()) {
						e.setKeyCode(KeyEvent.VK_ENTER);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_UP
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					e.setSource(jcb);
					jcb.dispatchEvent(e);
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						setText(jcb.getSelectedItem().toString());
						jcb.setPopupVisible(false);
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					jcb.setPopupVisible(false);
				}

				setAdjusting(jcb, false);
			}

		});
		this.setLayout(new BorderLayout());
		this.add(jcb, BorderLayout.SOUTH);

	}

	private static void setAdjusting(JComboBox<String> jcb2,
			boolean adjusting) {

		jcb2.putClientProperty("is_adjusting", adjusting);

	}

	private static boolean isAdjusting(JComboBox<String> jcb2) {

		if (jcb2.getClientProperty("is_adjusting") instanceof Boolean) {

			return (Boolean) jcb2.getClientProperty("is_adjusting");

		}

		return false;

	}

	public String getResult() {

		return result;
	}
}