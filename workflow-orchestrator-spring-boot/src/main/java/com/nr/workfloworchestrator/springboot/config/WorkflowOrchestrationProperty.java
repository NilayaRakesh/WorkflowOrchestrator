package com.nr.workfloworchestrator.springboot.config;

import com.nr.workfloworchestrator.core.config.WorkflowOrchestrationSettings;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("workflow-orchestration")
public class WorkflowOrchestrationProperty extends WorkflowOrchestrationSettings {
}
