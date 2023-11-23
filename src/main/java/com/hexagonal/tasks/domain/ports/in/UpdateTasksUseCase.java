package com.hexagonal.tasks.domain.ports.in;


import com.hexagonal.tasks.domain.models.Tasks;

import java.util.Optional;

public interface UpdateTasksUseCase {
    Optional<Tasks> updateTasks(long id, Tasks newTasks);
}
