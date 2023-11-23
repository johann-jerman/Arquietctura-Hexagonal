package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.Tasks;
import com.hexagonal.tasks.domain.ports.in.CreateTasksUseCase;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTasksUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Tasks createTask(Tasks tasks) {
        return taskRepositoryPort.save(tasks);
    }
}
