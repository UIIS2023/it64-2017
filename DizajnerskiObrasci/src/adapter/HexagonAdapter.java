package adapter;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;
import shapes.Point;
import shapes.Shape;
import shapes.SurfaceShape;

public class HexagonAdapter extends SurfaceShape {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hexagon hexagon;
	
	public HexagonAdapter() {
		
	}
	
	public HexagonAdapter(Point center, int radius) {
		this.hexagon = new Hexagon(center.getX(), center.getY(), radius);
		
	}
	
	public HexagonAdapter(Point center, int radius, Color innerColor, Color edgeColor) {
		this.hexagon = new Hexagon(center.getX(), center.getY(), radius);
		this.hexagon.setAreaColor(innerColor);
		this.hexagon.setBorderColor(edgeColor);
	}
	
	
	public Hexagon getHexagon() {
		return hexagon;
	}
	
	public void setHexagon(Point center, int radius, Color innerColor, Color edgeColor) {
		this.hexagon = new Hexagon(center.getX(), center.getY(), radius);
		this.hexagon.setAreaColor(innerColor);
		this.hexagon.setBorderColor(edgeColor);
		hexagon.setSelected(true); 
	}

	@Override
	public void moveBy(int byX, int byY) {
		hexagon.setX(byX);
		hexagon.setY(byY);
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof HexagonAdapter) {
			HexagonAdapter h = (HexagonAdapter) o;
			return (int) (hexagon.getR() - h.getHexagon().getR());
		} else
			return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
		
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(hexagon.getAreaColor());
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			HexagonAdapter hexagonAdapter = (HexagonAdapter) obj;
			Point center1 = new Point(hexagon.getX(), hexagon.getY());
			Point center2 = new Point(hexagonAdapter.hexagon.getX(), hexagonAdapter.hexagon.getY());
			if (center1.equals(center2) && hexagon.getR() == hexagonAdapter.getHexagon().getR())
				return true;
			else
				return false;

		} else
			return false;
	}
	
	public boolean isSelected() {
		return hexagon.isSelected();
	}
	
	public void setSelected(boolean selected) {
		hexagon.setSelected(selected);
	}
	
	public Color getInnerColor() {
		return hexagon.getAreaColor();
	}
	
	public void setInnerColor(Color innerColor) {
		hexagon.setAreaColor(innerColor);
	}

	public Color getEdgeColor() {
		return hexagon.getBorderColor();
	}
	
	public void setEdgeColor(Color edgeColor) {
		hexagon.setBorderColor(edgeColor);
	}
	
	public double area() {
		return hexagon.getR() * hexagon.getR() * Math.PI;
	}
/*
	public HexagonAdapter clone(HexagonAdapter h) {
		h.getHexagon().setX(hexagon.getX());
		h.getHexagon().setY(hexagon.getY());
		h.getHexagon().setR(hexagon.getR());
		h.getHexagon().setBorderColor(hexagon.getBorderColor());
		h.getHexagon().setAreaColor(hexagon.getAreaColor());
		return h;
	}
	*/
	
	public Shape clone() {
		HexagonAdapter hexagon = new HexagonAdapter(new Point(getHexagon().getX(), getHexagon().getY()), getHexagon().getR());
		hexagon.setEdgeColor(getEdgeColor());
		hexagon.setInnerColor(getInnerColor());
		hexagon.setSelected(isSelected());
				return hexagon;
	}
	
	public String toString() {
		return "Hexagon: Center (" + hexagon.getX() + ", " + hexagon.getY() + ") radius = " + hexagon.getR()
				+ "; inner color {" + Integer.toString(hexagon.getAreaColor().getRGB()) + "} edge color {"
				+ Integer.toString(hexagon.getBorderColor().getRGB()) + "}";

	}
}