package com.nr.workfloworchestrator.app.service;

import com.nr.workfloworchestrator.core.model.WorkflowInstance;
import com.nr.workfloworchestrator.core.service.WorkflowOrchestrator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowOrchestrator workflowOrchestrator;

    @Override
    public WorkflowInstance createWorkflow(String workflowName, Map<String, Object> context) {
        return workflowOrchestrator.createWorkflowInstance(workflowName, context);
    }

    @Override
    public void transitWorkflows() {
        //TODO: in parallel
        workflowOrchestrator.getAllWorkflowInstances()
                .forEach(workflowOrchestrator::transitWorkflowInstanceState);
    }
}
