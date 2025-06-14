package com.nr.workfloworchestrator.dbmongo.service;

import com.nr.workfloworchestrator.dbmongo.mapper.WorkflowInstanceMapper;
import com.nr.workfloworchestrator.core.model.WorkflowInstance;
import com.nr.workfloworchestrator.dbmongo.model.WorkflowInstanceMongoEntity;
import com.nr.workfloworchestrator.core.persistence.WorkflowInstancePersistence;
import com.nr.workfloworchestrator.dbmongo.repository.WorkflowInstanceMongoRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class WorkflowInstanceMongoPersistence implements WorkflowInstancePersistence {

    private final WorkflowInstanceMongoRepository mongoRepository;
    private final WorkflowInstanceMapper mapper;

    @Override
    public WorkflowInstance create(WorkflowInstance workflowInstance) {
        WorkflowInstanceMongoEntity mongoEntity = mapper.toWorkflowInstanceMongoEntity(workflowInstance);
        WorkflowInstanceMongoEntity saved = mongoRepository.save(mongoEntity);
        return mapper.toWorkflowInstance(saved);
    }

    @Override
    public WorkflowInstance update(WorkflowInstance updatedWorkflowInstance) {
        WorkflowInstanceMongoEntity mongoEntity = mapper.toWorkflowInstanceMongoEntity(updatedWorkflowInstance);
        WorkflowInstanceMongoEntity saved = mongoRepository.save(mongoEntity);
        return mapper.toWorkflowInstance(saved);
    }

    @Override
    public Optional<WorkflowInstance> findById(String id) {
        return mongoRepository.findById(id)
                .map(mapper::toWorkflowInstance);
    }

    @Override
    public List<WorkflowInstance> findByName(String name) {
        return mongoRepository.findByWorkflowName(name).stream()
                .map(mapper::toWorkflowInstance)
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkflowInstance> findAll() {
        return mongoRepository.findAll().stream()
                .map(mapper::toWorkflowInstance)
                .collect(Collectors.toList());
    }
}
