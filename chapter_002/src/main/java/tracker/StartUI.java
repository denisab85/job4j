package tracker;

import tracker.menu.Menu;
import tracker.menu.UserAction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * CLI for the Issue tracker.
 * Provides UI to add, remove, edit or search items using different criteria.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private final ValidateInput input;
    private final Tracker tracker;
    private final Consumer<String> output;

    /**
     * Creates a UI with defined Tracker and Input system.
     *
     * @param input   Input system to work with user input.
     * @param tracker Tracker object to operate on.
     */
    public StartUI(ValidateInput input, Tracker tracker, Consumer<String> output) {
        this.tracker = tracker;
        this.input = input;
        this.output = output;
    }

    /**
     * Entry point to the program.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        StartUI ui = new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println);
        ui.init();
    }

    /**
     * Initializes the menu and dispatches user commands until exit.
     */
    public void init() {
        Menu menu = new Menu(input, tracker, output);
        boolean exit;
        List<Integer> range = new ArrayList<>();
        for (UserAction action : menu.getActions()) {
            range.add(action.getKey());
        }
        do {
            menu.show();
            int key = input.requestInt("Select an action: ", range);
            menu.select(key);
            exit = this.input.requestString("Exit? [y/n]: ").equalsIgnoreCase("y");
        } while (!exit);
    }

}
