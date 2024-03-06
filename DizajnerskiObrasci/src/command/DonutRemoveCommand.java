package command;

import model.DrawingModel;
import shapes.Donut;

public class DonutRemoveCommand implements Command{
	
	private DrawingModel model;
	private Donut donut;
	
	public DonutRemoveCommand(DrawingModel model, Donut donut) {
		this.model = model;
		this.donut = donut;
	}
	@Override
	public void execute() {
		model.remove(donut);
	}

	@Override
	public void unexecute() {
		model.add(donut);
	}

	@Override
	public String log() {
		return "Deleted: " + donut.toString();
	}

}
