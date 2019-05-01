package task;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class CashMachineTest {

    @Test
    public void unchange1() {
        CashMachine machine = new CashMachine(new int[]{1, 2, 5, 10});
        List<List<Integer>> result = machine.exchange(1);
        assertThat(result, contains(
                contains(1)
        ));
    }

    @Test
    public void change5() {
        CashMachine machine = new CashMachine(new int[]{1, 2, 5, 10});
        List<List<Integer>> result = machine.exchange(5);
        assertThat(result, containsInAnyOrder(
                containsInAnyOrder(5),
                containsInAnyOrder(2, 2, 1),
                containsInAnyOrder(2, 1, 1, 1),
                containsInAnyOrder(1, 1, 1, 1, 1)
        ));
    }

    @Test
    public void change6() {
        CashMachine machine = new CashMachine(new int[]{1, 5, 10});
        List<List<Integer>> result = machine.exchange(6);
        assertThat(result, containsInAnyOrder(
                containsInAnyOrder(1, 5),
                containsInAnyOrder(1, 1, 1, 1, 1, 1)
        ));
    }

    @Test
    public void five() {
        CashMachine machine = new CashMachine(new int[]{1, 5, 10});
        List<List<Integer>> result = machine.exchange(5);
        assertThat(result, containsInAnyOrder(
                containsInAnyOrder(1, 1, 1, 1, 1),
                containsInAnyOrder(5)
        ));
    }

    @Test
    public void change() {
        CashMachine machine = new CashMachine(new int[]{10, 5, 1});
        List<List<Integer>> result = machine.exchange(10);
        assertThat(result, containsInAnyOrder(
                contains(10),
                containsInAnyOrder(5, 5),
                containsInAnyOrder(1, 1, 1, 1, 1, 5),
                containsInAnyOrder(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
                )
        );
    }

}