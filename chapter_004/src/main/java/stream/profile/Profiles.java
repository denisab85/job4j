package stream.profile;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).sorted().distinct().collect(Collectors.toList());
    }
}
