package net.aegistudio.resonance.uicomponents;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
/**
 * 
 * @author wyt
 *
 */

public class MyComboBoxUI extends BasicComboBoxUI {

	private JButton arrow;
	private boolean boundsLight = true;

	public MyComboBoxUI() {
		super();
	}

	protected JButton createArrowButton() {
		arrow = new JButton();
		arrow.setIcon(new ImageIcon("img/TFIUA[5%}EG%VQAF5B[0D10.png"));//XUtil.defaultComboBoxArrowIcon
		arrow.setRolloverEnabled(true);
		arrow.setRolloverIcon(new ImageIcon("img/TFIUA[5%}EG%VQAF5B[0D10.png"));//XUtil.defaultComboBoxArrowIcon_Into
		arrow.setBorder(null);
		arrow.setBackground(Color.BLUE);//XUtil.defaultComboBoxColor
		arrow.setOpaque(false);
		arrow.setContentAreaFilled(false);
		return arrow;
	}
	
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		hasFocus = comboBox.hasFocus();
		Graphics2D g2 = (Graphics2D) g;
		if (!comboBox.isEditable()) {
			Rectangle r = rectangleForCurrentValue();
			paintCurrentValueBackground(g2, r, hasFocus);
			paintCurrentValue(g2, r, hasFocus);
		}

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		Font oldFont = comboBox.getFont();
		comboBox.setFont(new Font("ºÚÌå", Font.PLAIN, 12));//TODO XUtil.defaultComboBoxFont

		super.paintCurrentValue(g, bounds, hasFocus);
		comboBox.setFont(oldFont);
	}

	public Dimension getPreferredSize(JComponent c) {
		return super.getPreferredSize(c);
	}

	public boolean isBoundsLight() {
		return boundsLight;
	}

	public void setBoundsLight(boolean boundsLight) {
		this.boundsLight = boundsLight;
	}

	protected ComboPopup createPopup() {
		ComboPopup popup = new BasicComboPopup(comboBox) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected JScrollPane createScroller() {
				JScrollPane sp = new JScrollPane(list,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				JScrollBar scroll=new JScrollBar();
				scroll.setUI(new MyScrollBarUI());
				sp.setVerticalScrollBar(scroll);//IScrollPane to JScrollPane
				return sp;
			}

			// 
			public void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.GRAY);
				g2.drawRoundRect(0, -arrow.getHeight(), getWidth() - 1,
						getHeight() + arrow.getHeight() - 1, 0, 0);
			}
		};
		return popup;
	}
}
