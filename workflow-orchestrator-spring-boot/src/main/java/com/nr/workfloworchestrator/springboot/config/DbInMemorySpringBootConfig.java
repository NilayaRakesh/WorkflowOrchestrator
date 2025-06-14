package com.nr.workfloworchestrator.springboot.config;

import com.nr.workfloworchestrator.dbinmemory.repository.WorkflowInstanceInMemoryPersistence;
import com.nr.workfloworchestrator.springboot.condition.InMemoryDbCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(InMemoryDbCondition.class)
public class DbInMemorySpringBootConfig {

    @Bean
    public WorkflowInstanceInMemoryPersistence workflowInstanceInMemoryPersistence() {
        return new WorkflowInstanceInMemoryPersistence();
    }
}
