package com.hexagonal.tasks.domain.models;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString
public class Tasks {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

}
