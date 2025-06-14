package com.nr.workfloworchestrator.app;

import com.nr.workfloworchestrator.springboot.annotation.EnableWorkflowOrchestrator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
@EnableWorkflowOrchestrator
public class WorkflowOrchestratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkflowOrchestratorApplication.class, args);
    }
}
