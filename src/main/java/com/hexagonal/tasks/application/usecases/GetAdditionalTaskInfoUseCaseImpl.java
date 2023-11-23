package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(long taskId) {
        return externalServicePort.getAdditionalTaskInfo(taskId);
    }
}
