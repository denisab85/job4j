package tracker;

public class StubInput implements Input {

    private final String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String request(String prompt) {
        return answers[position++];
    }
}
