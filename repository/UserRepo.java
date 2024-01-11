package effectivemobile.taskmanagementsystem.repository;

import effectivemobile.taskmanagementsystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    UserEntity findUserById (Integer id);

    boolean existsByEmail (String email);

    UserEntity findUserByEmail(String email);




}
