package effectivemobile.taskmanagementsystem.service;

import effectivemobile.taskmanagementsystem.dto.auth.Register;
import effectivemobile.taskmanagementsystem.dto.user.User;
import effectivemobile.taskmanagementsystem.entity.UserEntity;
import effectivemobile.taskmanagementsystem.exeptions.MailDuplicationExeption;

import javax.validation.constraints.Email;

public interface UserService {
   boolean registerUser(Register register) throws MailDuplicationExeption;

    void updateUserInfo(User user,Integer id);

}
