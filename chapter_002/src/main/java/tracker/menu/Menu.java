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

    public void select(int key) {
        for (UserAction action : this.actions) {
            if (action != null && action.getKey() == key) {
                action.execute(input, tracker);
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

    private static class AddItem implements UserAction {
        @Override
        public int getKey() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.request("Enter item name: ");
            String description = input.request("Enter item description: ");
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
            System.out.println(tracker);
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
            String id = input.request("Enter item ID: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Item ID not found.");
            } else {
                System.out.println(item);
                String name = input.request("Enter item name: ");
                String description = input.request("Enter item description: ");
                String comments = input.request("Enter item comments: ");
                item.setName(name);
                item.setDescription(description);
                item.setComments(comments);
                System.out.println(item);
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
            String id = input.request("Enter item ID: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Item ID not found.");
            } else {
                tracker.delete(id);
                System.out.println("Item removed.");
            }
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
            String id = input.request("Enter item ID: ");
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
            String name = input.request("New item(s) name: ");
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