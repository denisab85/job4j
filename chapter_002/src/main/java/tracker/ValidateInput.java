package tracker;

import tracker.menu.InvalidInputException;
import tracker.menu.MenuOutException;

import java.util.List;

public class ValidateInput extends ConsoleInput {

    /**
     * Requests an integer number and ensures that the election is valid, i.e. is contained in the range.
     * If an invalid number is entered, the user will be asked to try again.
     *
     * @param prompt message to display to the user.
     * @param range  determines valid entry options.
     * @return user-entered value.
     */
    @Override
    public int requestInt(String prompt, List<Integer> range) {
        int result = 0;
        boolean valid = false;
        while (!valid) {
            try {
                result = super.requestInt(prompt, range);
                valid = true;
            } catch (InvalidInputException | MenuOutException e) {
                System.out.print(e.getLocalizedMessage());
                System.out.println(" Please try again.");
            }
        }
        return result;
    }

}
