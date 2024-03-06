package command;

import model.DrawingModel;
import shapes.Shape;

public class BringToBackCommand implements Command{
	
	private Shape shape;
	private DrawingModel model;
	private int index;

	public BringToBackCommand(Shape shape, DrawingModel model) {
		this.shape=shape;
		this.model=model;
	}
	
	@Override
	public void execute() {
		index= model.getIndex(shape);
		model.remove(shape);
		model.addShapeAtIndex(shape, 0);
		
	}

	@Override
	public void unexecute() {
		if(index>model.getShapes().size()-1) return;
		
		model.remove(shape);
		model.addShapeAtIndex(shape, index);
		
	}

	@Override
	public String log() {
		return "Bring to the back: " + shape.toString();
	}

}
