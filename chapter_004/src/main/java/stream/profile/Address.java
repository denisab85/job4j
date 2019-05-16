package stream.profile;

import java.util.Objects;

public class Address implements Comparable<Address> {

    private final String city;

    private final String street;

    private final int home;

    private final int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public int compareTo(Address o) {
        if (this.city == o.city) {
            return 0;
        }
        if (this.city == null) {
            return -1;
        }
        if (o.city == null) {
            return 1;
        }
        return this.city.compareTo(o.city);
    }
}