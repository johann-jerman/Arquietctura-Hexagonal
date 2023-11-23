package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.Tasks;
import com.hexagonal.tasks.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Tasks> getTaskById(long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
