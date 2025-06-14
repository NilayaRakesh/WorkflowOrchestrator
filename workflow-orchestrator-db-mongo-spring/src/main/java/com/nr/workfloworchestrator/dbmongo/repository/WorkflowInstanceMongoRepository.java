package com.nr.workfloworchestrator.dbmongo.repository;

import com.nr.workfloworchestrator.dbmongo.model.WorkflowInstanceMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WorkflowInstanceMongoRepository extends MongoRepository<WorkflowInstanceMongoEntity, String> {

    List<WorkflowInstanceMongoEntity> findByWorkflowName(String workflowName);

}
