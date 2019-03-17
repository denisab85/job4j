package tracker;

import tracker.menu.InvalidInputException;
import tracker.menu.Menu;
import tracker.menu.UserAction;

import java.util.ArrayList;
import java.util.List;

/**
 * CLI for the Issue tracker.
 * Provides UI to add, remove, edit or search items using different criteria.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private final Input input;
    private final Tracker tracker;

    /**
     * Creates a UI with defined Tracker and Input system.
     *
     * @param input   Input system to work with user input.
     * @param tracker Tracker object to operate on.
     */
    public StartUI(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * Entry point to the program.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        StartUI ui = new StartUI(new ValidateInput(), new Tracker());
        ui.init();
    }

    /**
     * Initializes the menu and dispatches user commands until exit.
     */
    public void init() {
        Menu menu = new Menu(input, tracker);
        boolean exit = false;
        List<Integer> range = new ArrayList<>();
        for (UserAction action : menu.getActions()) {
            range.add(action.getKey());
        }
        do {
            menu.show();
            try {
                int key = input.requestInt("Select an action: ", range);
                menu.select(key);
                exit = this.input.requestString("Exit? [y/n]: ").equalsIgnoreCase("y");
            } catch (InvalidInputException e) {
                System.out.println(e.getLocalizedMessage());
            }
        } while (!exit);
    }

}
