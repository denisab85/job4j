package user;

public class User implements Comparable<User> {

    private Integer id;
    private String name;
    private Integer age = 0;
    private String city;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int compareTo(User user) {
        return user == null ? -1 : this.age.compareTo(user.age);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", name, age);
    }

    public Integer getAge() {
        return age;
    }
}
