package comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        int len = Math.min(left.length(), right.length());
        int i = 0;
        while (i < len) {
            if (left.charAt(i) != right.charAt(i)) {
                result = left.charAt(i) - right.charAt(i);
                break;
            }
            i++;
        }
        return result == 0 ? left.length() - right.length() : result;
    }

}