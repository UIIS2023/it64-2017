package strategy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveShapes implements Save {

	@Override
	public void saveData(Object objectsToSave, String path) {

		//ObjectOutputStream - zapis drawinga u stream
				try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
					objectOutputStream.writeObject(objectsToSave);
					objectOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

}