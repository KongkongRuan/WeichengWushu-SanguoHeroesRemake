/*
 * Decompiled with CFR 0.152.
 */
package com.netmite.util;

import com.netmite.util.Debug;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaUtils {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String dumpObject(Object object) {
        int n = 1;
        StringBuffer stringBuffer = new StringBuffer();
        Object object2 = "{";
        stringBuffer.append((String)object2);
        Class<?> clazz = object.getClass();
        block2: while (true) {
            if (clazz == null) {
                stringBuffer.append("}");
                return stringBuffer.toString();
            }
            Field[] fieldArray = clazz.getDeclaredFields();
            int n2 = 0;
            while (true) {
                int n3;
                if (n2 >= (n3 = fieldArray.length)) {
                    clazz = clazz.getSuperclass();
                    continue block2;
                }
                n3 = stringBuffer.length();
                if (n3 > n) {
                    object2 = ",";
                    stringBuffer.append((String)object2);
                }
                fieldArray[n2].setAccessible(n != 0);
                object2 = fieldArray[n2].getName();
                stringBuffer.append((String)object2);
                object2 = "=";
                stringBuffer.append((String)object2);
                try {
                    object2 = fieldArray[n2];
                    object2 = ((Field)object2).get(object);
                    stringBuffer.append(object2);
                }
                catch (IllegalAccessException illegalAccessException) {}
                ++n2;
            }
            break;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object getField(Object object, String string) {
        Field field;
        Object object2 = null;
        Class<?> clazz = object.getClass();
        try {
            field = clazz.getField(string);
        }
        catch (Exception exception) {
            Debug.debug(exception);
            return object2;
        }
        return field.get(object);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object invokeAPIByMethodName(String string, Class clazz, Object object, Class clazz2, Object object2) {
        Object[] objectArray;
        Method method;
        Class[] classArray;
        int n = 1;
        String string2 = ",";
        Class<JavaUtils> clazz3 = JavaUtils.class;
        StringBuilder stringBuilder = new StringBuilder("invokeAPIByMethodName(");
        String string3 = stringBuilder.append(string).append(string2).append(clazz).append(string2).append(object).append(string2).append(clazz2).append(string2).append(object2).toString();
        Debug.debug(clazz3, string3);
        if (clazz2 == null) {
            classArray = new Class[]{};
        } else {
            classArray = new Class[n];
            classArray[0] = clazz2;
        }
        try {
            method = clazz.getMethod(string, classArray);
            if (clazz2 == null) {
                boolean bl = false;
                clazz3 = null;
                objectArray = new Object[]{};
                return method.invoke(object, objectArray);
            }
        }
        catch (Exception exception) {
            Debug.debug(exception);
            throw exception;
        }
        int n2 = 1;
        {
            objectArray = new Object[n2];
            n2 = 0;
            clazz3 = null;
            objectArray[0] = object2;
            return method.invoke(object, objectArray);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object invokeAPIByMethodNameCatch(String string, Class clazz, Object object, Class clazz2, Object object2) {
        Object object3 = null;
        try {
            return JavaUtils.invokeAPIByMethodName(string, clazz, object, clazz2, object2);
        }
        catch (RuntimeException runtimeException) {
            Debug.debug(runtimeException);
            throw runtimeException;
        }
        catch (Exception exception) {
            Debug.debug(exception);
            return object3;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object invokeAPIByMethodNameCatch2(String string, Class clazz, Object object, Class[] classArray, Object[] objectArray) {
        Object object2 = null;
        Method method = clazz.getMethod(string, classArray);
        try {
            return method.invoke(object, objectArray);
        }
        catch (RuntimeException runtimeException) {
            Debug.debug(runtimeException);
            throw runtimeException;
        }
        catch (Exception exception) {
            Debug.debug(exception);
            return object2;
        }
    }
}

