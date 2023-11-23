package com.hexagonal.tasks.application.services;


import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.models.Tasks;
import com.hexagonal.tasks.domain.ports.in.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TaskService implements  CreateTasksUseCase, RetrieveTaskUseCase,UpdateTasksUseCase, DeleteTasksUseCase, GetAdditionalTaskInfoUseCase{
    private final CreateTasksUseCase createTasksUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTasksUseCase updateTasksUseCase;
    private final DeleteTasksUseCase deleteTasksUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;


    @Override
    public Tasks createTask(Tasks tasks) {
        return createTasksUseCase.createTask(tasks);
    }

    @Override
    public boolean deleteTasks(long id) {
        return deleteTasksUseCase.deleteTasks(id);
    }

    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(long taskId) {
        return getAdditionalTaskInfoUseCase.getAdditionalTasksInfo(taskId);
    }

    @Override
    public Optional<Tasks> getTaskById(long id) {
        return retrieveTaskUseCase.getTaskById(id);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Tasks> updateTasks(long id, Tasks newTasks) {
        return updateTasksUseCase.updateTasks(id,newTasks);
    }
}
