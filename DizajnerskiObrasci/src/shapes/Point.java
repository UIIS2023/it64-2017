package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		setSelected(selected);
	}

	public Point(int x, int y, Color color) {
		this(x, y);
		setEdgeColor(color);
	}

	public Point(int x, int y, Color color, boolean selected) {
		this(x, y, color);
		setSelected(selected);
	}
	
	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 3;
	}

	@Override
	public void draw(Graphics g) {
			g.setColor(getEdgeColor());
			g.drawLine(this.x-2, y, this.x+2, y);
			g.drawLine(x, this.y-2, x, this.y+2);
			
			if (isSelected()) {
				g.setColor(Color.BLUE);
				g.drawRect(this.x-3, this.getY()-3, 6, 6);
			}
	}
		
	@Override
	public void moveBy(int byX, int byY) {
		this.x += byX;
		this.y += byY;
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Point) {
			Point start = new Point(0, 0);
			//rastojanje moje tacke od koordinatnog pocetka - rastojanje druge tacke od koordinatnog pocetka
			return (int) (this.distance(start.getX(), start.getY()) - ((Point) o).distance(start.getX(), start.getY()));
		}
		return 0;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			if (this.x == p.getX() && this.y == p.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public Shape clone() {
		Point point = new Point(getX(), getY(), getEdgeColor());
		point.setSelected(isSelected());
		return point;
	}
	
	public String toString() {
		return "Point: (" + x + ", " + y + "), color: (" + Integer.toString(getEdgeColor().getRGB()) + ")";
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	

}