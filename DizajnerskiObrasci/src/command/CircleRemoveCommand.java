package command;

import model.DrawingModel;
import shapes.Circle;

public class CircleRemoveCommand implements Command{

	private DrawingModel model;
	private Circle circle;
	
	public CircleRemoveCommand(DrawingModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		model.remove(circle);
	}

	@Override
	public void unexecute() {
		model.add(circle);
	}
	
	@Override
	public String log() {
		return "Deleted: " + circle.toString();
	}
}
