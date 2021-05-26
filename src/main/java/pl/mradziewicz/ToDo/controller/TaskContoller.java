package pl.mradziewicz.ToDo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mradziewicz.ToDo.model.Task;
import pl.mradziewicz.ToDo.model.TaskRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @PutMapping("/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @Valid @RequestBody Task toUpdate){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        return ResponseEntity.ok(repository.save(toUpdate));
    }

    @GetMapping("/tasks/{id}")
    ResponseEntity<Optional<Task>> getTask(@PathVariable int id){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repository.findById(id));
    }

    @PostMapping("/tasks")
    ResponseEntity<Task> saveTask(@Valid @RequestBody Task saveTask){
        return ResponseEntity.ok(repository.save(saveTask));
    }
}
