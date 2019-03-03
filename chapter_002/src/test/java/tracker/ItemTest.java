package tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class ItemTest {

    @Test
    public void whenCreateNewItemThenNameDescriptionAndDateCreatedAreSet() {
        long beforeCreation = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription");
        long afterCreation = System.currentTimeMillis();

        assertThat(item.getName(), is("test1"));
        assertThat(item.getDescription(), is("testDescription"));

        assertThat(item.getCreated() >= beforeCreation, is(true));
        assertThat(item.getCreated() <= afterCreation, is(true));
    }

    @Test
    public void whenSetIdThenIdIsCorrect() {
        Item item = new Item("test1", "testDescription");
        item.setId("testId123");
        assertThat(item.getId(), is("testId123"));
    }


    @Test
    public void whenSetCommentsThenCommentsAreCorrect() {
        Item item = new Item("test1", "testDescription");
        item.setComments("test comment");
        assertThat(item.getComments(), is("test comment"));
    }

}
