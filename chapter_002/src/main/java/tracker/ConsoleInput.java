package tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private final Scanner scan = new Scanner(System.in);

    @Override
    public String request(String prompt) {
        System.out.print(prompt);
        return scan.nextLine();
    }

}
