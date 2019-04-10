package tracker.singleton;

import tracker.Tracker;

public class TrackerSingle2 extends Tracker {
    private static final TrackerSingle2 INSTANCE = new TrackerSingle2();

    private TrackerSingle2() {
    }

    public static TrackerSingle2 getInstance() {
        return INSTANCE;
    }
}
