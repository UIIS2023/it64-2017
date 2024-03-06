package command;

import model.DrawingModel;
import shapes.Shape;

public class DeleteShapesCommand implements Command{
	
	private DrawingModel model;
	private Shape shape;
	
	public DeleteShapesCommand(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		model.remove(shape);
		//shape.setSelected(false);
		
	}

	@Override
	public void unexecute() {
		model.add(shape);
	}

	@Override
	public String log() {
		return "Deleted: " + shape.toString();
	}

}
