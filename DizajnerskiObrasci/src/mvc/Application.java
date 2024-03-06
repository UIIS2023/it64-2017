package mvc;

import javax.swing.JFrame;

import controller.DrawingController;
import model.DrawingModel;
import view.DrawingFrame;

public class Application {

	public static void main(String[] args) {
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setController(controller);
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
