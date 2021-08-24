package mango.task;

import mango.DukeException;

/**
 * Represents a task. A <code>Task</code> object has a description and a completion status.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor of a Task.
     *
     * @param description The description of the Task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Constructor of a Task, initialised with a completion status.
     *
     * @param description The description of a task.
     * @param isDone The completions status of the task.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns the completion status of the task.
     *
     * @return True if the task is done, else false.
     */
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Returns the string representation of the completion status of the task.
     *
     * @return The string representation of the completion status of the task.
     */
    public String getStatus() {
        return (isDone ? "true" : "false");
    }

    /**
     * Returns the string representation of the task.
     *
     * @return The string representation of the task.
     */
    public String save() {
        return String.format("%s:%s:%s:\n", this.getType(), this.getStatus(), this.description);
    }

    /**
     * Returns the string icon of the completion status of the task.
     *
     * @return The string icon of the completion status of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Returns the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Checks if the input string array is valid.
     *
     * @param arr The input string array.
     * @return True if the string array is valid, else false.
     * @throws DukeException If the input array has a length of 1.
     */
    public static boolean isValid(String[] arr) throws DukeException {
        return true;
    }

    /**
     * Returns the type of the task.
     *
     * @return The type of the task.
     */
    public String getType() {
        return " ";
    }

    /**
     * Marks the task as completed.
     */
    public void markDone() {
      this.isDone = true;
    }
}
