package mango.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskTest {
    @Test
    public void testDeadlineDescription() {
        assertEquals("abc (by: Oct 15 2009)", new Deadline("abc", "2009-10-15").getDescription());
    }

    @Test
    public void testEventDescription() {
        assertEquals("abc (at: Mon)", new Event("abc", "Mon").getDescription());
    }

    @Test
    public void testTodoDescription() {
        assertEquals("abc", new Todo("abc").getDescription());
    }

    @Test
    public void testDeadline_isValid_exceptionThrown() {
        try {
            assertEquals(false, Deadline.isValid(new String[] {"deadline"}));
            fail(); // the test should not reach this line
        } catch (Exception e) {
            assertEquals(" ☹ OOPS!!! The description of a deadline cannot be empty.", e.getMessage());
        }
    }


}
