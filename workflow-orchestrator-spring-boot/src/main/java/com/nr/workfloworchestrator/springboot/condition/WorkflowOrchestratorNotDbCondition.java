package com.nr.workfloworchestrator.springboot.condition;

import com.nr.workfloworchestrator.core.config.WorkflowOrchestrationDb;
import com.nr.workfloworchestrator.core.config.WorkflowOrchestrationSettings;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public abstract class WorkflowOrchestratorNotDbCondition implements Condition {

    protected abstract WorkflowOrchestrationDb getDbType();

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Binder binder = Binder.get(context.getEnvironment());
        BindResult<WorkflowOrchestrationSettings> settingBind = binder.bind("workflow-orchestration", WorkflowOrchestrationSettings.class);

        return !settingBind.isBound()
                || null == getDbType()
                || settingBind.get().getDb() != getDbType();

        // match if missing/null ensures it doesn't interfere with client's custom mongo config
        // if it doesn't want to use the spring-boot module at all
    }
}
