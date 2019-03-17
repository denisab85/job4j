package tracker;

import tracker.menu.InvalidInputException;

import java.util.List;

/**
 * User input interface to request data entry from the user.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public interface Input {

    /**
     * Requests a string.
     *
     * @param prompt message to display to the user.
     * @return user-entered string.
     */
    String requestString(String prompt);

    /**
     * Requests an integer number.
     *
     * @param prompt message to display to the user.
     * @return user-entered value.
     */
    int requestInt(String prompt) throws InvalidInputException;

    /**
     * Requests an integer number and ensures that the election is valid, i.e. is contained in the range.
     * If an invalid number is entered, the user will be asked to try again.
     *
     * @param prompt message to display to the user.
     * @param range  determines valid entry options.
     * @return user-entered value.
     */
    int requestInt(String prompt, List<Integer> range);
}
