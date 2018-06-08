import models.ThreadsContainer;

public class Controller {

    private ThreadsContainer threadsContainer;
    private View view;

    Controller() {
        threadsContainer = new ThreadsContainer();
        view = new View();
    }

    public void start() {
        int commandIndex = 0;
        String [] input;
        boolean isExit = false;
        while(!isExit) {
            input = view.getUserInput();
            switch(input[commandIndex].toLowerCase()) {
                case "start":
                    createThread(input);
                    break;
                case "check":
                    check(input);
                    break;
                case "stop":
                    stopTread(input);
                    break;
                case "exit":
                    isExit = true;
                    break;
                default:
                    view.display("Wrong command!");
            }
        }
        System.exit(0);
    }

    private void stopTread(String[] input) {
        int index = 1;
        if(input.length > 1 && threadsContainer.containsKey(input[index])) {
            threadsContainer.stop(input[index]);
        } else {
            view.display("I didn't find this thread");
        }
    }

    private void check(String[] input) {
        int nameIndex = 1;
        if(threadsContainer.isEmpty()) {
            view.display("No threads here");
        } else if(input.length == 1) {
            view.display(threadsContainer);
        } else if(threadsContainer.containsKey(input[nameIndex])) {
            view.display(threadsContainer.get(input[nameIndex]));
        } else {
            view.display("No threads here!");
        }
    }

    private void createThread(String[] input) {
        int indexThreadName = 1;
        if(input.length < 2) {
            view.display("You forgot write a name!");
        } else {
            threadsContainer.addThread(input[indexThreadName]);
        }
    }

}
