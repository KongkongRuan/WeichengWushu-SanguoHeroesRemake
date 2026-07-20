/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 */
package com.netmite.andme.launcher;

import android.content.DialogInterface;
import com.netmite.andme.launcher.Launcher;

class Launcher$2
implements DialogInterface.OnCancelListener {
    final /* synthetic */ Launcher this$0;

    Launcher$2(Launcher launcher) {
        this.this$0 = launcher;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.this$0.finish();
    }
}

