package tracker;

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
    private final String name;
    private final String description;
    private final Date created;
    private String comments;

    /**
     * Creates an item and sets its name and description.
     *
     * @param name        name of the item.
     * @param description description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = new Date();
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

    public String getDescription() {
        return description;
    }

    public Date getCreated() {
        return created;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
