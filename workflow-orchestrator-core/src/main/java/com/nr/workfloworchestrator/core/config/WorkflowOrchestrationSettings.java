package com.nr.workfloworchestrator.core.config;

import com.nr.workfloworchestrator.core.model.WorkflowDefinition;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkflowOrchestrationSettings {

    private WorkflowOrchestrationDb db;
    private List<WorkflowDefinition> workflowDefinitions;
}
