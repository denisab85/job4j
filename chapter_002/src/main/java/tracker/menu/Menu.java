package tracker.menu;

import tracker.Item;
import tracker.Tracker;
import tracker.ValidateInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of a simple user menu selector for the Tracker system.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class Menu {
    private final ValidateInput input;
    private final Tracker tracker;
    private final List<UserAction> actions = new ArrayList<>(
            Arrays.asList(
                    new AddItem(0, "Add item to the tracker."),
                    new ShowAll(1, "Show all items."),
                    new EditItem(2, "Edit item."),
                    new DeleteItem(3, "Delete item."),
                    new FindItemById(4, "Find item by ID."),
                    new FindItemsByName(5, "Find item(s) by name.")
            )
    );

    /**
     * Creates a menu with defined input and tracker.
     *
     * @param input   Input system to work with user input.
     * @param tracker Tracker object to operate on.
     */
    public Menu(ValidateInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Activates a menu item by its index.
     *
     * @param key index of the selected item.
     */
    public void select(int key) {
        for (UserAction action : this.actions) {
            if (action != null && action.getKey() == key) {
                action.execute(input, tracker);
                break;
            }
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
    public List<UserAction> getActions() {
        return actions;
    }

    private static class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(ValidateInput input, Tracker tracker) {
            String name = input.requestString("Enter item name: ");
            String description = input.requestString("Enter item description: ");
            Item item = new Item(name, description);
            tracker.add(item);
            System.out.println(item);
        }
    }

    private static class ShowAll extends BaseAction {

        public ShowAll(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(ValidateInput input, Tracker tracker) {
            System.out.println(tracker.getAllAsString());
        }
    }

    private static class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(ValidateInput input, Tracker tracker) {
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
    }

    private static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(ValidateInput input, Tracker tracker) {
            String id = input.requestString("Enter item ID: ");
            System.out.println(tracker.delete(id) ? "Item removed." : "Item ID not found.");
        }
    }

    private static class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(ValidateInput input, Tracker tracker) {
            String id = input.requestString("Enter item ID: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Item ID not found.");
            } else {
                System.out.println(item);
            }
        }
    }

    private static class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(ValidateInput input, Tracker tracker) {
            String name = input.requestString("New item(s) name: ");
            List<Item> items = tracker.findAllByName(name);
            if (items.isEmpty()) {
                System.out.println("Item(s) not found.");
            } else {
                for (Item item : items) {
                    System.out.println(item);
                }
            }
        }
    }

}