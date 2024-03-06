package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SurfaceShape extends Shape{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color innerColor;
	
	public abstract void fill(Graphics g);
	
	public Color getInnerColor() {
		return innerColor;
	}
	
	public void setInnerColor(Color innerColor) {
		this.innerColor=innerColor;
	}
	

}
