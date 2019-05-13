package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> x * x * 2);
        List<Double> expected = Arrays.asList(50D, 72D, 98D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(500, 505, x -> Math.log(x));
        List<Double> expected = Arrays.asList(6.214608098422191, 6.2166061010848646, 6.218600119691729, 6.220590170099739, 6.222576268071369);
        assertThat(result, is(expected));
    }

}
