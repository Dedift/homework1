package com.company.homeworks.homework11.Threads;

import com.company.homeworks.homework11.Dump;

public class FactoryThread extends Thread {

    private static final int COUNT_NIGHTS = 100;
    private Dump dump;

    public FactoryThread(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT_NIGHTS; i++) {
            dump.addDetails();
        }
    }
}
