package effectivemobile.taskmanagementsystem.service.repository;

import effectivemobile.taskmanagementsystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    UserEntity findUserById (Integer id);

    UserEntity findUserByEmail(String email);




}
