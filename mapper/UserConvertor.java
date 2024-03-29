package effectivemobile.taskmanagementsystem.mapper;

import effectivemobile.taskmanagementsystem.dto.user.UpdateUser;
import effectivemobile.taskmanagementsystem.dto.user.User;
import effectivemobile.taskmanagementsystem.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {
    private final ModelMapper modelMapper = new ModelMapper();

    public User convertToDto(UserEntity userEntity) {
        configureModelMapper();
        if (userEntity == null) {
            return null;
        }
        return modelMapper.map(userEntity, User.class);
    }

    public UserEntity updateConvertor(UpdateUser updateUser) {
        configureModelMapper();
        if (updateUser == null) {
            return null;
        }
        return modelMapper.map(updateUser, UserEntity.class);
    }

    public UserEntity converToEntity(Object user) {
        configureModelMapper();
        if (user == null) {
            return null;
        }
        return modelMapper.map(user, UserEntity.class);
    }

    private void configureModelMapper () {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }
}
