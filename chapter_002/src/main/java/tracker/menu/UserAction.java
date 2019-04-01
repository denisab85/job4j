package tracker.menu;

import tracker.Tracker;
import tracker.ValidateInput;

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
    void execute(ValidateInput input, Tracker tracker);

    /**
     * Describes the purpose of the action.
     *
     * @return description of action.
     */
    String info();
}
