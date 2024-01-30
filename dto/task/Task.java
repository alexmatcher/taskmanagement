package effectivemobile.taskmanagementsystem.dto.task;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
@Builder
public class Task {
    private String name;
    private StatusOfTask statusOfTask;
    private Priority priority;
    private String description;
    private String executor;


}

