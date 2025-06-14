package com.nr.workfloworchestrator.springboot.condition;

import com.nr.workfloworchestrator.core.config.WorkflowOrchestrationDb;
import com.nr.workfloworchestrator.core.config.WorkflowOrchestrationSettings;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public abstract class WorkflowOrchestratorDbCondition implements Condition {

    protected abstract WorkflowOrchestrationDb getDbType();

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Binder binder = Binder.get(context.getEnvironment());
        BindResult<WorkflowOrchestrationSettings> SettingBind = binder.bind("workflow-orchestration", WorkflowOrchestrationSettings.class);

        if (SettingBind.isBound()) {
            WorkflowOrchestrationSettings settings = SettingBind.get();
            return getDbType() == settings.getDb();
        }
        return false;
    }
}
