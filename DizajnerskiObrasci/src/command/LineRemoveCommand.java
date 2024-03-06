package command;

import model.DrawingModel;
import shapes.Line;

public class LineRemoveCommand implements Command{

	private DrawingModel model;
	private Line line;

	public LineRemoveCommand(DrawingModel model, Line line) {
		this.model = model;
		this.line = line;
	}

	@Override
	public void execute() {
		model.remove(line);
	}

	@Override
	public void unexecute() {
		model.add(line);
	}

	@Override
	public String log() {
		return "Deleted: " + line.toString();
	}
}
