package stream.profile;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    private final Address addr1 = new Address("City1", "Street1", 1, 1);
    private final Address addr2 = new Address("City2", "Street2", 2, 2);
    private final Address addr3 = new Address("City3", "Street3", 3, 3);

    @Test
    public void whenCollectAddressesThenAllAddresses() {
        List<Profile> profs = Arrays.asList(new Profile(addr1), new Profile(addr2), new Profile(addr3));
        Profiles profiles = new Profiles();
        assertThat(profiles.collect(profs), containsInAnyOrder(addr1, addr2, addr3));
    }

    @Test
    public void whenDuplicateAddressesThenCollectDistinctOnly() {
        List<Profile> profs = Arrays.asList(new Profile(addr1), new Profile(addr1), new Profile(addr2));
        Profiles profiles = new Profiles();
        assertThat(profiles.collect(profs), containsInAnyOrder(addr1, addr2));
    }

    @Test
    public void whenCollectAddressesThenReturnSorted() {
        List<Profile> profs = Arrays.asList(new Profile(addr2), new Profile(addr1), new Profile(addr3));
        Profiles profiles = new Profiles();
        assertThat(profiles.collect(profs), contains(addr1, addr2, addr3));
    }

}
