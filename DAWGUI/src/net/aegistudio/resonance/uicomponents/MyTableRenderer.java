package net.aegistudio.resonance.uicomponents;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
/**
 * @author wyt
 */
public class MyTableRenderer extends JLabel implements TableCellRenderer{

	private int column1,column2;
	private static final long serialVersionUID = 1L;
	public MyTableRenderer(int num1,int num2){
super();
this.column1=num1;
this.column2=num2;
		}
	public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof String){
        	this.setText((String)value);
        }else if(value instanceof ImageIcon){
        	ImageIcon icon=(ImageIcon)value;
        	icon.getImage().getScaledInstance(this.getHeight(), this.getHeight(), Image.SCALE_DEFAULT);
    		this.setIcon((ImageIcon) value);
        }
        this.setOpaque(true);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("黑体",Font.PLAIN,14));
      
        if(row%2==0){
        	  this.setForeground(MyColor.BLACK.getColor());
              this.setBackground(MyColor.WHITE.getColor());
        }else{
        	  this.setForeground(MyColor.BLACK.getColor());
              this.setBackground(MyColor.DARKERGREY.getColor());
        }
        if(isSelected){
        	this.setForeground(MyColor.WHITE.getColor());
        	this.setBackground(MyColor.BLUE.getColor());
        }
        if(column==this.column1||column==this.column2){
        	
        }
		return this;
		}
}
