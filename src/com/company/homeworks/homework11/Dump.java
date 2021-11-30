package com.company.homeworks.homework11;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dump {

    public static final int INITIAL_NUMBER_DETAILS = 20;
    private Queue<Detail> detailsDump;
    private Lock lock = new ReentrantLock();
    private Condition Condition = lock.newCondition();


    public Dump() {
        detailsDump = new LinkedList<>();
        for (int i = 0; i < INITIAL_NUMBER_DETAILS; i++) {
            detailsDump.add(new Detail());
        }
    }

    public Set<Detail> getDetails() {
        lock.lock();
        int countGetDetails = countActionWithDetails();
        Set<Detail> detailSet = new HashSet<>();
        for (int j = 0; j < countGetDetails; j++) {
            detailSet.add(detailsDump.poll());
        }
        try {
            Condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return detailSet;
    }

    public void addDetails() {
        lock.lock();
        int countAddDetails = countActionWithDetails();
        for (int i = 0; i < countAddDetails; i++) {
            detailsDump.add(new Detail());
        }
        try {
            Condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public int countActionWithDetails() {
        int countDoWithDetails = (int) (Math.random() * 4 + 1);
        if (countDoWithDetails > detailsDump.size()) {
            countDoWithDetails = detailsDump.size();
        }
        return countDoWithDetails;
    }

    public void daytime() {
        lock.lock();
        Condition.signalAll();
        lock.unlock();
    }
}

