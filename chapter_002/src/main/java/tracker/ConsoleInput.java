package tracker;

import tracker.menu.MenuOutException;

import java.util.List;
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
    public String requestString(String prompt) {
        System.out.print(prompt);
        scan.reset();
        return scan.nextLine();
    }

    /**
     * Requests an integer number and checks that input belongs to the range.
     *
     * @param prompt message to display to the user.
     * @param range  determines valid entry options.
     * @return user-entered value.
     * @throws MenuOutException if election is not contained in the range.
     */
    public int requestInt(String prompt, List<Integer> range) throws MenuOutException {
        int result = Integer.parseInt(requestString(prompt));
        if (!range.contains(result)) {
            throw new MenuOutException(String.format("You selection must be one of: %s.", range));
        }
        return result;
    }

}
