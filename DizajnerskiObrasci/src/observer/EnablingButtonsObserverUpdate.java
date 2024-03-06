package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import view.DrawingFrame;

public class EnablingButtonsObserverUpdate implements PropertyChangeListener {

	private DrawingFrame frame;
	
	public EnablingButtonsObserverUpdate(DrawingFrame frame) {
		this.frame = frame;
	}

//	PropertyChangeEvent se salje kada se promeni vrednost propertija
//	i prosledjuje se kao argument PropertyChangeListeneru
	

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("btnDelete")) {
			frame.getBtnDelete().setEnabled((boolean) evt.getNewValue());
		}
		if(evt.getPropertyName().equals("btnEdit")) {
			frame.getBtnEdit().setEnabled((boolean) evt.getNewValue());
		}
		if(evt.getPropertyName().equals("btnToFront")) {
			frame.getBtnToFront().setEnabled((boolean) evt.getNewValue());
		}
		if(evt.getPropertyName().equals("btnToBack")) {
			frame.getBtnToBack().setEnabled((boolean) evt.getNewValue());
		}
		if(evt.getPropertyName().equals("btnFront")) {
			frame.getBtnFront().setEnabled((boolean) evt.getNewValue());
		}
		if(evt.getPropertyName().equals("btnBack")) {
			frame.getBtnBack().setEnabled((boolean) evt.getNewValue());
		}
		
	}

}