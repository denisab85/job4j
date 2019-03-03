package shape;

import java.util.StringJoiner;

public class Square implements Shape {

    public String draw() {
        StringJoiner result = new StringJoiner(System.lineSeparator());
        for (int i = 0; i < 8; i++) {
            result.add("########");
        }
        return result.toString();
    }
}