package CommandPattern;

public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light bedRoomLight = new Light("Bed Room");
        TV myTV = new TV("Living Room");

        RemoteControl myRemote = new RemoteControl();
        myRemote.setOnCommand(0, new LightOnCommand(livingRoomLight));
        myRemote.setOffCommand(0, new LightOffCommand(livingRoomLight));

        myRemote.setOnCommand(1, new TVOnCommand(myTV));
        myRemote.setOffCommand(1, new TVOffCommand(myTV));

        myRemote.setOnCommand(2, new LightOnCommand(bedRoomLight));
        myRemote.setOffCommand(2, new LightOffCommand(bedRoomLight));

        myRemote.setOnCommand(5, new enterCommand(livingRoomLight, myTV));

        myRemote.onButtonWasPushed(0);
        myRemote.onButtonWasPushed(1);
        myRemote.onButtonWasPushed(2);
        myRemote.offButtonWasPushed(0);
        myRemote.offButtonWasPushed(1);
        myRemote.offButtonWasPushed(2);

        myRemote.onButtonWasPushed(5);
    }
}
