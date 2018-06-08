import java.util.HashMap;
import java.util.Map;

public class ThreadsContainer {

    private static Map<String, Timer> container = new HashMap<>();

    public void addThread(String name) {
        if(container.containsKey(name)) {
            int seconds = container.get(name).getSecond();
            Timer timer = new Timer(name, seconds);
            container.put(name, timer);

        } else {
            Timer timer = new Timer(name);
            container.put(name, timer);
        }
    }

//    private void startNewThread(String name, Timer timer) {
//        Thread thread = new Thread(timer);
//        thread.start();
//        container.put(name, timer);
//    }

    public Map getContainer() {
        return container;
    }

    public Runnable get(String key) {
        return container.get(key);
    }

    public boolean containsKey(String key) {
        return container.containsKey(key);
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public void stop(String key) {
        Timer timer = container.get(key);
        timer.stop();
    }
}

