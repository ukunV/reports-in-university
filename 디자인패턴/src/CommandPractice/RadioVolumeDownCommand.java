package CommandPractice;

public class RadioVolumeDownCommand implements Command {
    Radio radio = null;

    public RadioVolumeDownCommand (Radio radio) {this.radio = radio;}

    public void execute() {
        radio.volumeDown();
    }

    @Override
    public String showDescription() {
        return "Radio Volume Down.";
    }
}
