package com.hexagonal.tasks.domain.ports.in;

import com.hexagonal.tasks.domain.models.Tasks;

public interface CreateTasksUseCase {
    Tasks createTask(Tasks tasks);
}
