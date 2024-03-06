package command;

import shapes.Shape;
import model.DrawingModel;


public class ToBackCommand implements Command{
	
	private DrawingModel model;
	private Shape shape;
	private int index;
	
	public ToBackCommand(Shape shape, DrawingModel model) {
		this.shape=shape;
		this.model=model;
	}

	@Override
	public void execute() {
		index= model.getIndex(shape);
		model.remove(shape);
		model.addShapeAtIndex(shape, index-1);

	}

	@Override
	public void unexecute() {
		model.remove(shape);
		model.addShapeAtIndex(shape, index);

	}

	@Override
	public String log() {
		return "Backward for one position: " + shape.toString();
	}

}
