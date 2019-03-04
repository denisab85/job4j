package tracker.menu;

import tracker.Input;
import tracker.Tracker;

public interface UserAction {

    /**
     * Numeric key that corresponds to this action.
     *
     * @return action key.
     */
    int getKey();

    /**
     * Executes action.
     *
     * @param input   Input system for user interaction.
     * @param tracker Tracker to operate on.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Describes the purpose of the action.
     *
     * @return description of action.
     */
    String info();
}
