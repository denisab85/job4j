package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {

    @Test
    public void whenAddNewItemThenItemIdIsNotNullOrEmpty() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(item.getId(), notNullValue());
        assertThat(item.getId().length(), not(0));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void whenFindExistingItemByNameThenReturnSameItem() {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 5; i++) {
            tracker.add(new Item("item" + i, "testDescription"));
        }
        Item item = new Item("test", "testDescription");
        tracker.add(item);
        for (int i = 5; i < 10; i++) {
            tracker.add(new Item("item" + i, "testDescription"));
        }
        assertThat(tracker.findAllByName("test").get(0), is(item));
    }

    @Test
    public void whenAddItemThenSizeIncrements() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item1", "testDescription");
        tracker.add(item1);
        assertThat(tracker.getAll().size(), is(1));
    }

    @Test
    public void whenAddRemoveLastItemThenSizeIsZero() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item1", "testDescription");
        tracker.add(item1);
        tracker.delete(item1.getId());
        assertThat(tracker.getAll().size(), is(0));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }


}
