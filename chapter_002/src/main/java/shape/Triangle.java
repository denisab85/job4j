package shape;

import java.util.StringJoiner;

public class Triangle implements Shape {

    public String draw() {
        StringJoiner result = new StringJoiner(System.lineSeparator());
        for (int i = 0; i < 8; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                line.append("#");
            }
            result.add(line.toString());
        }
        return result.toString();
    }
}
