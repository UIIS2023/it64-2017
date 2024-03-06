package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point center;
	private int radius;
	
	public Circle() {
		
	}
	

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}

	public Circle(Point center, int radius, Color innerColor, Color edgeColor) {
		this.center = center;
		this.radius = radius;
		setInnerColor(innerColor);
		setEdgeColor(edgeColor);
	}

	public Circle(Point center, int radius, Color innerColor, Color edgeColor, boolean selected) {
		this(center, radius, innerColor, edgeColor);
		setSelected(selected);
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (this.radius - ((Circle) o).radius);
		}
		return 0;
	}

	
	@Override
	public void draw(Graphics g) {
		if (getInnerColor() != null) {
			g.setColor(getInnerColor());
		
			fill(g);
		}

		if (getEdgeColor() != null)
			g.setColor(getEdgeColor());
		else
			g.setColor(Color.BLACK);

		g.drawOval(this.getCenter().getX() - this.radius, getCenter().getY() - getRadius(), this.getRadius() * 2,
				this.getRadius() * 2);
		g.setColor(Color.BLACK);

		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getRadius() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle c = (Circle) obj;
			if (this.center.equals(c.getCenter()) && this.radius == c.getRadius()) {
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
		g.fillOval(this.getCenter().getX() - this.radius, getCenter().getY() - getRadius(), this.getRadius() * 2,
				this.getRadius() * 2);
		
	}
	
	@Override
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= radius;
	}
	
	public Shape clone() {
		Circle circle = new Circle();
		circle.setCenter(new Point(center.getX(),center.getY()));
		circle.setRadius(getRadius());
		circle.setEdgeColor(getEdgeColor());
		circle.setInnerColor(getInnerColor());
		circle.setSelected(isSelected());
		return circle;
	}
	
	public String toString() {
		return "Circle: (" + center.getX() + ", " + center.getY() + ") " + "radius = " + radius + "; inner color {"
				+ Integer.toString(getInnerColor().getRGB()) + "}, edge color {"
				+ Integer.toString(getEdgeColor().getRGB()) + "}";
	}

	public boolean contains(Point p) {
		return center.distance(p.getX(), p.getY()) <= radius;
	}


	public double area() {
		return radius * radius * Math.PI;
	}
	
	public Point getCenter() {
		return center;
	}



	public void setCenter(Point center) {
		this.center = center;
	}



	public int getRadius() {
		return radius;
	}



	public void setRadius(int radius) {
		this.radius = radius;
	}

}