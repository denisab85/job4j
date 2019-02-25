package tracker;

import java.util.Date;
import java.util.Random;

/**
 * Issue tracker. Contains issues, which are represented as items.
 * Items can be added, removed, replaced or searched using different criteria.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Array to store entered items.
     */
    private final Item[] items = new Item[100];

    private final Random rnd = new Random();

    /**
     * Array pointer to the next item.
     */
    private int position = 0;

    /**
     * Add an item to the storage.
     *
     * @param item new item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Generates a unique key for a new item.
     *
     * @return unique key.
     */
    private String generateId() {
        return (new Date()).toString() + rnd.nextInt();
    }

    /**
     * Replace an existing item with a new one.
     *
     * @param id   unique identifier of the item to be replaced.
     * @param item replacement item.
     * @return true if the item was found and replaced, false if it was not found.
     */
    public boolean replace(String id, Item item) {
        boolean replaced = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                replaced = true;
                break;
            }
        }
        return replaced;
    }

    /**
     * Removes an item from the storage.
     *
     * @param id unique identifier of the item to be removed.
     * @return true if the item was found and removed, false if it was not found.
     */
    public boolean delete(String id) {
        boolean removed = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, position - i);
                position--;
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Get all entered items.
     *
     * @return a new array consisting of items in the storage.
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        System.arraycopy(items, 0, result, 0, position);
        return result;
    }

    /**
     * Get item list by item name.
     *
     * @param name item name.
     * @return an array of items with corresponding names.
     */
    public Item[] findAllByName(String name) {
        Item[] result = new Item[100];
        int index = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(name)) {
                result[index++] = items[i];
            }
        }
        return result;
    }

    /**
     * Get item by id.
     *
     * @param id item id.
     * @return found item or null if not found.
     */
    public Item findById(String id) {
        for (Item item : items)
            if (item.getId().equals(id))
                return item;
        return null;
    }

}
