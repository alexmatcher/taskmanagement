package effectivemobile.taskmanagementsystem.mapper;

import effectivemobile.taskmanagementsystem.dto.task.Task;
import effectivemobile.taskmanagementsystem.entity.TaskEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class TaskConvertor {
    private final ModelMapper modelMapper = new ModelMapper();


    public Task convertToDto(TaskEntity taskEntity) {
        configureModelMapper();
        if (taskEntity == null) {
            return null;
        }
        return modelMapper.map(taskEntity, Task.class);
    }

    public TaskEntity convertToEntity(Task task) {
        configureModelMapper();
        if (task == null) {
            return null;
        }
        return modelMapper.map(task, TaskEntity.class);
    }

    private void configureModelMapper () {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }
}
