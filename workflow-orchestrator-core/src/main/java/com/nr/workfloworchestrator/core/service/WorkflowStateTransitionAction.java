package com.nr.workfloworchestrator.core.service;

import com.nr.workfloworchestrator.core.model.WorkflowInstance;

public interface WorkflowStateTransitionAction {

    //TODO: distinguish between auto and manual actions

    String getName();

    String executeFor(WorkflowInstance workflowInstance);
}
