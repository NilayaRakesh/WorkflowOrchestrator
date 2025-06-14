package com.nr.workfloworchestrator.app.service;

import com.nr.workfloworchestrator.core.model.WorkflowInstance;

import java.util.Map;

public interface WorkflowService {

    //TODO: accept and return DTOs instead of direct persistent objects
    WorkflowInstance createWorkflow(String workflowName, Map<String, Object> context);

    void transitWorkflows();
}
