/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Process
 *  android.util.AttributeSet
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 */
package com.netmite.andme.launcher;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.netmite.andme.launcher.Launcher;
import com.netmite.util.Debug;
import com.netmite.util.JavaUtils;
import java.io.PrintStream;
import java.util.HashMap;

public class Launcher2
extends Launcher {
    Context andmecontext;
    ClassLoader clloader;
    public boolean launchinpackageprocess = false;
    Class m_runnerclass;
    Activity m_runnerobj;

    public Launcher2() {
        int n = Process.myPid();
        CharSequence charSequence = new StringBuilder("Launcher2, xpid=");
        charSequence = charSequence.append(n).toString();
        Debug.debug((Object)this, charSequence);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean checkRunnerVersion() {
        boolean bl = true;
        PackageManager packageManager = this.getPackageManager();
        Object object = "com.netmite.andme";
        CharSequence charSequence = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo((String)object, 0);
            object = this.parameters;
            charSequence = "launcher_runner_versioncoderequired";
            Object v = ((HashMap)object).get(charSequence);
            String string = (String)v;
            object = System.out;
            String string2 = "launcher_runner_runnerversioncoderequired=";
            charSequence = new StringBuilder(string2);
            charSequence = ((StringBuilder)charSequence).append(string);
            charSequence = ((StringBuilder)charSequence).toString();
            ((PrintStream)object).println((String)charSequence);
            if (string == null) return bl;
            try {
                int n = Integer.parseInt(string);
                object = System.out;
                string2 = "pkginfo.versionCode=";
                charSequence = new StringBuilder(string2);
                int n2 = packageInfo.versionCode;
                charSequence = ((StringBuilder)charSequence).append(n2);
                charSequence = ((StringBuilder)charSequence).toString();
                ((PrintStream)object).println((String)charSequence);
                int n3 = packageInfo.versionCode;
                if (n3 <= 0) return bl;
                n3 = packageInfo.versionCode;
                if (n3 >= n) return bl;
                object = "launcher_installer_upgrademsg";
                String string3 = this.getParameter((String)object);
                object = "{versionCode}";
                charSequence = new StringBuilder();
                n2 = packageInfo.versionCode;
                charSequence = ((StringBuilder)charSequence).append(n2);
                charSequence = ((StringBuilder)charSequence).toString();
                string3 = string3.replace((CharSequence)object, charSequence);
                object = "{versionName}";
                charSequence = new StringBuilder();
                string2 = packageInfo.versionName;
                charSequence = ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                string3 = string3.replace((CharSequence)object, charSequence);
                this.downloadJ2MERunner(string3);
                return false;
            }
            catch (NumberFormatException numberFormatException) {
                Debug.debug(numberFormatException);
                return bl;
            }
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Debug.debug((Object)nameNotFoundException);
            object = "launcher_installer_installmsg";
            String string = this.getParameter((String)object);
            this.downloadJ2MERunner(string);
            return false;
        }
    }

    public String getApkPath() {
        return this.getPackageCodePath();
    }

    public String getAppClass() {
        return this.midletclass;
    }

    public String getAppName() {
        return this.midletname;
    }

    public String getAppUrl() {
        return this.midleturl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Resources getResources() {
        Debug.debug((Object)this, "getResources()");
        Resources resources = null;
        Object object = this.andmecontext;
        if (object != null) {
            object = this.andmecontext;
            resources = object.getResources();
        } else {
            resources = super.getResources();
        }
        object = new StringBuilder("getResources()=");
        object = ((StringBuilder)object).append(resources).toString();
        Debug.debug((Object)this, object);
        return resources;
    }

    public Resources getResources2() {
        return super.getResources();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void launch(Bundle bundle) {
        CharSequence charSequence = "Launcher2.launch()";
        Debug.debug((Object)this, charSequence);
        Intent intent = this.getIntent();
        boolean bl = this.checkRunnerVersion();
        if (!bl) {
            return;
        }
        boolean bl2 = this.launchinpackageprocess;
        boolean bl3 = intent.hasCategory("android.intent.category.ALTERNATIVE");
        this.launchinpackageprocess = bl2 |= bl3;
        String string = "launchinpackageprocess=";
        charSequence = new StringBuilder(string);
        bl3 = this.launchinpackageprocess;
        charSequence = ((StringBuilder)charSequence).append(bl3).toString();
        Debug.debug((Object)this, charSequence);
        bl2 = this.launchinpackageprocess;
        if (bl2) {
            this.launch2(bundle);
            return;
        }
        super.launch(bundle);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void launch2(Bundle bundle) {
        Object object = "Launcher2.launch2(";
        Object object2 = new StringBuilder((String)object);
        object2 = ((StringBuilder)object2).append(bundle).toString();
        Debug.debug((Object)this, object2);
        String string = "com.netmite.andme";
        String string2 = "com.netmite.andme.MIDletRunner";
        int n = 3;
        try {
            object2 = this.createPackageContext(string, n);
        }
        catch (Exception exception) {
            Debug.debug(exception);
            this.finishAndKill();
            return;
        }
        this.andmecontext = object2;
        object = "andmecontext=";
        object2 = new StringBuilder((String)object);
        object = this.andmecontext;
        object2 = ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        Debug.debug((Object)this, object2);
        object2 = this.getClassLoader();
        this.clloader = object2;
        object = "my clloader=";
        object2 = new StringBuilder((String)object);
        object = this.clloader;
        object2 = ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        Debug.debug((Object)this, object2);
        object2 = this.andmecontext;
        object2 = object2.getClassLoader();
        object2 = this.clloader = object2;
        object2 = ((ClassLoader)object2).loadClass(string2);
        this.m_runnerclass = object2;
        object2 = this.m_runnerclass;
        object2 = ((Class)object2).newInstance();
        object2 = (Activity)object2;
        this.m_runnerobj = object2;
        object = "m_runnerobj=";
        object2 = new StringBuilder((String)object);
        object = this.m_runnerobj;
        object2 = ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        Debug.debug((Object)this, object2);
        object2 = "setContext";
        object = this.m_runnerclass;
        Activity activity = this.m_runnerobj;
        Class<Context> clazz = Context.class;
        Context context = this.andmecontext;
        JavaUtils.invokeAPIByMethodName((String)object2, (Class)object, activity, clazz, context);
        object2 = "setActivity";
        object = this.m_runnerclass;
        activity = this.m_runnerobj;
        clazz = Activity.class;
        JavaUtils.invokeAPIByMethodName((String)object2, (Class)object, activity, clazz, (Object)this);
        this.prepareIntent();
        object2 = "setIntent";
        object = this.m_runnerclass;
        activity = this.m_runnerobj;
        clazz = Intent.class;
        context = this.intent;
        JavaUtils.invokeAPIByMethodName((String)object2, (Class)object, activity, clazz, context);
        object2 = "before onCreate";
        Debug.debug((Object)this, object2);
        object2 = "onCreate";
        object = this.m_runnerclass;
        activity = this.m_runnerobj;
        clazz = Bundle.class;
        context = this.savedInstanceState;
        JavaUtils.invokeAPIByMethodName((String)object2, (Class)object, activity, clazz, context);
    }

    public void onActivityResult(int n, int n2, Intent intent) {
        int n3 = 3;
        int n4 = 2;
        int n5 = 1;
        Activity activity = null;
        String string = ",";
        Object object = new StringBuilder("onActivityResult(");
        object = ((StringBuilder)object).append(n).append(string).append(n2);
        Object object2 = ",";
        object = ((StringBuilder)object).append(string).append(intent).toString();
        Debug.debug((Object)this, object);
        object = this.m_runnerobj;
        if (object != null) {
            Class[] classArray = new Class[n3];
            classArray[0] = object = Integer.TYPE;
            object = Integer.TYPE;
            classArray[n5] = object;
            classArray[n4] = Intent.class;
            Object[] objectArray = new Object[n3];
            object = new Integer(n);
            objectArray[0] = object;
            object = new Integer(n2);
            objectArray[n5] = object;
            objectArray[n4] = intent;
            object = "onActivityResult";
            object2 = this.m_runnerclass;
            activity = this.m_runnerobj;
            JavaUtils.invokeAPIByMethodNameCatch2((String)object, (Class)object2, activity, classArray, objectArray);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        String string = "onConfigurationChanged(";
        CharSequence charSequence = new StringBuilder(string);
        charSequence = charSequence.append(configuration).toString();
        Debug.debug((Object)this, charSequence);
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = this.m_runnerobj;
            charSequence.onConfigurationChanged(configuration);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        String string = "onContextItemSelected(";
        CharSequence charSequence = new StringBuilder(string);
        charSequence = charSequence.append(menuItem).toString();
        Debug.debug((Object)this, charSequence);
        boolean bl = false;
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = this.m_runnerobj;
            bl = charSequence.onContextItemSelected(menuItem);
        }
        return bl;
    }

    public void onContextMenuClosed(Menu menu) {
        String string = "onContextMenuClosed(";
        CharSequence charSequence = new StringBuilder(string);
        charSequence = charSequence.append(menu).toString();
        Debug.debug((Object)this, charSequence);
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = this.m_runnerobj;
            charSequence.onContextMenuClosed(menu);
        }
    }

    public void onCreate(Bundle bundle) {
        Process.myPid();
        super.onCreate(bundle);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        String string = ",";
        CharSequence charSequence = new StringBuilder("onCreateContextMenu(");
        charSequence = charSequence.append(contextMenu).append(string).append(view).append(string).append(contextMenuInfo).toString();
        Debug.debug((Object)this, charSequence);
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = this.m_runnerobj;
            charSequence.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    public Dialog onCreateDialog(int n) {
        CharSequence charSequence = new StringBuilder("Launcher2, onCreateDialog(");
        charSequence = charSequence.append(n);
        Object object = ")";
        charSequence = charSequence.append((String)object).toString();
        Debug.debug((Object)this, charSequence);
        Dialog dialog = null;
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = "onCreateDialog";
            object = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            Class<Integer> clazz = Integer.TYPE;
            Integer n2 = new Integer(n);
            dialog = (Dialog)JavaUtils.invokeAPIByMethodNameCatch((String)charSequence, (Class)object, activity, clazz, n2);
        }
        return dialog;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        String string = "onCreateOptionsMenu(";
        CharSequence charSequence = new StringBuilder(string);
        charSequence = charSequence.append(menu).toString();
        Debug.debug((Object)this, charSequence);
        boolean bl = false;
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = this.m_runnerobj;
            bl = charSequence.onCreateOptionsMenu(menu);
        }
        return bl;
    }

    public View onCreateView(String string, Context context, AttributeSet attributeSet) {
        String string2 = ",";
        CharSequence charSequence = new StringBuilder("onCreateView(");
        charSequence = charSequence.append(string).append(string2).append(context).append(string2).append(attributeSet);
        String string3 = ")";
        charSequence = charSequence.append(string3).toString();
        Debug.debug((Object)this, charSequence);
        View view = null;
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = this.m_runnerobj;
            view = charSequence.onCreateView(string, context, attributeSet);
        }
        return view;
    }

    public void onDestroy() {
        Debug.debug((Object)this, "onDestroy()");
        super.onDestroy();
        Object object = this.m_runnerobj;
        if (object != null) {
            object = "onDestroy";
            Class clazz = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            JavaUtils.invokeAPIByMethodNameCatch((String)object, clazz, activity, null, null);
        }
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        CharSequence charSequence = new StringBuilder("onKeyDown(");
        charSequence = ((StringBuilder)charSequence).append(n).append(",").append(keyEvent);
        String string = ")";
        charSequence = ((StringBuilder)charSequence).append(string).toString();
        Debug.debug((Object)this, charSequence);
        boolean bl = false;
        charSequence = this.m_runnerobj;
        if (charSequence != null && !(bl = (charSequence = this.m_runnerobj).onKeyDown(n, keyEvent))) {
            bl = super.onKeyDown(n, keyEvent);
            string = "super.onKeyDown()=";
            charSequence = new StringBuilder(string);
            charSequence = ((StringBuilder)charSequence).append(bl).toString();
            Debug.debug((Object)this, charSequence);
        }
        return bl;
    }

    public boolean onKeyMultiple(int n, int n2, KeyEvent keyEvent) {
        String string = ",";
        CharSequence charSequence = new StringBuilder("onKeyMultiple(");
        charSequence = charSequence.append(n).append(string).append(n2).append(string).append(keyEvent);
        String string2 = ")";
        charSequence = charSequence.append(string2).toString();
        Debug.debug((Object)this, charSequence);
        boolean bl = false;
        charSequence = this.m_runnerobj;
        if (charSequence != null && !(bl = (charSequence = this.m_runnerobj).onKeyMultiple(n, n2, keyEvent))) {
            bl = super.onKeyMultiple(n, n2, keyEvent);
        }
        return bl;
    }

    public boolean onKeyUp(int n, KeyEvent keyEvent) {
        CharSequence charSequence = new StringBuilder("onKeyUp(");
        charSequence = ((StringBuilder)charSequence).append(n).append(",").append(keyEvent);
        String string = ")";
        charSequence = ((StringBuilder)charSequence).append(string).toString();
        Debug.debug((Object)this, charSequence);
        boolean bl = false;
        charSequence = this.m_runnerobj;
        if (charSequence != null && !(bl = (charSequence = this.m_runnerobj).onKeyUp(n, keyEvent))) {
            bl = super.onKeyUp(n, keyEvent);
            string = "super.onKeyUp()=";
            charSequence = new StringBuilder(string);
            charSequence = ((StringBuilder)charSequence).append(bl).toString();
            Debug.debug((Object)this, charSequence);
        }
        return bl;
    }

    public void onLowMemory() {
        Debug.debug((Object)this, "onLowMemory()");
        Activity activity = this.m_runnerobj;
        if (activity != null) {
            activity = this.m_runnerobj;
            activity.onLowMemory();
        }
    }

    public void onNewIntent(Intent intent) {
        Object object = "onNewIntent(";
        CharSequence charSequence = new StringBuilder((String)object);
        charSequence = charSequence.append(intent).toString();
        Debug.debug((Object)this, charSequence);
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = "onNewIntent";
            object = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            Class<Intent> clazz = Intent.class;
            JavaUtils.invokeAPIByMethodNameCatch((String)charSequence, (Class)object, activity, clazz, intent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String string = "onOptionsItemSelected(";
        CharSequence charSequence = new StringBuilder(string);
        charSequence = charSequence.append(menuItem).toString();
        Debug.debug((Object)this, charSequence);
        boolean bl = false;
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = this.m_runnerobj;
            bl = charSequence.onOptionsItemSelected(menuItem);
        }
        return bl;
    }

    public void onOptionsMenuClosed(Menu menu) {
        String string = "onOptionsMenuClosed(";
        CharSequence charSequence = new StringBuilder(string);
        charSequence = charSequence.append(menu).toString();
        Debug.debug((Object)this, charSequence);
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = this.m_runnerobj;
            charSequence.onOptionsMenuClosed(menu);
        }
    }

    public void onPause() {
        Debug.debug((Object)this, "onPause()");
        super.onPause();
        Object object = this.m_runnerobj;
        if (object != null) {
            object = "onPause";
            Class clazz = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            JavaUtils.invokeAPIByMethodNameCatch((String)object, clazz, activity, null, null);
        }
    }

    public void onPrepareDialog(int n, Dialog dialog) {
        int n2 = 2;
        int n3 = 1;
        Activity activity = null;
        Object object = new StringBuilder("onPrepareDialog(");
        object = ((StringBuilder)object).append(n);
        Object object2 = ",";
        object = ((StringBuilder)object).append((String)object2).append(dialog).toString();
        Debug.debug((Object)this, object);
        object = this.m_runnerobj;
        if (object != null) {
            Class[] classArray = new Class[n2];
            classArray[0] = object = Integer.TYPE;
            classArray[n3] = Dialog.class;
            Object[] objectArray = new Object[n2];
            objectArray[0] = object = new Integer(n);
            objectArray[n3] = dialog;
            object = "onPrepareDialog";
            object2 = this.m_runnerclass;
            activity = this.m_runnerobj;
            JavaUtils.invokeAPIByMethodNameCatch2((String)object, (Class)object2, activity, classArray, objectArray);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        String string = "onPrepareOptionsMenu(";
        CharSequence charSequence = new StringBuilder(string);
        charSequence = charSequence.append(menu).toString();
        Debug.debug((Object)this, charSequence);
        boolean bl = false;
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = this.m_runnerobj;
            bl = charSequence.onPrepareOptionsMenu(menu);
        }
        return bl;
    }

    public void onRestart() {
        Debug.debug((Object)this, "onRestart()");
        super.onRestart();
        Object object = this.m_runnerobj;
        if (object != null) {
            object = "onRestart";
            Class clazz = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            JavaUtils.invokeAPIByMethodNameCatch((String)object, clazz, activity, null, null);
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        Object object = "onRestoreInstanceState(";
        CharSequence charSequence = new StringBuilder((String)object);
        charSequence = charSequence.append(bundle).toString();
        Debug.debug((Object)this, charSequence);
        charSequence = this.m_runnerobj;
        if (charSequence != null) {
            charSequence = "onRestoreInstanceState";
            object = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            Class<Bundle> clazz = Bundle.class;
            JavaUtils.invokeAPIByMethodNameCatch((String)charSequence, (Class)object, activity, clazz, bundle);
        }
    }

    public void onResume() {
        Debug.debug((Object)this, "onResume()");
        super.onResume();
        Object object = this.m_runnerobj;
        if (object != null) {
            object = "onResume";
            Class clazz = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            JavaUtils.invokeAPIByMethodNameCatch((String)object, clazz, activity, null, null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Debug.debug((Object)this, "onSaveInstanceState()");
        Object object = this.m_runnerobj;
        if (object != null) {
            object = "onSaveInstanceState";
            Class clazz = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            Class<Bundle> clazz2 = Bundle.class;
            JavaUtils.invokeAPIByMethodNameCatch((String)object, clazz, activity, clazz2, bundle);
        }
    }

    public void onStart() {
        Debug.debug((Object)this, "onStart()");
        super.onStart();
        Object object = this.m_runnerobj;
        if (object != null) {
            object = "onStart";
            Class clazz = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            JavaUtils.invokeAPIByMethodNameCatch((String)object, clazz, activity, null, null);
        }
    }

    public void onStop() {
        Debug.debug((Object)this, "onStop()");
        super.onStop();
        Object object = this.m_runnerobj;
        if (object != null) {
            object = "onStop";
            Class clazz = this.m_runnerclass;
            Activity activity = this.m_runnerobj;
            JavaUtils.invokeAPIByMethodNameCatch((String)object, clazz, activity, null, null);
        }
    }
}

