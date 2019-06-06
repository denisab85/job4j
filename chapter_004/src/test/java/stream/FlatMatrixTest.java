package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class FlatMatrixTest {
    @Test
    public void whenFlatListThenIntegerList() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        FlatMatrix flatMatrix = new FlatMatrix();
        assertThat(flatMatrix.flat(matrix), is(expected));
    }

    @Test
    public void whenFlatArrayThenIntegerList() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        FlatMatrix flatMatrix = new FlatMatrix();
        assertThat(flatMatrix.flat(matrix), is(expected));
    }
}
