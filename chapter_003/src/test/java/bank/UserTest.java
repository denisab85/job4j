package bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    private User user1;

    @Before
    public void createUser() {
        user1 = new User("User #1", "1803-856111");
    }

    @Test
    public void whenCreateUserThenCorrectAttributes() {
        assertThat(user1.getName(), is("User #1"));
        assertThat(user1.getPassport(), is("1803-856111"));
    }

    @Test
    public void whenSameNameAndPassportThenEquals() {
        User user2 = new User("User #1", "1803-856111");
        assertEquals(user1, user2);
    }

    @Test
    public void whenDifferentNameThenEqualsFalse() {
        User user2 = new User("User #2", "1803-856111");
        assertNotEquals(user1, user2);
    }

    @Test
    public void whenDifferentPassportThenEqualsFalse() {
        User user2 = new User("User #1", "1803-856222");
        assertNotEquals(user1, user2);
    }

    @Test
    public void whenSameNameAndPassportThenComparesAsZero() {
        User user2 = new User("User #1", "1803-856111");
        assertThat(user1.compareTo(user2), is(0));
    }

    @Test
    public void whenNameIsGreaterThenComparesAsNegative() {
        User user2 = new User("User #2", "1803-856111");
        assertThat(user1.compareTo(user2), lessThan(0));
    }

    @Test
    public void whenPassportIsGreaterThenComparesAsNegative() {
        User user2 = new User("User #1", "1803-856222");
        assertThat(user1.compareTo(user2), lessThan(0));
    }

    @Test
    public void whenToString() {
        assertThat(user1.toString(), is("User: User #1, passport: 1803-856111"));
    }


}
