package stream.school;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    private final Student student10 = new Student("Jon", "Labun", 10);
    private final Student student25 = new Student("Mark", "LeClair", 25);
    private final Student student40 = new Student("Kyle", "Dyck", 40);
    private final Student student55 = new Student("James", "Teichroew", 55);
    private final Student student70 = new Student("Cathy", "Crone", 70);
    private final Student student85 = new Student("Pilar", "Droguet", 85);
    private final Student student100 = new Student("Emily", "De Guzman", 100);
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

    @Test
    public void whenMapByLastNameThenMap() {
        Map<String, Student> expected = new HashMap<>();
        expected.put(student10.getLastName(), student10);
        expected.put(student25.getLastName(), student25);
        expected.put(student40.getLastName(), student40);
        expected.put(student55.getLastName(), student55);
        expected.put(student70.getLastName(), student70);
        expected.put(student85.getLastName(), student85);
        expected.put(student100.getLastName(), student100);
        assertThat(school.mapByLastName(students), is(expected));
    }
}
