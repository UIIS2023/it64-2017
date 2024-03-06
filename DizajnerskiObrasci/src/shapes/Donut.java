package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int innerRadius;



	public Donut() {

	}
	
	public Donut(Point center, int radius, int innerRadius) throws Exception {
		super(center, radius);
		setInnerRadius(innerRadius);
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) throws Exception {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	public Donut(Point center, int radius, int innerRadius, Color innerColor, Color edgeColor) throws Exception {
		this(center, radius, innerRadius);
		setInnerColor(innerColor);
		setEdgeColor(edgeColor);
	}
	
	public Donut(Point center, int radius, int innerRadius, Color innerColor, Color edgeColor, boolean selected) throws Exception {
		this(center, radius, innerRadius, innerColor, edgeColor);
		setSelected(selected);
		
	}
	
	//tranparentna unutrasnjost
	public void draw(Graphics g) {
		Ellipse2D outsideCircle = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(),
				this.getCenter().getY() - this.getRadius(), this.getRadius() * 2, this.getRadius() * 2);
		Ellipse2D insideCircle = new Ellipse2D.Double(this.getCenter().getX() - this.getInnerRadius(),
				this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		Area bigArea = new Area(outsideCircle);
		bigArea.subtract(new Area(insideCircle));

		Graphics2D graph = (Graphics2D) g;
		graph.setColor(getInnerColor());
		graph.fill(bigArea);
		graph.setColor(getEdgeColor());
		graph.draw(bigArea);

		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getInnerRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getInnerRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getInnerRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getInnerRadius() - 3, 6, 6);

			g.drawRect(this.getCenter().getX() + getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - getRadius() - 3, 6, 6);

			g.setColor(Color.BLACK);
		}
	}
	
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}

	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return dFromCenter > innerRadius && super.contains(x, y);
	}

	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return dFromCenter > innerRadius && super.contains(p);
	}

	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}


	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d = (Donut) obj;
			if (this.getCenter().equals(d.getCenter()) && this.getRadius() == d.getRadius()
					&& this.innerRadius == d.getInnerRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	public int getInnerRadius() {
		return innerRadius;
	}
	
	public void setInnerRadius(int innerRadius) throws Exception {
		if (innerRadius > 0 && innerRadius < this.getRadius())
			this.innerRadius = innerRadius;
		else
			throw new Exception();
	}

	
	public Shape clone() {

		Donut d = new Donut();
		d.setCenter(this.getCenter());
		d.setRadius(this.getRadius());
		try {
			d.setInnerRadius(this.getInnerRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NumberFormatException("Inner radius has to be greater than radius!");
		}
		d.setEdgeColor(this.getEdgeColor());
		d.setInnerColor(this.getInnerColor());

		return d;
	}
	
	public String toString() {
		return "Donut: (" + getCenter().getX() + ", " + getCenter().getY() + ") " + "outer radius = " + getRadius()
				+ "; inner radius = " + innerRadius + "; inner color {"
				+ Integer.toString(super.getInnerColor().getRGB()) + "} edge color {"
				+ Integer.toString(super.getEdgeColor().getRGB()) + "}";
	}

}