package pl.mradziewicz.ToDo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Embeddable
class Audit {
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    public void prePersist(){
        createdOn = LocalDateTime.now();
    }
    @PreUpdate
    public void updateTime(){
        updatedOn = LocalDateTime.now();
    }
}
