package tracker;

import java.util.*;

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
    private final List<Item> items = new ArrayList<>();

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
        this.items.add(item);
        return item;
    }

    /**
     * Generates a unique key for a new item.
     *
     * @return unique key.
     */
    private String generateId() {
        return String.format("%d%d", System.currentTimeMillis(), rnd.nextInt(Integer.MAX_VALUE));
    }

    /**
     * Replace an existing item with a new one while keeping the original ID.
     *
     * @param id   unique identifier of the item to be replaced.
     * @param item replacement item.
     * @return true if the item was found and replaced, false if it was not found.
     */
    public boolean replace(String id, Item item) {
        boolean replaced = false;
        Item old = findById(id);
        if (old != null) {
            item.setId(old.getId());
            items.set(items.indexOf(old), item);
            replaced = true;
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
        Item item = findById(id);
        if (item != null) {
            removed = items.remove(item);
        }
        return removed;
    }

    /**
     * Get all entered items.
     *
     * @return items in the storage.
     */
    public List<Item> getAll() {
        return items;
    }

    /**
     * Get item list by item name.
     *
     * @param name item name.
     * @return an array of items with corresponding names.
     */
    public List<Item> findAllByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                result.add(item);
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
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public String getAllAsString() {
        String header = " # ||      Created      ||          ID           ||   Name";
        StringJoiner result = new StringJoiner(System.lineSeparator());
        result.add(header);
        int index = 0;
        for (Item item : this.items) {
            result.add(String.format("%03d  %s", ++index, item.toString()));
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return getAllAsString();
    }
}
