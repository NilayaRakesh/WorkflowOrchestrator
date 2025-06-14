package com.nr.workfloworchestrator.dbmongo.model;

import com.nr.workfloworchestrator.core.model.WorkflowStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Document("workflow_instances")
@Data
public class WorkflowInstanceMongoEntity {

    @Id
    private String workflowId;
    private String workflowName;
    private WorkflowStatus workflowStatus;
    private String state;
    private Map<String, Object> context;
    private Instant createdAt;
    private Instant updatedAt;
}
