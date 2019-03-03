package shape;


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
    @Test
    public void whenDrawSquare() {
        PrintStream original = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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
        System.setOut(original);
    }
    @Test
    public void whenDrawTriangle() {
        PrintStream original = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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
        System.setOut(original);
    }
}