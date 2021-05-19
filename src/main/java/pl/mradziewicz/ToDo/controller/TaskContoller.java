package pl.mradziewicz.ToDo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mradziewicz.ToDo.model.TaskRepository;

@RepositoryRestController
public class TaskContoller {
    private final Logger logger = LoggerFactory.getLogger(TaskContoller.class);
    private final TaskRepository repository;


    public TaskContoller(final TaskRepository repository) {
        this.repository = repository;
    }


    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<?> readAllTasks(){
        logger.warn("Warning! u read all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/tasks")
    ResponseEntity<?> readAllTasks(Pageable page){
        logger.info("Własne ustawienia stronicowania");
        return ResponseEntity.ok(repository.findAll(page));
    }
}
