package stream.school;

public class Student {

    private final String firstName;
    private final String lastName;
    private final int score;

    @Override
    public String toString() {
        return firstName + ' ' + lastName + ": " + score;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Student(String firstName, String lastName, int score) {
        this.score = score;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }


}
