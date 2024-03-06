package command;

import model.DrawingModel;
import shapes.Shape;

public class SelectShapeCommand implements Command{
	
	//private DrawingController controller;
		private DrawingModel model;
		private Shape shape;
		
		public SelectShapeCommand(DrawingModel model, Shape shape) {
			this.model = model;
			this.shape = shape;
		}
		
		@Override
		public void execute() {
			shape.setSelected(true);
			model.getSelectedShapes().add(shape);
			
		}
		
		@Override
		public void unexecute() {
			shape.setSelected(false);
			model.getSelectedShapes().remove(shape);
		}
		
		@Override
		public String log() {
			return "Selected shape: " + shape.toString();
		}

}
