package net.aegistudio.resonance.uicomponents;

import java.awt.Font;

import javax.swing.JMenu;

/**
 * 
 * @author wyt
 *           JMenu fileMenu = new JMenu("File");
 *           fileMenu.add(item = new JRadioButtonMenuItem("Radio 1"));
 *           fileMenu.add(new JMenuItem(str, str));
 *           fileMenu.addSeparator( );
 *
 */
public class MyMenu extends JMenu {


	private static final long serialVersionUID = 1L;
	
	public MyMenu(String name){
		super(name);
		init();
	}
  private void init(){
	  this.setFont(new Font("ºÚÌå",Font.PLAIN,14));
	  this.setOpaque(true);
  }
}
