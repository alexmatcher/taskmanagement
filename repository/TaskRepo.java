package effectivemobile.taskmanagementsystem.repository;

import effectivemobile.taskmanagementsystem.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TaskRepo extends JpaRepository<TaskEntity,Integer> {

    Optional<TaskEntity> findById(Integer id);

    TaskEntity findTaskByName(String name);

    boolean existsByName(String name);


}
