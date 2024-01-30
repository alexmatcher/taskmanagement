package effectivemobile.taskmanagementsystem.service;

import effectivemobile.taskmanagementsystem.dto.task.Task;
import effectivemobile.taskmanagementsystem.entity.TaskEntity;
import effectivemobile.taskmanagementsystem.exeptions.IdNotFoundExeption;
import effectivemobile.taskmanagementsystem.exeptions.NameDuplicateExeption;
import jakarta.persistence.EntityNotFoundException;



public interface TaskService {
    TaskEntity createTask(Task task) throws NameDuplicateExeption;

    TaskEntity updateTask(Integer id,Task task) throws EntityNotFoundException, IdNotFoundExeption;

    void addComment(Integer taskId, String comments) throws IdNotFoundExeption;
}
