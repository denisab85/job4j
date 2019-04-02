package tracker.menu;

public abstract class BaseAction {
    private int key;
    private String name;

    public BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String info() {
        return String.format("%2d. %s", key, name);
    }
}
