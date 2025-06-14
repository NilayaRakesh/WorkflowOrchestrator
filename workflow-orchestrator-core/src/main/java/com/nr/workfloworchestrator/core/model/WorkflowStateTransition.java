package com.nr.workfloworchestrator.core.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class WorkflowStateTransition {
    private String from;
    private String actionName;
    private Map<String, String> outcomesToNextState;
}
