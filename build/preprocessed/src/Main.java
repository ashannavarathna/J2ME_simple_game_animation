/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author x
 */
public class Main extends MIDlet {


    public void startApp() {
       final Viewer v = new Viewer();
        v.start();
        v.addCommand(new Command("Exit", Command.EXIT, 0));
        v.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable s) {
                v.stop();
                notifyDestroyed();
            }
        });
        Display.getDisplay(this).setCurrent(v);

    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
