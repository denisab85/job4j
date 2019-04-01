package tracker;

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
    String request(String prompt);

}
