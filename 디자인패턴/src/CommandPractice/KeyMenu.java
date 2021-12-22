package CommandPractice;

import java.io.IOException;

public class KeyMenu {
    Command[] menu = new Command[4];

    public void setOnCommand(Command myCommand) {
        menu[0] = myCommand;
    }

    public void setOffCommand(Command myCommand) {
        menu[1] = myCommand;
    }

    public void setVolumeUpCommand(Command myCommand) {
        menu[2] = myCommand;
    }

    public void setVolumeDownCommand(Command myCommand) {
        menu[3] = myCommand;
    }

    public void regMenu(int index, Command cmd) {
        menu[index] = cmd;
    }

    public int showMenu() throws IOException {
        for(int i=0; i<3; i++) {
            System.out.println(i + ": " + menu[i].showDescription());
        }

        int x = System.in.read();

        if(x < '0' || x >'3') return -1;
        else {
            x = x - '0';

            menu[x].execute();

            return x - '0';
        }
    }
}
