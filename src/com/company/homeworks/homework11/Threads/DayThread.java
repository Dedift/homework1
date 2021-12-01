package com.company.homeworks.homework11.Threads;

import com.company.homeworks.homework11.Dump;

public class DayThread extends Thread{

    private Dump dump;
    private static final int COUNT_NIGHTS = 100;
    private static final int LENGTH_OF_NIGHT = 100;

    public DayThread(Dump dump){
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT_NIGHTS; i++) {
            try {
                Thread.sleep(LENGTH_OF_NIGHT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dump.nightTime();
        }
    }
}
