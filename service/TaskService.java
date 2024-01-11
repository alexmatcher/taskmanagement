package effectivemobile.taskmanagementsystem.service;

import effectivemobile.taskmanagementsystem.dto.comments.Comments;
import effectivemobile.taskmanagementsystem.dto.task.Task;
import effectivemobile.taskmanagementsystem.exeptions.NameDuplicateExeption;
import jakarta.persistence.EntityNotFoundException;

public interface TaskService {
    void createTask(Task task) throws NameDuplicateExeption;

    void updateTask(Integer id,Task task) throws EntityNotFoundException;

    void addComment(Integer id, String comments);
}
