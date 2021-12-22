package CommandPractice;

public class RadioOnCommand implements Command {
    Radio radio = null;

    public RadioOnCommand (Radio radio) {this.radio = radio;}

    public void execute() {
        radio.turnOn();;
    }

    @Override
    public String showDescription() {
        return "Radio is on.";
    }
}
