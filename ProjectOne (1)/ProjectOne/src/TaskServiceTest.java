import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("T123", "Task Name", "Task description");

        service.addTask(task);
        assertEquals(task, service.getTask("T123"));
    }

    @Test
    void testAddDuplicateTask() {
        TaskService service = new TaskService();
        Task task = new Task("T123", "Task Name", "Task description");

        service.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task));
    }

    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("T123", "Task Name", "Task description");

        service.addTask(task);
        service.deleteTask("T123");

        assertNull(service.getTask("T123"));
    }

    @Test
    void testDeleteNonExistentTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("NonExistentID"));
    }

    @Test
    void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("T123", "Old Name", "Task description");

        service.addTask(task);
        service.updateTaskName("T123", "New Name");

        assertEquals("New Name", service.getTask("T123").getName());
    }

    @Test
    void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("T123", "Task Name", "Old Description");

        service.addTask(task);
        service.updateTaskDescription("T123", "New Description");

        assertEquals("New Description", service.getTask("T123").getDescription());
    }

    @Test
    void testUpdateNonExistentTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskName("NonExistentID", "New Name"));
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskDescription("NonExistentID", "New Description"));
    }
}

