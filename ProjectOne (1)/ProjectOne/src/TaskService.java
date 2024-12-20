import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    // Add task
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Delete task by ID
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        tasks.remove(taskId);
    }

    // Update task name
    public void updateTaskName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setName(newName);
    }

    // Update task description
    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setDescription(newDescription);
    }

    // Retrieve task (for testing purposes)
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}