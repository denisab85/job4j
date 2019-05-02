package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {

    @Test
    public void when7Elements3RowsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }


    @Test
    public void when4Elements2RowsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4),
                2
        );
        int[][] expect = {
                {1, 2},
                {3, 4}
        };
        assertThat(result, is(expect));
    }


    @Test
    public void whenListOfArraysToList() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[]{1, 2});
        listOfArrays.add(new int[]{3, 4, 5, 6});
        List<Integer> result = list.convert(listOfArrays);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expected));
    }

}