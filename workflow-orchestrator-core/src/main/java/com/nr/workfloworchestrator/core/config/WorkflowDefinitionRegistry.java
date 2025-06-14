package com.nr.workfloworchestrator.core.config;

import com.nr.workfloworchestrator.core.exception.NoSuchWorkflowDefinitionException;
import com.nr.workfloworchestrator.core.model.WorkflowDefinition;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WorkflowDefinitionRegistry {

    private final Map<String, WorkflowDefinition> workflowDefinitions;

    public WorkflowDefinitionRegistry(WorkflowOrchestrationSettings workflowOrchestrationSettings) {
        this.workflowDefinitions = Optional.ofNullable(workflowOrchestrationSettings.getWorkflowDefinitions())
                .map(definitions -> definitions.stream()
                        .collect(Collectors.toMap(definition -> definition.getName(), definition -> definition)))
                .orElse(Collections.emptyMap());
    }

    public List<WorkflowDefinition> getAllWorkflowDefinitions() {
        return (List<WorkflowDefinition>) workflowDefinitions.values();
    }

    public WorkflowDefinition getWorkflowDefinitionByName(String name) {
        return Optional.ofNullable(workflowDefinitions.get(name))
                .orElseThrow(() -> new NoSuchWorkflowDefinitionException("No WorkflowDefinition found with name %s".formatted(name)));
    }
}
