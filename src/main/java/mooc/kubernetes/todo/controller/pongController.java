package mooc.kubernetes.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pongController {
    private int counter = 0;

    @GetMapping("/pong")
    public String ping() {
        return "pong " + counter++;
    }
}
