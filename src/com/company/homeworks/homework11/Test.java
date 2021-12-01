package com.company.homeworks.homework11;

import com.company.homeworks.homework11.Threads.DayThread;
import com.company.homeworks.homework11.Threads.FactoryThread;
import com.company.homeworks.homework11.Threads.ServantThread;

public class Test {

    public static void main(String[] args) {
        Dump dump = new Dump();
        ServantThread firstScientist = new ServantThread(dump);
        ServantThread secondScientist = new ServantThread(dump);
        FactoryThread factory = new FactoryThread(dump);
        DayThread dayTime = new DayThread(dump);

        dayTime.start();
        firstScientist.start();
        secondScientist.start();
        factory.start();

        try {
            dayTime.join();
            firstScientist.join();
            secondScientist.join();
            factory.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (firstScientist.getNumberOfRobotsCreating() > secondScientist.getNumberOfRobotsCreating()) {
                System.out.println("Выйграл первый ученый, собрав " + firstScientist.getNumberOfRobotsCreating() + " роботов!");
            } else if (firstScientist.getNumberOfRobotsCreating() < secondScientist.getNumberOfRobotsCreating()){
                System.out.println("Выйграл второй ученый, собрав " + secondScientist.getNumberOfRobotsCreating() + " роботов!");
            } else {
            System.out.println("Ничья, оба собрали " + secondScientist.getNumberOfRobotsCreating() + " роботов!");
        }
    }
}
