package com.nr.workfloworchestrator.core.persistence;

import com.nr.workfloworchestrator.core.model.WorkflowInstance;

import java.util.List;
import java.util.Optional;

public interface WorkflowInstancePersistence {

    WorkflowInstance create(WorkflowInstance workflowInstance);

    WorkflowInstance update(WorkflowInstance updatedWorkflowInstance);

    Optional<WorkflowInstance> findById(String id);

    // TODO: Support pagination
    List<WorkflowInstance> findByName(String name);

    // TODO: Support pagination
    List<WorkflowInstance> findAll();
}
