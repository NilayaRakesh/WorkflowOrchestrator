package com.nr.workfloworchestrator.springboot.condition;

import com.nr.workfloworchestrator.core.config.WorkflowOrchestrationDb;

public class InMemoryDbCondition extends WorkflowOrchestratorDbCondition {

    @Override
    protected WorkflowOrchestrationDb getDbType() {
        return WorkflowOrchestrationDb.IN_MEMORY;
    }
}
