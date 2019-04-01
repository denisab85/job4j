package tracker;

import java.util.Scanner;

/**
 * An implementation of the Input interface to support CLI input by the user.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {

    private final Scanner scan = new Scanner(System.in);

    /**
     * Requests a string.
     *
     * @param prompt message to display to the user.
     * @return user-entered string.
     */
    @Override
    public String request(String prompt) {
        System.out.print(prompt);
        scan.reset();
        return scan.nextLine();
    }

}
