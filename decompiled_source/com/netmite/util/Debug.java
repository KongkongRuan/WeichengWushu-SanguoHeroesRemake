/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.netmite.util;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

public class Debug {
    private static final String TAG = "@@@ERR";
    static Hashtable aligns;
    static StringBuffer buffer;
    static Vector debugMatchVector;
    static int debugMatchVectorlen;
    static String debugThread;
    public static boolean debugon;
    static PrintStream outstream;

    static {
        Hashtable hashtable;
        debugon = true;
        debugThread = null;
        debugMatchVector = null;
        debugMatchVectorlen = 0;
        buffer = null;
        aligns = hashtable = new Hashtable();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int addMatchVector(Object object) {
        Object object2;
        boolean bl;
        Serializable serializable = debugMatchVector;
        if (serializable == null) {
            serializable = new Vector();
            debugMatchVector = serializable;
        }
        if (bl = object instanceof Class) {
            object = (Class)object;
            object2 = ((Class)object).getName();
        } else {
            bl = object instanceof String;
            if (bl) {
                Object object3 = object;
                object2 = object3 = (String)object;
            } else {
                serializable = object.getClass();
                object2 = ((Class)serializable).getName();
            }
        }
        if (!(bl = ((Vector)(serializable = debugMatchVector)).contains(object2))) {
            serializable = debugMatchVector;
            ((Vector)serializable).add(object2);
        }
        debugMatchVectorlen = debugMatchVector.size();
        return debugMatchVectorlen;
    }

    public static void clearMatchVector() {
        Vector vector = debugMatchVector;
        if (vector != null) {
            vector = debugMatchVector;
            vector.clear();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void debug(int n) {
        int n2;
        String string;
        short s;
        boolean bl = debugon;
        if (!bl) {
            return;
        }
        Object object = aligns;
        Thread thread = Thread.currentThread();
        String string2 = (String)((Hashtable)object).get(thread);
        if (string2 == null) {
            string2 = "";
        }
        if ((s = (short)n) > 0) {
            string = String.valueOf(string2);
            object = new StringBuilder(string);
            string = " ";
            object = ((StringBuilder)object).append(string);
            string2 = ((StringBuilder)object).toString();
        }
        object = new StringBuilder("[");
        string = thread.getName();
        object = ((StringBuilder)object).append(string);
        string = "]:";
        object = ((StringBuilder)object).append(string).append(string2).append(s).toString();
        Debug.log(object);
        if (s < 0 && (n2 = string2.length()) > 0) {
            bl = false;
            object = null;
            int n3 = n2 - 1;
            string2 = string2.substring(0, n3);
        }
        object = aligns;
        ((Hashtable)object).put(thread, string2);
    }

    public static void debug(Object object) {
        Debug.debug(null, object);
    }

    /*
     * Handled impossible loop by adding 'first' condition
     * Enabled aggressive block sorting
     */
    public static void debug(Object object, Object object2) {
        String string;
        Object object3;
        String string2;
        Object object4;
        int n = debugon;
        if (n == 0 && (n = object2 instanceof Throwable) == 0) {
            return;
        }
        if (object2 == null) {
            object4 = "null";
            string2 = object4;
        } else {
            object4 = object2.toString();
            string2 = object4;
        }
        Object object5 = "";
        if (object != null) {
            n = object instanceof Class;
            if (n != 0) {
                object3 = object;
                object4 = object3 = (Class)object;
                object5 = ((Class)object3).getName();
            } else {
                n = object instanceof String;
                if (n != 0) {
                    object3 = object;
                    object5 = object3 = (String)object;
                } else {
                    object4 = object.getClass();
                    object5 = ((Class)object4).getName();
                }
            }
            n = 46;
            int n2 = ((String)object5).lastIndexOf(n);
            Object object6 = object5;
            if (n2 > 0) {
                n = n2 + 1;
                object6 = ((String)object5).substring(n);
            }
            string = String.valueOf(object6);
            object4 = new StringBuilder(string);
            string = "::";
            object4 = ((StringBuilder)object4).append(string).append(string2);
            string2 = ((StringBuilder)object4).toString();
        }
        boolean bl = true;
        while (true) {
            int n3;
            block18: {
                String string3;
                block15: {
                    block16: {
                        block17: {
                            block14: {
                                if (!bl || (bl = false)) break block14;
                                object4 = debugMatchVector;
                                if (object4 == null || object == null) break block15;
                                n3 = 0;
                            }
                            if (n3 >= (n = debugMatchVectorlen) || (n = (int)((string3 = (String)debugMatchVector.get(n3)).equals(object4 = "*") ? 1 : 0)) != 0) break block16;
                            object4 = null;
                            char c = string3.charAt(0);
                            if (c != (n = 126)) break block17;
                            object4 = string3.substring(1);
                            n = string2.indexOf((String)object4);
                            if (n < 0) break block18;
                            n3 = debugMatchVectorlen;
                            break block16;
                        }
                        n = ((String)object5).indexOf(string3);
                        if (n < 0) break block18;
                    }
                    if (n3 == (n = debugMatchVectorlen)) {
                        n = object2 instanceof Throwable;
                        if (n == 0) return;
                    }
                }
                if ((n = object2 instanceof Throwable) == 0) break;
                object3 = object2;
                object3 = (Throwable)object2;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                ((Throwable)object3).printStackTrace(printStream);
                printStream.close();
                byte[] byArray = byteArrayOutputStream.toByteArray();
                string3 = new String(byArray);
                string = String.valueOf(string2);
                object4 = new StringBuilder(string);
                object4 = ((StringBuilder)object4).append(string3);
                string2 = ((StringBuilder)object4).toString();
                Debug.log(string2);
                return;
            }
            ++n3;
        }
        n = debugon ? 1 : 0;
        if (n == 0) return;
        Debug.log(string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void flush() {
        StringBuffer stringBuffer;
        int n = 512;
        StringBuffer stringBuffer2 = buffer;
        if (stringBuffer2 != null) {
            StringBuffer stringBuffer3;
            int n2 = 0;
            char[] cArray = new char[n];
            while ((n2 = (stringBuffer3 = buffer).length()) > 0) {
                if (n2 > n) {
                    n2 = 512;
                }
                buffer.getChars(0, n2, cArray, 0);
                buffer.delete(0, n2);
                String string = TAG;
                String string2 = new String(cArray, 0, n2);
                Log.v((String)string, (String)string2);
            }
        }
        buffer = stringBuffer = new StringBuffer();
    }

    public static boolean isDebugOn() {
        return debugon;
    }

    public static void log(Object object) {
        Debug.log(null, object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void log(Object object, Object object2) {
        if (object2 == null) {
            return;
        }
        String string = object2.toString();
        String string2 = Thread.currentThread().getName();
        Object object3 = debugThread;
        if (object3 != null) {
            object3 = debugThread;
            int n = ((String)object3).indexOf(string2);
            if (n < 0) return;
        }
        object3 = new StringBuilder("[");
        object3 = ((StringBuilder)object3).append(string2);
        String string3 = "]:";
        string = ((StringBuilder)object3).append(string3).append(string).toString();
        object3 = outstream;
        if (object3 != null) {
            object3 = outstream;
            ((PrintStream)object3).println(string);
            return;
        }
        object3 = buffer;
        if (object3 != null) {
            buffer.append(string);
            object3 = buffer;
            char c = '\n';
            ((StringBuffer)object3).append(c);
            return;
        }
        object3 = TAG;
        Log.v((String)object3, (String)string);
    }

    public static void printStackTrace(Throwable throwable) {
        Debug.debug(throwable);
    }

    public static void println(String string) {
        Debug.debug(string);
    }

    public static void setDebug(boolean bl) {
        debugon = bl;
    }

    public static void setOut(PrintStream printStream) {
        outstream = printStream;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean toggle() {
        StringBuilder stringBuilder;
        boolean bl = debugon;
        if (bl) {
            bl = false;
            stringBuilder = null;
        } else {
            bl = true;
        }
        debugon = bl;
        stringBuilder = new StringBuilder("debugon=");
        boolean bl2 = debugon;
        Debug.log(stringBuilder.append(bl2).toString());
        return debugon;
    }
}

