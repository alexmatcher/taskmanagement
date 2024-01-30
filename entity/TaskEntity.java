package effectivemobile.taskmanagementsystem.entity;

import effectivemobile.taskmanagementsystem.dto.task.Priority;
import effectivemobile.taskmanagementsystem.dto.task.StatusOfTask;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
public class TaskEntity {
    public TaskEntity() {
    }
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Getter
    @Setter
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusOfTask statusOfTask;
    @Getter
    @Setter
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
    @Getter
    @Setter
    @Column(name = "description")
    private String description;
    @Getter
    @Setter
    @Column(name = "executor")
    private String executor;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Getter
    @Setter
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CommentsEntity> commentsEntityList = new ArrayList<>();

}

