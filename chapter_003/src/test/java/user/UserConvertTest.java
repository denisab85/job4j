package user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void when3DifferentIdsThen3Elements() {
        UserConvert uc = new UserConvert();
        List<User> list = new ArrayList<>();

        User user1 = new User(5, "Ivan Ivanov", "Ivanovsk");
        User user2 = new User(2, "Vladimir Skazochny", "Moscow");
        User user3 = new User(100, "Petr NeArsentev ))", "Tambov");
        list.add(user1);
        list.add(user2);
        list.add(user3);

        Map<Integer, User> expected = new HashMap<>();
        expected.put(5, user1);
        expected.put(2, user2);
        expected.put(100, user3);

        Map<Integer, User> result = uc.process(list);

        assertThat(result, is(expected));
    }


    @Test
    public void when3SameIdsThenLastElement() {
        UserConvert uc = new UserConvert();
        List<User> list = new ArrayList<>();

        User user1 = new User(3, "Ivan Ivanov", "Ivanovsk");
        User user2 = new User(3, "Vladimir Skazochny", "Moscow");
        User user3 = new User(3, "Petr NeArsentev ))", "Tambov");
        list.add(user1);
        list.add(user2);
        list.add(user3);

        Map<Integer, User> expected = new HashMap<>();
        expected.put(3, user3);

        Map<Integer, User> result = uc.process(list);

        assertThat(result, is(expected));
    }

}
