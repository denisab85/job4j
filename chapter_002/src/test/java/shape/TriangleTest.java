package shape;

import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {

    @Test
    public void whenDrawTriangleThenOutputTriangle() {
        Triangle triangle = new Triangle();
        String n = System.lineSeparator();
        String expected = new StringJoiner(System.lineSeparator())
                .add("#")
                .add("##")
                .add("###")
                .add("####")
                .add("#####")
                .add("######")
                .add("#######")
                .add("########")
                .toString();
        Assert.assertThat(triangle.draw(), is(expected));
    }
}
