package CommandPattern;

public class LightOffCommand implements Command {
    Light light = null;

    public LightOffCommand (Light light) {this.light = light;}

    public void execute() {light.off();}
}
