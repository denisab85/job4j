package user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {

    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }

}
