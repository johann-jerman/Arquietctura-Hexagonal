package com.hexagonal.tasks.domain.ports.in;

import com.hexagonal.tasks.domain.models.Tasks;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Tasks> getTaskById (long id);
    List<Tasks> getAllTasks();
}
