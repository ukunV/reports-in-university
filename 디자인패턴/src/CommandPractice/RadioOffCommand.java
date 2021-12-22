package CommandPractice;

public class RadioOffCommand implements Command {
    Radio radio = null;

    public RadioOffCommand(Radio radio) {
        this.radio = radio;
    }

    public void execute() {
        radio.turnOff();
    }

    @Override
    public String showDescription() {
        return "Radio is off.";
    }
}