package user;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenSortByDefaultThenSortedByAge() {
        List<User> list = new ArrayList<>();
        User user1 = new User("User old", 80);
        User user2 = new User("User young", 20);
        User user3 = new User("User small", 6);
        User user4 = new User("User adult", 40);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        Set<User> result = new SortUser().sort(list);
        assertThat(result, IsIterableContainingInOrder.contains(user3, user2, user4, user1));
    }


    @Test
    public void whenSortByNameLengthThenSorted() {
        List<User> list = new ArrayList<>();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Irina", 30);
        User user3 = new User("Valentina", 20);
        User user4 = new User("Иван", 25);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        List<User> result = new SortUser().sortByNameLength(list);
        assertThat(result, IsIterableContainingInOrder.contains(user4, user2, user1, user3));
    }


    @Test
    public void whenSortByNameAndAgeThenSorted() {
        List<User> list = new ArrayList<>();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 20);
        User user4 = new User("Иван", 25);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        List<User> result = new SortUser().sortByAllFields(list);
        assertThat(result, IsIterableContainingInOrder.contains(user4, user2, user3, user1));
    }

}
