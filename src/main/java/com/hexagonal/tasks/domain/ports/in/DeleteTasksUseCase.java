package com.hexagonal.tasks.domain.ports.in;

public interface DeleteTasksUseCase {
    boolean deleteTasks(long id);
}
