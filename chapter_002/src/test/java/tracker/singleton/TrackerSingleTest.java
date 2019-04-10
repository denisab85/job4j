package tracker.singleton;

import org.junit.Test;
import tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleTest {
    @Test
    public void whenCreateTrackerEnumThenSameObject() {
        Tracker instance1 = TrackerEnum.INSTANCE.getInstance();
        Tracker instance2 = TrackerEnum.INSTANCE.getInstance();
        assertThat(instance1, is(instance2));
    }

    @Test
    public void whenCreateTrackerSingle1ThenSameObject() {
        Tracker instance1 = TrackerSingle1.getInstance();
        Tracker instance2 = TrackerSingle1.getInstance();
        assertThat(instance1, is(instance2));
    }

    @Test
    public void whenCreateTrackerSingle2ThenSameObject() {
        Tracker instance1 = TrackerSingle2.getInstance();
        Tracker instance2 = TrackerSingle2.getInstance();
        assertThat(instance1, is(instance2));
    }

    @Test
    public void whenCreateTrackerSingle3ThenSameObject() {
        Tracker instance1 = TrackerSingle3.getInstance();
        Tracker instance2 = TrackerSingle3.getInstance();
        assertThat(instance1, is(instance2));
    }
}
