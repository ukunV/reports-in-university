package CommandPattern;

public class enterCommand implements Command {
    Light myLight;
    TV myTV;

    public enterCommand(Light light, TV tv) {
        this.myLight = light;
        this.myTV = tv;
    }

    @Override
    public void execute() {
        myLight.on();
        myTV.on();
    }
}
