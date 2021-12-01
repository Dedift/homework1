package com.company.homeworks.homework11.Threads;

import com.company.homeworks.homework11.Detail;
import com.company.homeworks.homework11.Dump;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServantThread extends Thread {

    private static final int COUNT_DETAILS_FOR_CREATING_ROBOT = 8;
    private static final int MAX_COUNT_ROBOTS = 50;
    private static final int COUNT_NIGHTS = 100;
    private Dump dump;
    private Map<Detail, Integer> warehouseOfDetails;

    public ServantThread(Dump dump) {
        this.dump = dump;
        this.warehouseOfDetails = new HashMap<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT_NIGHTS; i++) {
            for (Detail detail : dump.getDetails()) {
                warehouseOfDetails.put(detail, getNumberDetailsInWarehouse(detail) + 1);
            }
        }
    }

    public int getNumberDetailsInWarehouse(Detail anyDetail) {
        if (Objects.nonNull(anyDetail) && warehouseOfDetails.containsKey(anyDetail)) {
            return warehouseOfDetails.get(anyDetail);
        }
        return 0;
    }

    public int getNumberOfRobotsCreating(){
        int NumberOfRobotsCreating = MAX_COUNT_ROBOTS;
        if (warehouseOfDetails.keySet().size() == COUNT_DETAILS_FOR_CREATING_ROBOT) {
            for (Integer numberDetailsInWarehouse : warehouseOfDetails.values()){
                if (numberDetailsInWarehouse < NumberOfRobotsCreating) {
                    NumberOfRobotsCreating = numberDetailsInWarehouse;
                }
            }
            return NumberOfRobotsCreating;
        } else {
            return 0;
        }
    }
}
