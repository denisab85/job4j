package stream.school;

import org.junit.Test;
import stream.school.School;
import stream.school.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    private final Student student10 = new Student(10);
    private final Student student25 = new Student(25);
    private final Student student40 = new Student(40);
    private final Student student55 = new Student(55);
    private final Student student70 = new Student(70);
    private final Student student85 = new Student(85);
    private final Student student100 = new Student(100);
    private final List<Student> students = Arrays.asList(student10, student25, student40, student55, student70, student85, student100);
    private final School school = new School();

    @Test
    public void whenCollectStudentsA() {
        Predicate<Student> a = student -> student.getScore() >= 70;
        assertThat(school.collect(students, a), containsInAnyOrder(student70, student85, student100));
    }

    @Test
    public void whenCollectStudentsB() {
        Predicate<Student> b = student -> student.getScore() >= 50 && student.getScore() < 70;
        assertThat(school.collect(students, b), contains(student55));
    }

    @Test
    public void whenCollectStudentsC() {
        Predicate<Student> c = student -> student.getScore() >= 0 && student.getScore() < 50;
        assertThat(school.collect(students, c), containsInAnyOrder(student10, student25, student40));
    }
}
