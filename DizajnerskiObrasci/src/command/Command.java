package command;

public interface Command {
	void execute();
	void unexecute();
	String log();
}
