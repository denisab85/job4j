package bank;

import java.util.Objects;

/**
 * Represents a bank customer.
 */
public class User implements Comparable<User> {

    private final String name;
    private final String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name) && passport.equals(user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public String toString() {
        return String.format("User: %s, passport: %s", name, passport);
    }

    @Override
    public int compareTo(User user) {
        int result = this.name.compareTo(user.name);
        if (result == 0) {
            result = this.passport.compareTo(user.passport);
        }
        return result;
    }
}
