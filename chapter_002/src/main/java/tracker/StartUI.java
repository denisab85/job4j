package tracker;

public class StartUI {

    private Input input;
    private Tracker tracker = new Tracker();
    private final String n = System.lineSeparator();

    private enum Action { ADD_NEW, SHOW_ALL, EDIT_ITEM, DELETE_ITEM, FIND_ITEM_BY_ID, FIND_ITEMS_BY_NAME, EXIT }

    public StartUI(Input input) {
        this.input = input;
    }

    public static void main(String[] args) {
        StartUI ui = new StartUI(new ConsoleInput());
        ui.init();
    }

    public void printMenu() {
        System.out.println("0. Add new Item"
                + n + "1. Show all items"
                + n + "2. Edit item"
                + n + "3. Delete item"
                + n + "4. Find item by Id"
                + n + "5. Find items by name"
                + n + "6. Exit Program"
        );
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            String selection = input.request("Select an action: ");
            Action action = Action.values()[Integer.parseInt(selection.trim())];
            System.out.println(action);
            switch (action) {
                case ADD_NEW:
                    addNewItem(input, tracker);
                    break;
                case SHOW_ALL:
                    showAll(tracker);
                    break;
                case EDIT_ITEM:
                    editItem(input, tracker);
                    break;
                case DELETE_ITEM:
                    deleteItem(input, tracker);
                    break;
                case FIND_ITEM_BY_ID:
                    findById(input, tracker);
                    break;
                case FIND_ITEMS_BY_NAME:
                    findByName(input, tracker);
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private static void showAll(Tracker tracker) {
        System.out.println(tracker);
    }

    private static void findByName(Input input, Tracker tracker) {
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

    private static void findById(Input input, Tracker tracker) {
        String id = input.request("Enter item ID: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Item ID not found.");
        } else {
            System.out.println(item);
        }
    }

    private static void deleteItem(Input input, Tracker tracker) {
        String id = input.request("Enter item ID: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Item ID not found.");
        } else {
            tracker.delete(id);
            System.out.println("Item removed.");
        }
    }

    private static void editItem(Input input, Tracker tracker) {
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

    private static void addNewItem(Input input, Tracker tracker) {
        String name = input.request("Enter item name: ");
        String description = input.request("Enter item description: ");
        Item item = new Item(name, description);
        tracker.add(item);
        System.out.println(item);
    }

}
