package tracker;

import tracker.menu.Menu;

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
        StartUI ui = new StartUI(new ConsoleInput(), new Tracker());
        ui.init();
    }

    /**
     * Initializes the menu and dispatches user commands until exit.
     */
    public void init() {
        Menu menu = new Menu(input, tracker);
        do {
            menu.show();
            String selection = input.request("Select an action: ");
            int key = Integer.parseInt(selection.trim());
            menu.select(key);
        } while (!this.input.request("Exit? [y/n]: ").equalsIgnoreCase("y"));
    }

}
