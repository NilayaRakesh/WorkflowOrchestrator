package com.nr.workfloworchestrator.springboot.config;

import com.nr.workfloworchestrator.core.config.WorkflowDefinitionRegistry;
import com.nr.workfloworchestrator.core.config.WorkflowOrchestrationSettings;
import com.nr.workfloworchestrator.core.config.WorkflowStateTransitionActionRegistry;
import com.nr.workfloworchestrator.core.persistence.WorkflowInstancePersistence;
import com.nr.workfloworchestrator.core.service.WorkflowOrchestrator;
import com.nr.workfloworchestrator.core.service.WorkflowStateTransitionAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CoreSpringBootConfig {

    @Bean
    WorkflowOrchestrator workflowOrchestratorService(WorkflowDefinitionRegistry workflowDefinitionRegistry,
                                                     WorkflowStateTransitionActionRegistry workflowStateTransitionActionRegistry,
                                                     WorkflowInstancePersistence workflowInstancePersistence) {
        return new WorkflowOrchestrator(workflowDefinitionRegistry, workflowStateTransitionActionRegistry, workflowInstancePersistence);
    }

    @Bean
    WorkflowStateTransitionActionRegistry workflowStateTransitionActionRegistry(List<WorkflowStateTransitionAction> actions) {
        return new WorkflowStateTransitionActionRegistry(actions);
    }

    @Bean
    WorkflowDefinitionRegistry workflowDefinitionRegistry(WorkflowOrchestrationSettings workflowOrchestrationSettings) {
        return new WorkflowDefinitionRegistry(workflowOrchestrationSettings);
    }
}
