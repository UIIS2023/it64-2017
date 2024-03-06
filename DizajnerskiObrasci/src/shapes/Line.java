package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point startPoint = new Point();
	private Point endPoint = new Point();
	

	public Line() {
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	
	public Line(Point startPoint, Point endPoint, Color color) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		setEdgeColor(color);
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		setSelected(selected);
	}


	public Line(Point startPoint, Point endPoint, Color color, boolean selected) {
		this(startPoint, endPoint, color);
		setSelected(selected);
	}
	
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.length() - ((Line) o).length());
		}
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		if ((startPoint.distance(x, y) + endPoint.distance(x, y)) - length() <= 0.05)
			return true;
		else
			return false;
	}

	
	public Point middleOfLine() {
		int middleByX = (this.getStartPoint().getX() + this.getEndPoint().getX()) / 2;
		int middleByY = (this.getStartPoint().getY() + this.getEndPoint().getY()) / 2;
		Point p = new Point(middleByX, middleByY);
		return p;
	}

	
	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.endPoint.getX(), this.getEndPoint().getY());
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getStartPoint().getX() - 3, this.getStartPoint().getY() - 3, 6, 6);
			g.drawRect(this.getEndPoint().getX() - 3, this.getEndPoint().getY() - 3, 6, 6);
			g.drawRect(this.middleOfLine().getX() - 3, this.middleOfLine().getY() - 3, 6, 6);
		}
		
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line l = (Line) obj;
			if (this.startPoint.equals(l.getStartPoint()) && this.endPoint.equals(l.getEndPoint())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Shape clone() {
		Line line = new Line();
		line.setStartPoint(new Point(getStartPoint().getX(), getStartPoint().getY()));
		line.setEndPoint(new Point(getEndPoint().getX(), getEndPoint().getY()));
		line.setEdgeColor(getEdgeColor());
		line.setSelected(isSelected());
		
		return line;
	}
	
	
	public String toString() {
		return "Line: " + "(" + startPoint.getX() + ", " + startPoint.getY() + "); (" + endPoint.getX() + ", "
				+ endPoint.getY() + ") " + "color {" + Integer.toString(getEdgeColor().getRGB()) + "}";
	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	

}