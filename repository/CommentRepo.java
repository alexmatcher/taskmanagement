package effectivemobile.taskmanagementsystem.repository;

import effectivemobile.taskmanagementsystem.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepo extends JpaRepository<CommentsEntity, Integer> {

}
