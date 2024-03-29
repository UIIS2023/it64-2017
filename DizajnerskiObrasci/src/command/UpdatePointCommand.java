package command;

import shapes.Point;

public class UpdatePointCommand implements Command{
	
	private Point oldState;
	private Point newState;
	private Point original;
	
	public UpdatePointCommand(Point oldState, Point newState) {
		this.oldState = oldState;
		this.newState = newState;
		original = (Point) oldState.clone();
	}

	@Override
	public void execute() {
		oldState.setX(newState.getX());
		oldState.setY(newState.getY());
		oldState.setEdgeColor(newState.getEdgeColor());
		//oldState.setSelected(newState.isSelected());
		
	}

	@Override
	public void unexecute() {
		oldState.setX(original.getX());
		oldState.setY(original.getY());
		oldState.setEdgeColor(original.getEdgeColor());
		//oldState.setSelected(original.isSelected());
		
	}
	
	@Override
	public String log() {
		return "Edited: " + newState.toString();
	}


}
