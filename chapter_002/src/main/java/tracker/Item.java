package tracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents an issue in the tracking system.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class Item {

    private String id;
    private String name;
    private String description;
    private final long created;
    private String comments;

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    /**
     * Creates an item and sets its name and description.
     *
     * @param name        name of the item.
     * @param description description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreated() {
        return created;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        Date createdDate = new Date(created);
        return String.format("%s  %23s  %s", dateFormat.format(createdDate), id, name);
    }
}
