package com.nr.workfloworchestrator.dbmongo.mapper;

import com.nr.workfloworchestrator.core.model.WorkflowInstance;
import com.nr.workfloworchestrator.dbmongo.model.WorkflowInstanceMongoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface WorkflowInstanceMapper {

    WorkflowInstanceMongoEntity toWorkflowInstanceMongoEntity(WorkflowInstance workflowInstance);

    WorkflowInstance toWorkflowInstance(WorkflowInstanceMongoEntity workflowInstanceMongoEntity);

}
