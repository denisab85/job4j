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
public class SquareTest {

    @Test
    public void whenDrawSquareThenOutputSquare() {
        Square square = new Square();
        String expected = new StringJoiner(System.lineSeparator())
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .toString();
        Assert.assertThat(square.draw(), is(expected));
    }
}
