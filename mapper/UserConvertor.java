package effectivemobile.taskmanagementsystem.mapper;

import effectivemobile.taskmanagementsystem.dto.user.User;
import effectivemobile.taskmanagementsystem.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {
    private ModelMapper modelMapper = new ModelMapper();

    public User convertToDto(UserEntity userEntity) {
        configureModelMapper();
        if (userEntity == null) {
            return null;
        }
        User userDto = modelMapper.map(userEntity, User.class);
        return userDto;
    }

    public UserEntity converToEntity(User user) {
        configureModelMapper();
        if (user == null) {
            return null;
        }
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        return userEntity;
    }

    private void configureModelMapper () {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }
}
