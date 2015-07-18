package ResonanceComponents;

import java.awt.Color;
/**
 * 
 * @author WYT
 * 绿色 R108 G198 B68
红色 R215 G67 B27
蓝色 R77 G137 B193
白色 R255 G255 B255背景颜色
灰紫R127 G102 B149非着重部分字体颜色
褐黑 R80 G51 B51着重部分字体颜色
灰白 R299 G299 B299表格线颜色
 *center.setBackground(MyColor.RED.getColor());
 */
public enum MyColor{
	
	   GREY(229, 229, 229),
	    RED(215, 67, 27),
	    GREEN(108, 198, 68),
	    WHITE(255,255,255),
	    PURPLE(127,102,149),
	    BLACK(80,51,51),
	    DARKWHITE(220,220,220),
	    BLUE(77,137,193);
	    

	    private final int r;
	    private final int g;
	    private final int b;

	    private MyColor(final int r,final int g,final int b) {
	        this.r = r;
	        this.g = g;
	        this.b = b;
	    }

	    public Color getColor(){
	        return new Color(r,g,b);
	    }

}
