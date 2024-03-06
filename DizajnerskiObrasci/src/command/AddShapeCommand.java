package command;

import model.DrawingModel;
import shapes.Shape;

public class AddShapeCommand implements Command{
	
	private DrawingModel model;
	private Shape shape;

	public AddShapeCommand( DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		model.add(shape);
	}

	@Override
	public void unexecute() {
		model.remove(shape);
		
	}

	@Override
	public String log() {
		return "Added: " + shape.toString();
	}

}
