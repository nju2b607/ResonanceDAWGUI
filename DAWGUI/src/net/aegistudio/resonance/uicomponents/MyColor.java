package net.aegistudio.resonance.uicomponents;

import java.awt.Color;
/**
 * @author WYT
 */
public enum MyColor{
	
	   BLACK(44,44,48),
	   WHITE(255,255,255),
	   DARKWHITE(249,241,204),
	   BLUE(20,146,226),
	   GREY(52,52,70),
	   DARKERGREY(98,98,98),
	   DARKESTGREY(103,103,107);
	    

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
