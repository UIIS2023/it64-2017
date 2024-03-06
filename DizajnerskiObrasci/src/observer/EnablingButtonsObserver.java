package observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EnablingButtonsObserver {
	
	private boolean deleteEnabled;
	private boolean editEnabled;
	private boolean bringToFrontEnabled;
	private boolean bringToBackEnabled;
	private boolean toFrontEnabled;
	private boolean toBackEnabled;
	
	//upravlja listom listener-a i prosledjuje im event
	private PropertyChangeSupport propertyChangeSupport;

	public EnablingButtonsObserver() {
		propertyChangeSupport = new PropertyChangeSupport(this); //prihvata klasu koja ga poziva
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		propertyChangeSupport.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		propertyChangeSupport.removePropertyChangeListener(pcl);
	}
	
	
	//SETERI
	public void setDeleteEnabled(boolean deleteEnabled) {
		propertyChangeSupport.firePropertyChange("btnDelete", this.deleteEnabled, deleteEnabled);
		this.deleteEnabled = deleteEnabled;
	}

	public void setEditEnabled(boolean editEnabled) {
		propertyChangeSupport.firePropertyChange("btnEdit", this.editEnabled, editEnabled);
		this.editEnabled = editEnabled;
	}

	public void setBringToFrontEnabled(boolean bringToFrontEnabled) {
		propertyChangeSupport.firePropertyChange("btnToFront", this.bringToFrontEnabled, bringToFrontEnabled);
		this.bringToFrontEnabled = bringToFrontEnabled;
	}

	public void setBringToBackEnabled(boolean bringToBackEnabled) {
		propertyChangeSupport.firePropertyChange("btnToBack", this.bringToBackEnabled, bringToBackEnabled);
		this.bringToBackEnabled = bringToBackEnabled;
	}

	public void setToFrontEnabled(boolean toFrontEnabled) {
		propertyChangeSupport.firePropertyChange("btnFront", this.toFrontEnabled, toFrontEnabled);
		this.toFrontEnabled = toFrontEnabled;
	}

	public void setToBackEnabled(boolean toBackEnabled) {
		propertyChangeSupport.firePropertyChange("btnBack", this.toBackEnabled, toBackEnabled);
		this.toBackEnabled = toBackEnabled;
	}

	
	

	
}
