package pl.mradziewicz.ToDo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mradziewicz.ToDo.model.Task;
import pl.mradziewicz.ToDo.model.TaskRepository;

import java.util.List;

@RestController
public class TaskContoller {
    private final Logger logger = LoggerFactory.getLogger(TaskContoller.class);
    private final TaskRepository repository;


    public TaskContoller(final TaskRepository repository) {
        this.repository = repository;
    }


    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks(){
        logger.warn("Warning! u read all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable page){
        logger.info("Własne ustawienia stronicowania");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }
}
