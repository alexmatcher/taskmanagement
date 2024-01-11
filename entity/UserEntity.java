package effectivemobile.taskmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserEntity {
    public UserEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    @Column(name = "firstName")
    private String firstName;
    @Getter
    @Setter
    @Column(name = "lastName")
    private String lastName;
    @Getter
    @Setter
    @Email
    @Column(name = "email", unique = true)
    private String email;
    @Getter
    @Setter
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_task",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List <TaskEntity> task;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<CommentsEntity> commentsEntityList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password);
    }
}
