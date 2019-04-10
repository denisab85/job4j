package tracker.singleton;

import tracker.Tracker;

public class TrackerSingle1 extends Tracker {
    private static TrackerSingle1 instance;

    private TrackerSingle1() {
    }

    public static TrackerSingle1 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle1();
        }
        return instance;
    }
}
