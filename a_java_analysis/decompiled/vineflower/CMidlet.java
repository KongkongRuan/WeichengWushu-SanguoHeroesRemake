import com.netmite.andme.MIDletThread;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class CMidlet extends MIDlet {
   public static CMidlet a;
   public a a1000;

   public CMidlet() {
      CMidlet var1 = a;
      if (var1 == null) {
         a = this;
         a var3 = new a();
         this.a1000 = var3;
         Display var4 = Display.getDisplay(this);
         a var2 = this.a1000;
         var4.setCurrent(var2);
         var2 = this.a1000;
         MIDletThread var5 = new MIDletThread(var2);
         var5.start();
      }
   }

   public static void a() {
      a.destroyApp(true);
      a.notifyDestroyed();
      a = null;
   }

   public void destroyApp(boolean var1) {
   }

   public void pauseApp() {
   }

   public void startApp() {
   }
}
