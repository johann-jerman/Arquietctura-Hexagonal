package com.hexagonal.tasks.infrastructure.repositories;

import com.hexagonal.tasks.domain.models.Tasks;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.entities.TaskEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {
    private final JpaTaskRepository jpaTaskRepository;

    @Override
    public Tasks save(Tasks task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity saveTaskEntity = jpaTaskRepository.save(taskEntity);
        return saveTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Tasks> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Tasks> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Tasks> update( Tasks task) {
        if (jpaTaskRepository.existsById(task.getId())){
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity updeteTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(updeteTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaTaskRepository.existsById(id)){
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
