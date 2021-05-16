package pl.mradziewicz.ToDo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
