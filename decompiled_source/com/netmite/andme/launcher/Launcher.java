/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Process
 */
package com.netmite.andme.launcher;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.netmite.andme.launcher.Launcher$1;
import com.netmite.andme.launcher.Launcher$2;
import com.netmite.util.Debug;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Launcher
extends Activity {
    Intent intent;
    String midletclass;
    String midleticon;
    String midletname;
    int midletnum;
    String midleturl;
    HashMap parameters;
    Bundle savedInstanceState;

    public Launcher() {
        HashMap hashMap;
        String string = "";
        this.parameters = hashMap = new HashMap();
        this.midletnum = 1;
        this.midleturl = string;
        this.midletname = "Midlet";
        this.midleticon = string;
        this.midletclass = string;
        this.parameters.put("launcher_installer_title", "NOTE");
        this.parameters.put("launcher_installer_installmsg", "This application requires J2ME Runner.Please download J2ME Runner First (Required only the very first time).");
        this.parameters.put("launcher_installer_upgrademsg", "J2ME Runner version [{versionCode}/{versionName}] too old to run this Application.Please upgrade J2ME Runner.");
        this.parameters.put("launcher_installer_url-1", "http://www.netmite.com/android/andme_signed.apk");
        this.parameters.put("launcher_installer_buttontext-1", "Get from Netmite (Suggested)");
        this.parameters.put("launcher_installer_url-2", "market://search?q=pname:com.netmite.andme");
        this.parameters.put("launcher_installer_buttontext-2", "Get from Android Market");
    }

    void downloadJ2MERunner(String string) {
        int[] nArray;
        Launcher$1 launcher$1 = new Launcher$1(this);
        Launcher$2 launcher$2 = new Launcher$2(this);
        Object object = new AlertDialog.Builder((Context)this);
        String string2 = this.getParameter("launcher_installer_title");
        object = object.setTitle((CharSequence)string2).setOnCancelListener((DialogInterface.OnCancelListener)launcher$2);
        AlertDialog.Builder builder = object.setMessage((CharSequence)string);
        AlertDialog alertDialog = builder.create();
        int n = 3;
        int[] nArray2 = nArray = new int[n];
        nArray[0] = -1;
        nArray2[1] = -2;
        nArray2[2] = -3;
        int n2 = 0;
        while (true) {
            if (n2 >= (n = nArray.length)) {
                alertDialog.show();
                return;
            }
            int n3 = nArray[n2];
            object = new StringBuilder("launcher_installer_buttontext");
            String string3 = ((StringBuilder)object).append(n3).toString();
            String string4 = this.getParameter(string3);
            object = new StringBuilder("key=");
            object = ((StringBuilder)object).append(string3).toString();
            Debug.debug((Object)this, object);
            string2 = "text=";
            object = new StringBuilder(string2);
            object = ((StringBuilder)object).append(string4).toString();
            Debug.debug((Object)this, object);
            if (string4 != null) {
                alertDialog.setButton(n3, (CharSequence)string4, (DialogInterface.OnClickListener)launcher$1);
            }
            ++n2;
        }
    }

    public void finishAndKill() {
        this.finish();
        Process.killProcess((int)Process.myPid());
    }

    public String getParameter(String string) {
        return (String)this.parameters.get(string);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    void launch(Bundle bundle) {
        try {
            this.startRunner(bundle);
            this.finish();
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            Debug.debug((Object)activityNotFoundException);
            String string = "launcher_installer_installmsg";
            String string2 = this.getParameter(string);
            this.downloadJ2MERunner(string2);
            return;
        }
        catch (Exception exception) {
            Debug.debug(exception);
            return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.savedInstanceState = bundle;
        this.getIntent().getExtras();
        this.launch(bundle);
    }

    public void prepareIntent() {
        Object object = new Intent();
        this.intent = object;
        this.intent.setAction("android.intent.action.MAIN");
        this.intent.addCategory("android.intent.category.LAUNCHER");
        this.intent.setClassName("com.netmite.andme", "com.netmite.andme.MIDletRunner");
        String string = this.getPackageCodePath();
        Uri uri = Uri.parse((String)string);
        this.intent.setData(uri);
        String string2 = "application/vnd.android.package-archive";
        this.intent.setType(string2);
        object = this.intent;
        String string3 = this.midleturl;
        object.putExtra("midleturl", string3);
        object = this.intent;
        Object object2 = "midletapkpath";
        object.putExtra((String)object2, string);
        object = this.midletclass;
        if (object != null) {
            object = this.intent;
            object2 = "midletclass";
            string3 = this.midletclass;
            object.putExtra((String)object2, string3);
        }
        Set set = this.parameters.keySet();
        object = new StringBuilder("parameters.size=");
        object2 = this.parameters;
        int n = ((HashMap)object2).size();
        object = ((StringBuilder)object).append(n).toString();
        Debug.debug(object);
        Iterator iterator = set.iterator();
        boolean bl;
        while (bl = iterator.hasNext()) {
            String string4 = (String)iterator.next();
            String string5 = (String)this.parameters.get(string4);
            object = new StringBuilder("   (");
            object = ((StringBuilder)object).append(string4).append(",").append(string5);
            object2 = ")";
            Debug.debug(((StringBuilder)object).append((String)object2).toString());
            object = this.intent;
            object.putExtra(string4, string5);
        }
        return;
    }

    public void setMidletInfo(String string, int n, String string2, String string3, String string4) {
        this.midleturl = string;
        this.midletnum = n;
        this.midletname = string2;
        this.midleticon = string3;
        this.midletclass = string4;
    }

    public void setParameter(String string, String string2) {
        this.parameters.put(string, string2);
    }

    public void startGetRunner(int n) {
        Object object = new Intent("android.intent.action.VIEW");
        this.intent = object;
        object = new StringBuilder("launcher_installer_url");
        object = ((StringBuilder)object).append(n).toString();
        Uri uri = Uri.parse((String)this.getParameter((String)object));
        this.intent.setData(uri);
        object = this.intent;
        this.startActivity((Intent)object);
    }

    void startRunner(Bundle bundle) {
        this.prepareIntent();
        Intent intent = this.intent;
        this.startActivity(intent);
    }
}

