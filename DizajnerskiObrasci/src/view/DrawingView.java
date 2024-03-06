package view;

import java.awt.Graphics;
import java.util.ListIterator;

import javax.swing.JPanel;

import model.DrawingModel;
import shapes.Shape;

public class DrawingView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawingModel model = new DrawingModel();
	
	public DrawingView() {
		
	}
	
	public void setModel(DrawingModel model) {
		this.model=model;
	}
	
	//super je da ne crta toggle btns kad prevucem misem
	public void paint(Graphics g) {
		super.paint(g); 
		ListIterator<Shape> it = model.getShapes().listIterator();
		while (it.hasNext()) {
			it.next().draw(g);
		}

	}
}