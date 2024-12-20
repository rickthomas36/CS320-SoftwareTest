public class Task {
    private final String taskId;
    private String name;
    private String description;

    // Constructor
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must not be null or exceed 10 characters.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null or exceed 20 characters.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null or exceed 50 characters.");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null or exceed 20 characters.");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null or exceed 50 characters.");
        }
        this.description = description;
    }
}
