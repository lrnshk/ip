package mango.task;

import mango.DukeException;

public class Event extends Task {
    protected String date;

    public Event(String description, String date) {
        super(description);
        this.date = date;
    }

    public Event(String description, String date, String status) {
        super(description, status.equals("true"));
        this.date = date;
    }

    public String getType() {
        return "E";
    }

    public static boolean isValid(String[] arr) throws DukeException {
        if (arr.length == 1) {
            throw new DukeException(" ☹ OOPS!!! The description of a event cannot be empty.");
        }

        return true;
    }

    public String getDescription() {
        return String.format("%s (at: %s)", this.description, this.date);
    }

    public String save() {
        return String.format("%s:%s:%s:%s\n", this.getType(), this.getStatus(), this.description, this.date);
    }
}