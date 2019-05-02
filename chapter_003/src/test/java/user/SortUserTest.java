package user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenSortThenSorted() {
        List<User> list = new ArrayList<>();
        User user1 = new User("User old", 80);
        User user2 = new User("User young", 20);
        User user3 = new User("User small", 6);
        User user4 = new User("User adult", 40);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        Set<User> expected = new TreeSet<User>();
        expected.add(user3);
        expected.add(user2);
        expected.add(user4);
        expected.add(user1);

        SortUser sort = new SortUser();
        Set<User> result = sort.sort(list);

        assertThat(result, is(expected));
    }

}
