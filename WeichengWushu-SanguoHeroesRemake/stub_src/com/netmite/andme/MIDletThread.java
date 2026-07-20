package com.netmite.andme;

/**
 * Stub replacement for Netmite's MIDletThread.
 * The original class extends Thread and wraps a Runnable (the game canvas).
 * This stub provides the same functionality using standard Java threading.
 */
public class MIDletThread extends Thread {
    public MIDletThread(Runnable target) {
        super(target);
    }
}
