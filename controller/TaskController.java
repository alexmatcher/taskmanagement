package effectivemobile.taskmanagementsystem.controller;

import effectivemobile.taskmanagementsystem.service.impl.TaskServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@NoArgsConstructor
public class TaskController {
    @Autowired
    private TaskServiceImpl taskService;


}
