package pl.mradziewicz.ToDo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Desctiption can not be null")
    private String description;
    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> groups;
    @OneToMany(mappedBy = "project")
    private Set<ProjectStep> projectSteps;
    public Project() {
    }

    public Set<TaskGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<TaskGroup> groups) {
        this.groups = groups;
    }

    public Set<ProjectStep> getProjectSteps() {
        return projectSteps;
    }

    public void setProjectSteps(Set<ProjectStep> projectSteps) {
        this.projectSteps = projectSteps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
