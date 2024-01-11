package effectivemobile.taskmanagementsystem.service.impl;

import effectivemobile.taskmanagementsystem.dto.comments.Comments;
import effectivemobile.taskmanagementsystem.dto.task.Task;
import effectivemobile.taskmanagementsystem.entity.CommentsEntity;
import effectivemobile.taskmanagementsystem.entity.TaskEntity;
import effectivemobile.taskmanagementsystem.exeptions.NameDuplicateExeption;
import effectivemobile.taskmanagementsystem.mapper.CommentsConvertor;
import effectivemobile.taskmanagementsystem.mapper.TaskConvertor;
import effectivemobile.taskmanagementsystem.repository.CommentRepo;
import effectivemobile.taskmanagementsystem.repository.TaskRepo;
import effectivemobile.taskmanagementsystem.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final TaskConvertor taskConvertor;
    private final CommentsConvertor commentsConvertor;
    private final CommentRepo commentRepo;

    public TaskServiceImpl(TaskRepo taskRepo, TaskConvertor taskConvertor, CommentsConvertor commentsConvertor, CommentRepo commentRepo) {
        this.taskRepo = taskRepo;
        this.taskConvertor = taskConvertor;
        this.commentsConvertor = commentsConvertor;
        this.commentRepo = commentRepo;
    }

    @Transactional
    @Override
    public void createTask(Task task) {

        if (taskRepo.existsByName(task.getName())) {
            throw new NameDuplicateExeption("name of task is used");
        }
        TaskEntity entity = taskConvertor.convertToEntity(task);
        taskRepo.save(entity);
    }

    @Transactional
    @Override
    public void updateTask(Integer id, Task task) {
        Optional<TaskEntity> entityById = taskRepo.findById(id);
        if (entityById.isPresent()) {
            TaskEntity entity = entityById.get();
            entity.setName(task.getName());
            entity.setStatusOfTask(task.getStatusOfTask());
            entity.setPriority(task.getPriority());
            taskRepo.save(entity);
        }
        throw new EntityNotFoundException("id not found");

    }

    @Transactional
    public void addComment(Integer id, String comments) {
        Optional<TaskEntity> entityById = taskRepo.findById(id);
        if (entityById.isPresent()) {
            Comments comment = new Comments();
            comment.setComments(comments);
            CommentsEntity commentsEntity = commentsConvertor.convertToEntity(comment);
            TaskEntity taskEntity = entityById.get();
            taskEntity.getCommentsEntityList().add(commentsEntity);
            commentsEntity.setTask(taskEntity);
            taskRepo.save(taskEntity);
        }
        throw new EntityNotFoundException("id not found");
    }
}
