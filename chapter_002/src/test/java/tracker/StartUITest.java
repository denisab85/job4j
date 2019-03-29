package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
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
    private final String expectedMenu = String.join(System.lineSeparator(), "0. Add item to the tracker.",
            " 1. Show all items.",
            " 2. Edit item.",
            " 3. Delete item.",
            " 4. Find item by ID.",
            " 5. Find item(s) by name.",
            "");
    private final String expectedHeader = " # ||      Created      ||          ID           ||   Name" + System.lineSeparator();

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
        assertThat(getOutput().trim(), is(expectedMenu + expectedHeader + expected.toString()));
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
        assertThat(getOutput().trim(), is(expectedMenu + item.toString()));
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
        assertThat(getOutput().trim(), is(expectedMenu + expected.toString()));
    }

    @Test
    public void whenInvalidInput() {
        StringJoiner expected = new StringJoiner(System.lineSeparator());
        expected.add("Invalid input. A number is expected. Please try again.");
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "-1", "1"}));
        input.requestInt("Enter", Arrays.asList(0, 1, 2, 3, 4, 5));
        assertThat(getOutput().trim(), is(expected.toString()));
    }

}
