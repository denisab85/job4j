package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {
    private final Tracker tracker = new Tracker();
    private final PrintStream original = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void mockOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void resetOutput() {
        System.setOut(original);
    }

    private String getOutput() {
        return new String(out.toByteArray());
    }

    @Test
    public void whenUserAddItemThenTrackerHasThisItem() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenShowAllItems() {
        StringJoiner expected = new StringJoiner(System.lineSeparator());
        Item item = tracker.add(new Item("test name 1", "desc1"));
        expected.add("001  " + item.toString());
        item = tracker.add(new Item("test name 2", "desc2"));
        expected.add("002  " + item.toString());
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(getOutput(), containsString(expected.toString()));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "name replaced", "description replaced", "comment", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("name replaced"));
    }

    @Test
    public void whenDeleteThenItemDisappearsFromTracker() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), nullValue());
    }

    @Test
    public void whenFindItemByIdThenReturnItem() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(getOutput(), containsString(item.toString()));
    }

    @Test
    public void whenFindItemsByNameThenReturnItems() {
        StringJoiner expected = new StringJoiner(System.lineSeparator());
        Item item = tracker.add(new Item("same name", "desc1"));
        expected.add(item.toString());
        item = tracker.add(new Item("same name", "desc2"));
        expected.add(item.toString());
        Input input = new StubInput(new String[]{"5", "same name", "y"});
        new StartUI(input, tracker).init();
        assertThat(getOutput(), containsString(expected.toString()));
    }

}
