package effectivemobile.taskmanagementsystem.mapper;

import effectivemobile.taskmanagementsystem.dto.task.Task;
import effectivemobile.taskmanagementsystem.entity.TaskEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class TaskConvertor {
    private ModelMapper modelMapper = new ModelMapper();


    public Task convertToDto(TaskEntity taskEntity) {
        configureModelMapper();
        if (taskEntity == null) {
            return null;
        }
        Task taskDto = modelMapper.map(taskEntity, Task.class);
        return taskDto;
    }

    public TaskEntity convertToEntity(Task task) {
        configureModelMapper();
        if (task == null) {
            return null;
        }
        TaskEntity taskEntity = modelMapper.map(task, TaskEntity.class);
        return taskEntity;
    }

    private void configureModelMapper () {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }
}
