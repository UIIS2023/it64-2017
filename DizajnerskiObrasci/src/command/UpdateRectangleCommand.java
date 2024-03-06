package command;

import shapes.Rectangle;

public class UpdateRectangleCommand implements Command{
	
	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle original;
	
	public UpdateRectangleCommand(Rectangle oldState, Rectangle newState) {
		this.oldState = oldState;
		this.newState = newState;
		original = (Rectangle) oldState.clone();
	}

	@Override
	public void execute() {
		oldState.getUpperLeftPoint().setX(newState.getUpperLeftPoint().getX());
		oldState.getUpperLeftPoint().setY(newState.getUpperLeftPoint().getY());
		oldState.setWidth(newState.getWidth());
		oldState.setHeight(newState.getHeight());
		oldState.setEdgeColor(newState.getEdgeColor());
		oldState.setInnerColor(newState.getInnerColor());
		//oldState.setSelected(true);
		
	}

	@Override
	public void unexecute() {
		oldState.getUpperLeftPoint().setX(original.getUpperLeftPoint().getX());
		oldState.getUpperLeftPoint().setY(original.getUpperLeftPoint().getY());
		oldState.setWidth(original.getWidth());
		oldState.setHeight(original.getHeight());
		oldState.setEdgeColor(original.getEdgeColor());
		oldState.setInnerColor(original.getInnerColor());
		//oldState.setSelected(true);
		
	}
	
	@Override
	public String log() {
		return "Edited: " + newState.toString();
	}

}
