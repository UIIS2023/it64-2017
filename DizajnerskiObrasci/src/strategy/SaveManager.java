package strategy;

public class SaveManager implements Save {

public Save save;
	
	public SaveManager(Save save) {
		this.save = save;
	}
	
	@Override
	public void saveData(Object objectsToSave, String path) {
		save.saveData(objectsToSave, path);
	}

}

