package tracker.menu;

import tracker.Input;
import tracker.Item;
import tracker.Tracker;

/**
 * Implementation of a simple user menu selector for the Tracker system.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class Menu {
    private final Input input;
    private final Tracker tracker;
    private final UserAction[] actions = {
            new AddItem(),
            new ShowAll(),
            new EditItem(),
            new DeleteItem(),
            new FindItemById(),
            new FindItemsByName()
    };

    /**
     * Creates a menu with defined input and tracker.
     *
     * @param input   Input system to work with user input.
     * @param tracker Tracker object to operate on.
     */
    public Menu(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Activates a menu item by its index.
     *
     * @param key index of the selected item.
     */
    public void select(int key) throws InvalidInputException {
        UserAction selection = null;
        for (UserAction action : this.actions) {
            if (action != null && action.getKey() == key) {
                selection = action;
                break;
            }
        }
        if (selection != null) {
            selection.execute(input, tracker);
        } else {
            throw new InvalidInputException("Invalid selection");
        }
    }

    /**
     * Print start menu, so the user can select an action.
     */
    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    /**
     * Returns an array of all possible actions for this menu.
     *
     * @return an array of all possible actions.
     */
    public UserAction[] getActions() {
        return actions;
    }

    private static class AddItem implements UserAction {
        @Override
        public int getKey() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.requestString("Enter item name: ");
            String description = input.requestString("Enter item description: ");
            Item item = new Item(name, description);
            tracker.add(item);
            System.out.println(item);
        }

        @Override
        public String info() {
            return String.format("%2d. %s", getKey(), "Add item to the tracker.");
        }
    }

    private static class ShowAll implements UserAction {
        @Override
        public int getKey() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(tracker.getAllAsString());
        }

        @Override
        public String info() {
            return String.format("%2d. %s", getKey(), "Show all items.");
        }
    }

    private static class EditItem implements UserAction {
        @Override
        public int getKey() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.requestString("Enter item ID: ");
            Item oldItem = tracker.findById(id);
            if (oldItem == null) {
                System.out.println("Item ID not found.");
            } else {
                System.out.println(oldItem);
                String name = input.requestString("Enter newItem name: ");
                String description = input.requestString("Enter newItem description: ");
                String comments = input.requestString("Enter newItem comments: ");
                Item newItem = new Item(name, description);
                newItem.setComments(comments);
                tracker.replace(id, newItem);
                System.out.println(newItem);
            }
        }

        @Override
        public String info() {
            return String.format("%2d. %s", getKey(), "Edit item.");
        }
    }

    private static class DeleteItem implements UserAction {
        @Override
        public int getKey() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.requestString("Enter item ID: ");
            Item item = tracker.findById(id);
            System.out.println(tracker.delete(id) ? "Item removed." : "Item ID not found.");
        }

        @Override
        public String info() {
            return String.format("%2d. %s", getKey(), "Delete item.");
        }
    }

    private static class FindItemById implements UserAction {
        @Override
        public int getKey() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.requestString("Enter item ID: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Item ID not found.");
            } else {
                System.out.println(item);
            }
        }

        @Override
        public String info() {
            return String.format("%2d. %s", getKey(), "Find item by ID.");
        }
    }

    private static class FindItemsByName implements UserAction {
        @Override
        public int getKey() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.requestString("New item(s) name: ");
            Item[] items = tracker.findAllByName(name);
            if (items[0] == null) {
                System.out.println("Item(s) not found.");
            } else {
                int i = 0;
                while (items[i] != null) {
                    System.out.println(items[i++]);
                }
            }
        }

        @Override
        public String info() {
            return String.format("%2d. %s", getKey(), "Find item(s) by name.");
        }
    }

}