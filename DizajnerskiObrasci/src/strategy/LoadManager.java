package strategy;

public class LoadManager implements Load {

	public Load load;
	
	public LoadManager(Load load) {
		this.load = load;
	}

	@Override
	public Object loadData(String path) {
		// TODO Auto-generated method stub
		return load.loadData(path);
	}

}
