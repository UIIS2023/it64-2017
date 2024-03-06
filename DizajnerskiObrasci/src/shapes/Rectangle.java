package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends SurfaceShape {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point upperLeftPoint;
	private int width;
	private int height;
	

	public Rectangle() {
		
	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color innerColor, Color edgeColor) {
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
		setEdgeColor(edgeColor);
		setInnerColor(innerColor);
	}

	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) {
		this(upperLeftPoint, height, width);
		setSelected(selected);
	}
	
	@Override
	public void draw(Graphics g) {
		if (getInnerColor() != null) {
			g.setColor(getInnerColor());
			//g.fillRect(this.getUpperLeftPoint().getX(), this.getUpperLeftPoint().getY(), this.getWidth(), this.height);
			fill(g);
		}

		if (getEdgeColor() != null)
			g.setColor(getEdgeColor());
		else
			g.setColor(Color.BLACK);

		g.drawRect(this.getUpperLeftPoint().getX(), this.getUpperLeftPoint().getY(), this.getWidth(), this.height);
		g.setColor(Color.BLACK);

		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() - 3 + getWidth(), this.getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() - 3 + getHeight(), 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() + getWidth() - 3,
					this.getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
		
	}
	
	
	public boolean contains(Point p) {
		if (this.getUpperLeftPoint().getX() <= p.getX() && p.getX() <= this.getUpperLeftPoint().getX() + width
				&& this.getUpperLeftPoint().getY() <= p.getY()
				&& p.getY() <= this.getUpperLeftPoint().getY() + height) {
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public boolean contains(int x, int y) {
		if (this.getUpperLeftPoint().getX() <= x && x <= this.getUpperLeftPoint().getX() + width
				&& this.getUpperLeftPoint().getY() <= y && y <= this.getUpperLeftPoint().getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (this.area() - ((Rectangle) o).area());
		}
		return 0;
	}
	
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle r = (Rectangle) obj;
			if (this.upperLeftPoint.equals(r.getUpperLeftPoint()) && this.height == r.getHeight()
					&& this.width == r.getWidth()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(getUpperLeftPoint().getX(), getUpperLeftPoint().getY(), getWidth(), getHeight());
		
	}

	public Shape clone() {
		Rectangle rectangle = new Rectangle(new Point(getUpperLeftPoint().getX(), getUpperLeftPoint().getY()), getHeight(), getWidth());
		rectangle.setEdgeColor(getEdgeColor());
		rectangle.setInnerColor(getInnerColor());
		rectangle.setSelected(isSelected());
		
		return rectangle;
	}
	
	public String toString() {
		return "Rectangle: (" + upperLeftPoint.getX() + ", " + upperLeftPoint.getY() + "), " + "height = " + height
				+ "; width = " + width + "; inner color {" + Integer.toString(getInnerColor().getRGB()) + "} "
				+ "edge color {" + Integer.toString(getEdgeColor().getRGB()) + "}";
	}
	
	
	public int area() {
		return width * height;
	}
	
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}