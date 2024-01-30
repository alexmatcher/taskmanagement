package effectivemobile.taskmanagementsystem.service;

import effectivemobile.taskmanagementsystem.dto.auth.Register;
import effectivemobile.taskmanagementsystem.dto.user.UpdateUser;
import effectivemobile.taskmanagementsystem.dto.user.User;
import effectivemobile.taskmanagementsystem.entity.UserEntity;
import effectivemobile.taskmanagementsystem.exeptions.MailDuplicationExeption;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

public interface UserService {

    UpdateUser updateUserInfo(UpdateUser updateUser);

    List<String> getAllusers = new ArrayList<>();

}
