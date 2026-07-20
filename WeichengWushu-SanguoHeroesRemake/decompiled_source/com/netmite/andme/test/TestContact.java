/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Process
 */
package com.netmite.andme.test;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.netmite.util.Debug;

public class TestContact {
    public TestContact() {
        int n = Process.myPid();
        StringBuilder stringBuilder = new StringBuilder("TestContact, pid=");
        Debug.debug(stringBuilder.append(n).toString());
    }

    public void testAddContact2(Context context) {
        StringBuilder stringBuilder = new StringBuilder("testAddContact2(");
        Debug.debug(stringBuilder.append(context).toString());
        Intent intent = new Intent();
        intent.setClassName("com.netmite.andme.launcher.pdapdemo", "com.netmite.andme.launcher.Launcher2");
        stringBuilder = new StringBuilder("intent=");
        Debug.debug(stringBuilder.append(intent).toString());
        context.startActivity(intent);
    }
}

