package CommandPattern;

public class TVOffCommand implements Command {
    TV myTV = null;

    public TVOffCommand (TV tv) {this.myTV = tv;}

    public void execute() {
        myTV.off();
    }
}
