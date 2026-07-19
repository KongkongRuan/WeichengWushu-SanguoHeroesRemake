/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.midlet.MIDlet
 */
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

public class CMidlet
extends MIDlet {
    public static CMidlet a;
    public a a1000;

    public CMidlet() {
        Object object = a;
        if (object == null) {
            a = this;
            this.a1000 = object;
            object = Display.getDisplay((MIDlet)this);
            a a2 = this.a1000;
            object.setCurrent((Displayable)a2);
            a2 = this.a1000;
            super((Runnable)a2);
            ((Thread)object).start();
        }
    }

    public static void a() {
        a.destroyApp(true);
        a.notifyDestroyed();
        a = null;
    }

    public void destroyApp(boolean bl) {
    }

    public void pauseApp() {
    }

    public void startApp() {
    }
}

