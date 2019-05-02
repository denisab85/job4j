package user;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortByNameLength(List<User> list) {
        List<User> result = new ArrayList<>(list);
        Collections.sort(result, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getName().length() - user2.getName().length();
            }
        });
        return result;
    }

    public List<User> sortByAllFields(List<User> list) {
        List<User> result = new ArrayList<>(list);
        Collections.sort(result, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int result = user1.getName().compareTo(user2.getName());
                if (result == 0) {
                    result = user1.getAge().compareTo(user2.getAge());
                }
                return result;
            }
        });
        return result;
    }
}
