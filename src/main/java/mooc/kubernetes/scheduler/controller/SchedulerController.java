package mooc.kubernetes.scheduler.controller;

import mooc.kubernetes.scheduler.Scheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerController {
    private final Scheduler scheduler;

    public SchedulerController(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
    @GetMapping("/status")
    public String getStatus() {
        return scheduler.getStatus();
    }
}