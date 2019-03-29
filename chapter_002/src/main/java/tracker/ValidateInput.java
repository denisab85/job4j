package tracker;

import tracker.menu.MenuOutException;

import java.util.List;

public class ValidateInput implements Input {

    private final Input input;

    /**
     * Creates an instance of ValidateInput with defined input source.
     *
     * @param input input source to provide validation for.
     */
    public ValidateInput(Input input) {
        this.input = input;
    }


    /**
     * Requests a string.
     *
     * @param prompt message to display to the user.
     * @return user-entered string.
     */
    @Override
    public String requestString(String prompt) {
        return this.input.requestString(prompt);
    }

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
                result = this.input.requestInt(prompt, range);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. A number is expected.");
            } catch (MenuOutException e) {
                System.out.print(e.getLocalizedMessage());
            }
            if (!valid) {
                System.out.println(" Please try again.");
            }
        }
        return result;
    }

}
