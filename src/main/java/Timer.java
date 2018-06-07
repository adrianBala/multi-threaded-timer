import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {

    private int second;
    private String name;
    private static int timerCount = 0;
    private final int threadId = ++timerCount;

    public Timer(String name) {
        this.name = name;
        second = 0;
    }

    public Timer(String name, int second) {
        this.name = name;
        this.second = second;
    }

    public void run() {
        try {
            while(true) {
                TimeUnit.SECONDS.sleep(1);
                second++;
                if(Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
        } catch(InterruptedException e) {

        }
    }

    @Override
    public String toString() {
        return "Name: " + name + " Thread id: " + threadId + " Second: " + second;
    }
}
