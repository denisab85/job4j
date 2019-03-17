package tracker.menu;

/**
 * Thrown if a non-existing option was selected by the user.
 */
public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }

}
