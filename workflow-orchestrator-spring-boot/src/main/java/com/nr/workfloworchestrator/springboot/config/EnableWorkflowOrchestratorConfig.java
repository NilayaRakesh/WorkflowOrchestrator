package com.nr.workfloworchestrator.springboot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties({WorkflowOrchestrationProperty.class})
@Import({
        CoreSpringBootConfig.class,
        DisableAutoMongoConfig.class,
        DbMongoSpringBootConfig.class,
        DbInMemorySpringBootConfig.class
})
public class EnableWorkflowOrchestratorConfig {

}
