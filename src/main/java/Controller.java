import java.util.Arrays;
import java.util.Scanner;

public class Controller {

    public static void start() {
        View view = new View();
        String [] input;
        boolean isExit = false;
        while(!isExit) {
            input = view.getUserInput();
            switch(input[0].toLowerCase()) {
                case "start":
                    System.out.println("start");
                    break;
                case "check":
                    System.out.println("check");
                    break;
                case "stop":
                    System.out.println("stop");
                    break;
                case "exit":
                    isExit = true;
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }

    }


}
