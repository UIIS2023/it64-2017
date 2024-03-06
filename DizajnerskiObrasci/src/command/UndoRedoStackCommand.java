package command;

import java.util.Deque;
import java.util.LinkedList;

public class UndoRedoStackCommand implements Command{

	private Deque<Command> undoDeque = new LinkedList<>();
	private Deque<Command> redoDeque = new LinkedList<>();
	
	//REDO
	@Override
	public void execute() {
		if (getRedoDeque().isEmpty()==false) {
			Command previousCommand = getRedoDeque().pollLast(); 
			getUndoDeque().offerLast(previousCommand);
			previousCommand.execute();
		}
		
	}

	//UNDO
	@Override
	public void unexecute() {
		if(getUndoDeque().isEmpty()==false) {
			Command previousCommand = getUndoDeque().pollLast();
			getRedoDeque().offerLast(previousCommand);
			previousCommand.unexecute();
		}
		
	}
	
	
	public Deque<Command> getUndoDeque() {
		return undoDeque;
	}

	public void setUndoDeque(Deque<Command> undoDeque) {
		this.undoDeque = undoDeque;
	}

	public Deque<Command> getRedoDeque() {
		return redoDeque;
	}

	public void setRedoDeque(Deque<Command> redoDeque) {
		this.redoDeque = redoDeque;
	}

	@Override
	public String log() {
		// TODO Auto-generated method stub
		return null;
	}

}
