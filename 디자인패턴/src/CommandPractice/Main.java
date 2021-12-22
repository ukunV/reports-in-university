package CommandPractice;

public class Main {
    public static void main(String[] args) {
        Radio myRadio = new Radio();

        KeyMenu myKey = new KeyMenu();
        myKey.setOnCommand(new RadioOnCommand(myRadio));
        myKey.setVolumeUpCommand(new RadioVolumeUpCommand(myRadio));
        myKey.setVolumeDownCommand(new RadioVolumeDownCommand(myRadio));
        myKey.setOffCommand(new RadioOffCommand(myRadio));

//        myKey.showMenu();
    }
}
