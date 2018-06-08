import models.ThreadsContainer;

import java.util.Scanner;

public class View {

    public String [] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nCommand: \n");
        String [] input = scanner.nextLine().split(" ");
        return input;
    }

    public void display(String message) {
        System.out.println(message);
    }

    public void display(Runnable runnable) {
        System.out.println(runnable);
    }

    public void display(ThreadsContainer container) {
        for(Object key : container.getContainer().keySet()) {
            display(container.get((String)key));
        }
    }


}
