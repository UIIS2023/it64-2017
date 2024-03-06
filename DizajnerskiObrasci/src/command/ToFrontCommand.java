package command;

import model.DrawingModel;
import shapes.Shape;

public class ToFrontCommand implements Command{
	
	private Shape shape;
	private DrawingModel model;
	private int index;

	public ToFrontCommand(Shape shape, DrawingModel model) {
		this.shape=shape;
		this.model=model;
	}
	
	@Override
	public void execute() {
		index = model.getIndex(shape);
		model.remove(shape);
		model.addShapeAtIndex(shape, index+1);
		
	}

	@Override
	public void unexecute() {
		model.remove(shape);
		model.addShapeAtIndex(shape, index);
		
	}

	@Override
	public String log() {
		return "Forward for one position: " + shape.toString();
	}


}
