package effectivemobile.taskmanagementsystem.entity;

import effectivemobile.taskmanagementsystem.dto.task.Priority;
import effectivemobile.taskmanagementsystem.dto.task.StatusOfTask;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "task")
public class TaskEntity {
    public TaskEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusOfTask statusOfTask;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;


    @Column(name = "name")
    private String name;


    @ManyToMany
    @JoinTable(
            name = "task_user",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> user;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<CommentsEntity> commentsEntityList = new ArrayList<>();

}

