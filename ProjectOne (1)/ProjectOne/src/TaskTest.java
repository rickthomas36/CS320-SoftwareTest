import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("123", "Task Name", "Task Description");
        assertEquals("123", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Name", "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task Name", "Task Description"));
    }

    @Test
    public void testSetName() {
        Task task = new Task("123", "Task Name", "Task Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("123", "Task Name", "Task Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }
}
