package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMatrix {

    public List<Integer> flat(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(List::stream).collect(Collectors.toList());
    }

    public List<Integer> flat(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(e -> Arrays.stream((e))).collect(Collectors.toList());
    }
}
