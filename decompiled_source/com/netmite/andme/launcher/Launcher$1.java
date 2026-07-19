/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.netmite.andme.launcher;

import android.content.DialogInterface;
import com.netmite.andme.launcher.Launcher;

class Launcher$1
implements DialogInterface.OnClickListener {
    final /* synthetic */ Launcher this$0;

    Launcher$1(Launcher launcher) {
        this.this$0 = launcher;
    }

    public void onClick(DialogInterface dialogInterface, int n) {
        this.this$0.startGetRunner(n);
        this.this$0.finishAndKill();
    }
}

