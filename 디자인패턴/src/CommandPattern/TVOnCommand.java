package CommandPattern;

public class TVOnCommand implements Command {
    TV myTV = null;

    public TVOnCommand (TV tv) {this.myTV = tv;}

    public void execute() {
        myTV.on();
    }
}
