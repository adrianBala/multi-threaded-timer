import java.util.Scanner;

public class View {

    public String [] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Command: \n");
        String [] input = scanner.nextLine().split(" ");
        return input;
    }
}
