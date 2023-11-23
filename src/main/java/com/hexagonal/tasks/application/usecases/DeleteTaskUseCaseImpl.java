package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.ports.in.DeleteTasksUseCase;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTasksUseCase {
    private final TaskRepositoryPort taskRepositoryPort;



    @Override
    public boolean deleteTasks(long id) {
        return taskRepositoryPort.deleteById(id);
    }
}
