package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.Tasks;
import com.hexagonal.tasks.domain.ports.in.UpdateTasksUseCase;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTasksUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Tasks> updateTasks(long id, Tasks newTasks) {
        return taskRepositoryPort.update(newTasks);
    }
}
