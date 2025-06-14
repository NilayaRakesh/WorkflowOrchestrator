package com.nr.workfloworchestrator.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
public class WorkflowInstance {

    private String workflowId;
    private String workflowName;
    private WorkflowStatus workflowStatus;
    private String state;
    private Map<String, Object> context;
    private Instant createdAt;
    private Instant updatedAt;

    public static WorkflowInstance newInstance(WorkflowDefinition workflowDefinition, String initialState, Map<String, Object> context) {
        WorkflowInstance instance = new WorkflowInstance();
        instance.workflowId = UUID.randomUUID().toString();
        instance.workflowName = workflowDefinition.getName();
        instance.workflowStatus = WorkflowStatus.ACTIVE;
        instance.setState(initialState, workflowDefinition);
        instance.context = (context != null) ? context : new HashMap<>();
        return instance;
    }

    public void setState(String state, WorkflowDefinition workflowDefinition) {
        this.setState(state);
        if (isInFinalState(workflowDefinition)) {
            this.setWorkflowStatus(WorkflowStatus.COMPLETE);
        }
    }

    private boolean isInFinalState(WorkflowDefinition workflowDefinition) {
        return Optional.ofNullable(workflowDefinition.getTransitions())
                .map(transitions -> transitions.stream()).orElse(Stream.empty())
                .noneMatch(transition -> transition.getFrom().equals(this.state));
    }
}
