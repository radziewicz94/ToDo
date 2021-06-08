package pl.mradziewicz.ToDo.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mradziewicz.ToDo.model.Project;
import pl.mradziewicz.ToDo.model.ProjectRepository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends JpaRepository<Project, Integer>, ProjectRepository {
    @Override
    @Query("select distinct p from Project p join fetch p.projectSteps")
    List<Project> findAll();

}
