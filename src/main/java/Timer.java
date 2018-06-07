import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {

    private int second;
    private String name;
    private boolean isAlive;
    private static int timerCount = 0;
    private final int threadId = ++timerCount;

    public Timer(String name) {
        this.name = name;
        this.second = 0;
        this.isAlive = true;
    }

    public Timer(String name, int second) {
        this.name = name;
        this.second = second;
        this.isAlive = true;
    }

    public void run() {
        try {
            while(isAlive) {
                TimeUnit.SECONDS.sleep(1);
                second++;

            }
        } catch(InterruptedException e) {
            return;
        }
    }

    public boolean stop() {
        isAlive = false;
        return isAlive;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Thread id: " + threadId + " Second: " + second;
    }
}
