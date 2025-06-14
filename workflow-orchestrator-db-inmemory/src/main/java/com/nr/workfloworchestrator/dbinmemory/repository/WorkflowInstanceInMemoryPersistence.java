package com.nr.workfloworchestrator.dbinmemory.repository;

import com.nr.workfloworchestrator.core.model.WorkflowInstance;
import com.nr.workfloworchestrator.core.persistence.WorkflowInstancePersistence;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class WorkflowInstanceInMemoryPersistence implements WorkflowInstancePersistence {

    private final Map<String, WorkflowInstance> workflowInstances = new HashMap<>();

    @Override
    public WorkflowInstance create(WorkflowInstance workflowInstance) {
        // TODO: add checks for create/update differences
        workflowInstance.setWorkflowId(UUID.randomUUID().toString());
        workflowInstance.setCreatedAt(Instant.now());
        workflowInstance.setUpdatedAt(Instant.now());
        workflowInstances.put(workflowInstance.getWorkflowId(), workflowInstance);
        return workflowInstance;
    }

    @Override
    public WorkflowInstance update(WorkflowInstance updatedWorkflowInstance) {
        // TODO: add check if exists
        updatedWorkflowInstance.setUpdatedAt(Instant.now());
        workflowInstances.put(updatedWorkflowInstance.getWorkflowId(), updatedWorkflowInstance);
        return updatedWorkflowInstance;
    }

    @Override
    public Optional<WorkflowInstance> findById(String id) {
        return Optional.ofNullable(workflowInstances.get(id));
    }

    @Override
    public List<WorkflowInstance> findByName(String name) {
        return workflowInstances.values().stream()
                .filter(workflowInstance -> workflowInstance.getWorkflowName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkflowInstance> findAll() {
        return new ArrayList<>(workflowInstances.values());
    }
}
