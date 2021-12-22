package CommandPattern;

public class LightOnCommand implements Command {
    Light light = null;

    public LightOnCommand (Light light) {this.light = light;}

    public void execute() {light.on();}
}
