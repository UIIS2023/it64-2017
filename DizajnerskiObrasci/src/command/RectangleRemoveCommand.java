package command;

import model.DrawingModel;
import shapes.Rectangle;


public class RectangleRemoveCommand implements Command{
	
	private DrawingModel model;
	private Rectangle rectangle;
	
	public RectangleRemoveCommand(DrawingModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.remove(rectangle);
		
	}

	@Override
	public void unexecute() {
		model.add(rectangle);
	}
	
	@Override
	public String log() {
		return "Deleted: " + rectangle.toString();
	}

}
