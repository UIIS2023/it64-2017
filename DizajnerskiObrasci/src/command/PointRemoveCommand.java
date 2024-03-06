package command;

import model.DrawingModel;
import shapes.Point;

public class PointRemoveCommand implements Command{
	
	private DrawingModel model;
	private Point point;

	public PointRemoveCommand(DrawingModel model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		model.remove(point);
	}

	@Override
	public void unexecute() {
		model.add(point);
	}
	
	@Override
	public String log() {
		return "Deleted: " + point.toString();
	}

}
