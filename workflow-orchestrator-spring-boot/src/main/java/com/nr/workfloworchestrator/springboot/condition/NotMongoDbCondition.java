package com.nr.workfloworchestrator.springboot.condition;

import com.nr.workfloworchestrator.core.config.WorkflowOrchestrationDb;

public class NotMongoDbCondition extends WorkflowOrchestratorNotDbCondition {

    @Override
    protected WorkflowOrchestrationDb getDbType() {
        return WorkflowOrchestrationDb.MONGO;
    }
}
