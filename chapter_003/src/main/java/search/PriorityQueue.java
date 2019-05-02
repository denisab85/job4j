package search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставляет в нужную позицию элемент.
     *
     * @param task задача
     */
    public void put(Task task) {
        int pos;
        for (pos = 0; pos < this.tasks.size(); pos++) {
            if (this.tasks.get(pos).getPriority() > task.getPriority()) {
                break;
            }
        }
        this.tasks.add(pos, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}