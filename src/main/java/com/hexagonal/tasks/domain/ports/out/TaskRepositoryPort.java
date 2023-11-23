package com.hexagonal.tasks.domain.ports.out;

import com.hexagonal.tasks.domain.models.Tasks;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Tasks save(Tasks task);
    Optional<Tasks> findById(Long id);
    List<Tasks> findAll();
    Optional<Tasks> update(Tasks task);
    boolean deleteById(Long id);
}
