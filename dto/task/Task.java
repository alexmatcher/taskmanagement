package effectivemobile.taskmanagementsystem.dto.task;

import lombok.Data;

import java.util.Objects;

@Data
public class Task {
    private String name;
    private StatusOfTask statusOfTask;
    private Priority priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && statusOfTask == task.statusOfTask && priority == task.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, statusOfTask, priority);
    }
}

