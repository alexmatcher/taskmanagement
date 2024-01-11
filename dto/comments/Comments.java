package effectivemobile.taskmanagementsystem.dto.comments;

import lombok.Data;

import java.util.Objects;

@Data
public class Comments {
    private Integer id;
    private String comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments1 = (Comments) o;
        return Objects.equals(id, comments1.id) && Objects.equals(comments, comments1.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comments);
    }
}
