package command;

import adapter.HexagonAdapter;
import model.DrawingModel;

public class HexagonRemoveCommand implements Command{
	
	private DrawingModel model;
	private HexagonAdapter hexagon;
	
	public HexagonRemoveCommand(DrawingModel model, HexagonAdapter hexagon) {
		this.model = model;
		this.hexagon = hexagon;
	}

	@Override
	public void execute() {
		model.remove(hexagon);
	}

	@Override
	public void unexecute() {
		model.add(hexagon);
	}
	
	@Override
	public String log() {
		return "Deleted: " + hexagon.toString();
	}

}
