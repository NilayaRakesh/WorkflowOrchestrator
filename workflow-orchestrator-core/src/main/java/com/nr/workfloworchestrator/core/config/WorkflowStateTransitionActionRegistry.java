package com.nr.workfloworchestrator.core.config;

import com.nr.workfloworchestrator.core.exception.NoSuchStateTransitionActionException;
import com.nr.workfloworchestrator.core.service.WorkflowStateTransitionAction;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WorkflowStateTransitionActionRegistry {

    private final Map<String, WorkflowStateTransitionAction> actions;

    public WorkflowStateTransitionActionRegistry(List<WorkflowStateTransitionAction> actions) {
        this.actions = actions.stream()
                .collect(Collectors.toMap(action -> action.getName(), action -> action));
    }

    public WorkflowStateTransitionAction getActionByName(String name) {
        return Optional.ofNullable(actions.get(name))
                .orElseThrow(() -> new NoSuchStateTransitionActionException("No WorkflowStateTransitionAction found for name=%s".formatted(name)));

    }
}
