package command;

import model.DrawingModel;
import shapes.Shape;

public class DeselectShapeCommand implements Command{
	
	//private DrawingController controller;
		private DrawingModel model;
		private Shape shape;
		
		public DeselectShapeCommand(DrawingModel model, Shape shape) {
			this.model = model;
			this.shape = shape;
		}

		@Override
		public void execute() {
			shape.setSelected(false);
			model.getSelectedShapes().remove(shape);
		}

		@Override
		public void unexecute() {
			shape.setSelected(true);
			model.getSelectedShapes().add(shape);
		}

		@Override
		public String log() {
			return "Deselected shape: " + shape.toString();
		}

}
