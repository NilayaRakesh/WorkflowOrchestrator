package com.nr.workfloworchestrator.core.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class WorkflowDefinition {
    private String name;
    private Set<WorkflowState> states;
    private String initialState;
    private List<WorkflowStateTransition> transitions;
}
