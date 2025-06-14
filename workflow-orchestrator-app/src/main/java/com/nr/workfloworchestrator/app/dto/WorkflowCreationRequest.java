package com.nr.workfloworchestrator.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class WorkflowCreationRequest {

    private String workflowName;
    private Map<String, Object> context;
}
