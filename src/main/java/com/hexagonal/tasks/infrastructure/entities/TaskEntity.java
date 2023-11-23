package com.hexagonal.tasks.infrastructure.entities;

import com.hexagonal.tasks.domain.models.Tasks;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString
@Getter @Setter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

    public static TaskEntity fromDomainModel (Tasks tasks){
        return new TaskEntity(tasks.getId(), tasks.getTitle(),tasks.getDescription(), tasks.getCreationDate(), tasks.isCompleted());
    }

    public Tasks toDomainModel(){
        return new Tasks(id, title, description, creationDate,completed);
    }
}
