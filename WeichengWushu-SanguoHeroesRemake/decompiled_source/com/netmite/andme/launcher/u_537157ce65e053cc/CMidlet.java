/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.netmite.andme.launcher.u_537157ce65e053cc;

import android.os.Bundle;
import com.netmite.andme.launcher.Launcher2;

public class CMidlet
extends Launcher2 {
    public void onCreate(Bundle bundle) {
        String string = "CMidlet";
        this.launchinpackageprocess = false;
        this.setParameter("launcher_midleturl", "/data/test/2.0/upload/wcwszsgqypjb.jar");
        this.setParameter("launcherpackagename", "com.netmite.andme.launcher.u_537157ce65e053cc");
        this.setParameter("launcherclassname", string);
        this.setMidletInfo("http://www.netmite.com/android/srv/2.0/upload/wcwszsgqypjb.jar", 1, "\\u5371\\u57ce\\u65e0\\u53cc", "i64x64.png", string);
        super.onCreate(bundle);
    }
}

