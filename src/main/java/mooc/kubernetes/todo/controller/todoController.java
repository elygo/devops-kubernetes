package mooc.kubernetes.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class todoController {
    @GetMapping("/todos")
    public String toDoList() {
        return "TODO: List of tasks.";
    }
}
