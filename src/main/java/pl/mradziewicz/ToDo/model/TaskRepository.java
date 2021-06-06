package pl.mradziewicz.ToDo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    List<Task> findAll();

    Optional<Task> findById(Integer id);

    List<Task> findByDone(boolean done);

    Page<Task> findAll(Pageable page);

    Task save(Task entity);

    boolean existsById(Integer id);
}
