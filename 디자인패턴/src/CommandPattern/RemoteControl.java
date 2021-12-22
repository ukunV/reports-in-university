package CommandPattern;

public class RemoteControl {
	Command[] onCommand = new Command[7];
	Command[] offCommand = new Command[7];
	Command undoCommand = new NullCommand();

	RemoteControl() {
		for(int i = 0; i < 7; i++) {
			onCommand[i] = new NullCommand();
			offCommand[i] = new NullCommand();
		}
	}

	public void setOnCommand(int num, Command myCommand) {
		onCommand[num] = myCommand;
	}

	public void setOffCommand(int num, Command myCommand) {
		offCommand[num] = myCommand;
	}

	public void onButtonWasPushed(int num) {
		onCommand[num].execute();
	}

	public void offButtonWasPushed(int num) {
		offCommand[num].execute();
	}

	public void undoButtonWasPushed() {
	}
 
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
//		for (int i = 0; i < onCommands.length; i++) {
//			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
//				+ "    " + offCommands[i].getClass().getName() + "\n");
//		}
		return stringBuff.toString();
	}
}
