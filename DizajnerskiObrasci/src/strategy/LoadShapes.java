package strategy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoadShapes implements Load{


	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Object> loadData(String path) {

		
		try {
			@SuppressWarnings("resource")
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
			return (ArrayList<Object>) objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
