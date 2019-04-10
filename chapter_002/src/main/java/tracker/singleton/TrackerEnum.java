package tracker.singleton;

import tracker.Tracker;

public enum TrackerEnum {
    INSTANCE;

    private Tracker tracker = new Tracker();

    public Tracker getInstance() {
        return tracker;
    }
}
