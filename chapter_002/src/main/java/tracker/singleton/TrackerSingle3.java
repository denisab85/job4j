package tracker.singleton;

import tracker.Tracker;

public class TrackerSingle3 extends Tracker {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();

    private TrackerSingle3() {
    }

    public static TrackerSingle3 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    }

}
