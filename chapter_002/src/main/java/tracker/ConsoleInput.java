package tracker;

import tracker.menu.InvalidInputException;
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
     * Requests an integer number.
     *
     * @param prompt message to display to the user.
     * @return user-entered value.
     * @throws InvalidInputException if a non-integer value was entered.
     */
    @Override
    public int requestInt(String prompt) throws InvalidInputException {
        int result;
        try {
            result = Integer.parseInt(requestString(prompt));
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input. A number is expected.");
        }
        return result;
    }

    /**
     * Requests an integer number and checks that input belongs to the range.
     *
     * @param prompt message to display to the user.
     * @param range  determines valid entry options.
     * @return user-entered value.
     * @throws InvalidInputException if a non-integer value was entered.
     * @throws MenuOutException      if election is not contained in the range.
     */
    public int requestInt(String prompt, List<Integer> range) throws InvalidInputException, MenuOutException {
        int result = requestInt(prompt);
        if (!range.contains(result)) {
            throw new MenuOutException(String.format("You selection must be one of: %s.", range));
        }
        return result;
    }

}
