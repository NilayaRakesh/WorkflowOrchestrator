package com.nr.workfloworchestrator.springboot.condition;

import com.nr.workfloworchestrator.core.config.WorkflowOrchestrationDb;

public class MongoDbCondition extends WorkflowOrchestratorDbCondition {

    @Override
    protected WorkflowOrchestrationDb getDbType() {
        return WorkflowOrchestrationDb.MONGO;
    }
}
