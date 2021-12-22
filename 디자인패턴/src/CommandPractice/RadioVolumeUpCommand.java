package CommandPractice;

public class RadioVolumeUpCommand implements Command {
    Radio radio = null;

    public RadioVolumeUpCommand (Radio radio) {this.radio = radio;}

    public void execute() {
        radio.volumeUp();;
    }

    @Override
    public String showDescription() {
        return "Radio Volume Up.";
    }
}
