package effectivemobile.taskmanagementsystem.service.impl;

import effectivemobile.taskmanagementsystem.dto.auth.Register;
import effectivemobile.taskmanagementsystem.dto.user.User;
import effectivemobile.taskmanagementsystem.entity.UserEntity;
import effectivemobile.taskmanagementsystem.exeptions.MailDuplicationExeption;
import effectivemobile.taskmanagementsystem.mapper.UserConvertor;
import effectivemobile.taskmanagementsystem.repository.UserRepo;
import effectivemobile.taskmanagementsystem.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    private final UserConvertor userConvertor;

    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, UserConvertor userConvertor) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.userConvertor = userConvertor;
    }


    @Transactional
    @Override
    public boolean registerUser(Register register)  {
        if (userRepo.existsByEmail(register.getEmail())) {
            throw new MailDuplicationExeption("mail is used");
        }
        User user = new User();
        user.setEmail(register.getEmail());
        user.setPassword((passwordEncoder.encode(register.getPassword())));
        UserEntity userEntity = userConvertor.converToEntity(user);
        userRepo.save(userEntity);
        return true;
    }

    @Transactional
    @Override
    public void updateUserInfo(User user, Integer id) {
        UserEntity entity = userRepo.findUserById(id);
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        UserEntity userEntity = userConvertor.converToEntity(user);
        userRepo.save(userEntity);

    }

}
