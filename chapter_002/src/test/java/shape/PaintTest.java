package shape;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Abakumov
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    PrintStream original = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void mockOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void resetOutput() {
        System.setOut(original);
    }

    @Test
    public void whenDrawSquare() {
        String expected = new StringJoiner(System.lineSeparator())
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .add("########")
                .add("")
                .toString();
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenDrawTriangle() {
        String expected = new StringJoiner(System.lineSeparator())
                .add("#")
                .add("##")
                .add("###")
                .add("####")
                .add("#####")
                .add("######")
                .add("#######")
                .add("########")
                .add("")
                .toString();
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(expected));
    }
}