package tracker;

import java.util.List;

/**
 * A stub class for mocking user input, e.g. in tests.
 */
public class StubInput implements Input {

    private final String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String requestString(String prompt) {
        return answers[position++];
    }

    @Override
    public int requestInt(String prompt, List<Integer> range) {
        return Integer.parseInt(requestString(prompt));
    }

}
