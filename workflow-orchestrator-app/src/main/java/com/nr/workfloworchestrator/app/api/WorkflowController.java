package com.nr.workfloworchestrator.app.api;

import com.nr.workfloworchestrator.app.dto.WorkflowActionRequest;
import com.nr.workfloworchestrator.app.dto.WorkflowCreationRequest;
import com.nr.workfloworchestrator.app.service.WorkflowService;
import com.nr.workfloworchestrator.core.model.WorkflowInstance;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/workflows")
@AllArgsConstructor
public class WorkflowController {

    private final WorkflowService workflowService;

    @PostMapping
    public ResponseEntity<WorkflowInstance> createWorkflow(@RequestBody WorkflowCreationRequest workflowCreationRequest) {
        WorkflowInstance createdWorkflow = workflowService.createWorkflow(
                workflowCreationRequest.getWorkflowName(), workflowCreationRequest.getContext());
        return ResponseEntity.ok(createdWorkflow);
    }

    //TODO: add api to search workflows

    @PostMapping("/actions")
    public ResponseEntity<Void> workflowActions(@RequestBody WorkflowActionRequest workflowActionRequest) {
        switch (workflowActionRequest.getActionType()) {
            case TRANSIT_ALL_WORKFLOWS -> {
                //TODO: do asynchronously
                workflowService.transitWorkflows();
                return ResponseEntity.ok().build();
            }
            default -> {
                return ResponseEntity.badRequest().build();
            }
        }
    }
}
