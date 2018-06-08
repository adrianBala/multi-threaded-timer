package models;

import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {

    private int second;
    private String name;
    private static int timerCount = 0;
    private final int threadId = ++timerCount;
    private Thread threat;

    public Timer(String name) {
        this.name = name;
        this.second = 0;
        threat = new Thread(this);
        threat.start();
    }

    public Timer(String name, int second) {
        this.name = name;
        this.second = second;
        threat = new Thread(this);
        threat.start();
    }

    public void run() {
        try {
            while(!threat.isInterrupted()) {
                TimeUnit.SECONDS.sleep(1);
                second++;
            }
        } catch(InterruptedException e) {
            return;
        }
    }

    public void stop() {
        threat.interrupt();
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Thread id: " + threadId + " Second: " + second;
    }
}
