package net.aegistudio.resonance.uicomponents;

import javax.swing.JMenuBar;

/**
 * 
 * @author wyt
 * ----------------------necessity---------------------------
 *         UIManager.put("MenuBar.background", MyColor.BLACK.getColor());
        UIManager.put("Menu.background", MyColor.BLACK.getColor());
        
        UIManager.put("Menu.foreground", MyColor.WHITE.getColor());
        UIManager.put("MenuBar.foreground", MyColor.WHITE.getColor());
        
        UIManager.put("MenuItem.selectionBackground",MyColor.BLUE.getColor());
        UIManager.put("Menu.selectionBackground",MyColor.BLUE.getColor());
        UIManager.put("MenuBar.selectionBackground",MyColor.BLUE.getColor());
 * --------------------------------------------------------------
 * 
 *         JFrame frame = new JFrame();
 *         frame.setJMenuBar(new MyMenuBar( ));
 *         JMenu fileMenu = new JMenu("File");
 *         add(fileMenu);
 *
 */
public class MyMenuBar extends JMenuBar{

	private static final long serialVersionUID = 1L;

	public MyMenuBar(){
		super();
	}
}
