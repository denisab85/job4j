package list;

import java.util.LinkedList;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer n : list) {
            array[row][cell] = n;
            if (++cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new LinkedList<>();
        for (int[] row : list) {
            for (int n : row) {
                result.add(n);
            }
        }
        return result;
    }
}
