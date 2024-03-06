package strategy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveLog implements Save {
	
	@Override
	public void saveData(Object objectsToSave, String path) {
		
		//FILE OUTPUT STREAM- zapis u fajl
		
		try {
			String objects = (String) objectsToSave;
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			fileOutputStream.write(objects.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
