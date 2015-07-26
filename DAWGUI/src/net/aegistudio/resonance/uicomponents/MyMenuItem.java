package net.aegistudio.resonance.uicomponents;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.border.MatteBorder;
/**
 * 
 * @author wyt
 * 
 *
 */
public class MyMenuItem extends JMenuItem{

	
	private static final long serialVersionUID = 1L;
	
	public MyMenuItem(){
		
	}
	public MyMenuItem(String str){
		super(str);
		init();
	}
	public MyMenuItem(ImageIcon icon){
		super(icon);
		init();
	}
	public MyMenuItem(String str,char shortcut){
		 super(str);
         this.setAccelerator(KeyStroke.getKeyStroke(shortcut,
             Toolkit.getDefaultToolkit( ).getMenuShortcutKeyMask( ), false));
         init();
	}
	public MyMenuItem(ImageIcon icon,char shortcut){
		super(icon);
        this.setAccelerator(KeyStroke.getKeyStroke(shortcut,
            Toolkit.getDefaultToolkit( ).getMenuShortcutKeyMask( ), false));
        init();
	}

	private void init(){
		this.setFont(new Font("ºÚÌå",Font.PLAIN,14));
		this.setForeground(MyColor.WHITE.getColor());
		this.setBackground(MyColor.BLACK.getColor());
		this.setBorder(new MatteBorder(1,1,1,1,MyColor.DARKESTGREY.getColor()));
		
	}
}
