package command;

import shapes.Donut;

public class UpdateDonutCommand implements Command{
	
	private Donut oldState;
	private Donut newState;
	private Donut original;
	
	public UpdateDonutCommand(Donut oldState, Donut newState) {
		this.oldState = oldState;
		this.newState = newState;
		original = (Donut) oldState.clone();
	}

	@Override
	public void execute() {
		oldState.getCenter().setX(newState.getCenter().getX());
		oldState.getCenter().setY(newState.getCenter().getY());
		oldState.setRadius(newState.getRadius());
		try {
			oldState.setInnerRadius(newState.getInnerRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oldState.setEdgeColor(newState.getEdgeColor());
		oldState.setInnerColor(newState.getInnerColor());
		//oldState.setSelected(newState.isSelected());
		
		
	}

	@Override
	public void unexecute() {
		oldState.getCenter().setX(original.getCenter().getX());
		oldState.getCenter().setY(original.getCenter().getY());
		oldState.setRadius(original.getRadius());
		try {
			oldState.setInnerRadius(original.getInnerRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oldState.setEdgeColor(original.getEdgeColor());
		oldState.setInnerColor(original.getInnerColor());
		//oldState.setSelected(original.isSelected());
		
	}
	
	@Override
	public String log() {
		return "Edited: " + newState.toString();
	}

}
