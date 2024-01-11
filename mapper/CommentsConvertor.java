package effectivemobile.taskmanagementsystem.mapper;

import effectivemobile.taskmanagementsystem.dto.comments.Comments;
import effectivemobile.taskmanagementsystem.entity.CommentsEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class CommentsConvertor {
    private ModelMapper modelMapper = new ModelMapper();

    public CommentsEntity convertToEntity(Comments comments) {
        configureModelMapper();
        if (comments == null) {
            return null;
        }
        CommentsEntity commentsEntity = modelMapper.map(comments, CommentsEntity.class);
        return commentsEntity;
    }
    private void configureModelMapper () {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }
}
