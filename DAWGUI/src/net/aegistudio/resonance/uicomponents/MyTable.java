package net.aegistudio.resonance.uicomponents;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
/**
 * 
 * @author wyt
 *
 */
public class MyTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int column1=-1;
private int column2=-1;
private 	MyTableRenderer render ;
private int rowUnderMouse = -1;
private int columnUnderMouse=-1;

	public MyTable(DefaultTableModel model,int num1,int num2){
		super(model);
		this.column1=num1;
		this.column2=num2;
		render= new MyTableRenderer(this.column1,this.column2);
		init();
	}
	public MyTable(Object[][] contents,Object[] header,int num1,int num2){
		super(contents,header);
		this.column1=num1;
		this.column2=num2;
		render= new MyTableRenderer(this.column1,this.column2);
		init();
	}

    public Component prepareRenderer(TableCellRenderer renderer, int row, int column){

        Component comp = super.prepareRenderer(renderer,row,column);
        Point p = getMousePosition();
        if(p!=null){
            int rowUnderMouse = rowAtPoint(p);
            int columnUnderMouse=columnAtPoint(p);
            if(rowUnderMouse == row&&columnUnderMouse==column){
                  comp.setForeground(MyColor.BLUE.getColor());
           }else{
                  comp.setForeground(MyColor.BLACK.getColor());
           }
        }
        return comp;
}

	 public JTableHeader getTableHeader() {  
           JTableHeader tableHeader = super.getTableHeader();  
           tableHeader.setOpaque(false);
           tableHeader.setBorder(new MatteBorder(1,1,1,1,MyColor.GREY.getColor()));
           
           tableHeader.setBackground(MyColor.DARKERGREY.getColor());
           tableHeader.setReorderingAllowed(false);
           DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();  
           hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
           return tableHeader;  
	 }  

	public void init(){

		this.setGridColor(MyColor.GREY.getColor());
        this.setDefaultRenderer(Object.class, render);
        
    	this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
    	this.addMouseMotionListener(new MyTableMouseMotionListener());
    	
	}

	class MyTableMouseMotionListener extends MouseMotionAdapter{

        public void mouseMoved(MouseEvent e){
             JTable table = (JTable)e.getSource();
             Point p = table.getMousePosition();
             if(p != null){
                  rowUnderMouse = table.rowAtPoint(p);
                  columnUnderMouse=table.columnAtPoint(p);
                  if(rowUnderMouse >= 0&&columnUnderMouse>=0){
                	  if(columnUnderMouse==column1||columnUnderMouse==column2){
                		  
                                 table.prepareRenderer(table.getCellRenderer(rowUnderMouse,columnUnderMouse),rowUnderMouse,columnUnderMouse);
                          table.repaint(table.getVisibleRect());
                	  }
                  }
             }
        }
}
}
