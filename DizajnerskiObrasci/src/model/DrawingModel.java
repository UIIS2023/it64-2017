package model;

import java.util.ArrayList;
import java.util.List;

import shapes.Shape;

public class DrawingModel {
	
	private List<Shape> shapes = new ArrayList<Shape>();
	//private List<Shape> selectedShapes = new ArrayList<Shape>();
	
	public List<Shape> getShapes() {
		return shapes;
	}
	/*
	public List<Shape> getSelectedShapes() {
		return selectedShapes;
	}*/
	ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
	
	public List<Shape> getSelectedShapes() {
		/*
		shapes.forEach(shape -> {
			if(shape.isSelected())
				selectedShapes.add(shape);
		});
		*/
		return selectedShapes;
	}
	
	public int getSelected() {
		for (int i=shapes.size()-1; i>=0; i--) {
			if(shapes.get(i).isSelected()) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void addShapeAtIndex(Shape shape, int ind) {
		shapes.add(ind, shape);
	}
	
	public void add(Shape p) {
		shapes.add(p);
	}
	
	public void remove(Shape p) {
		shapes.remove(p);
	}
	
	public Shape get(int i) {
		return shapes.get(i);
	}	
	
	
	public void removeSelected() {
		shapes.removeIf(shape -> shape.isSelected());
	}
	
	public boolean isEmpty() {
		return shapes.isEmpty();
	}
	
	public int getIndex(Shape shape) {
		return shapes.indexOf(shape);
	}
	
	public Shape getShape(int index) {
		return shapes.get(index);
	}
	
	
}
