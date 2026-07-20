import com.netmite.andme.MIDletThread;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

// 
// Decompiled by Procyon v0.6.0
// 

public class CMidlet extends MIDlet
{
    public static CMidlet a;
    public a a1000;
    
    public CMidlet() {
        if (CMidlet.a == null) {
            CMidlet.a = this;
            this.a1000 = new a();
            Display.getDisplay((MIDlet)this).setCurrent((Displayable)this.a1000);
            new MIDletThread(this.a1000).start();
        }
    }
    
    public static void a() {
        CMidlet.a.destroyApp(true);
        CMidlet.a.notifyDestroyed();
        CMidlet.a = null;
    }
    
    public void destroyApp(final boolean b) {
    }
    
    public void pauseApp() {
    }
    
    public void startApp() {
    }
}
