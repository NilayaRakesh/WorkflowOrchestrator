package com.nr.workfloworchestrator.core.service;

import com.nr.workfloworchestrator.core.config.WorkflowStateTransitionActionRegistry;
import com.nr.workfloworchestrator.core.exception.NoSuchWorkflowInstanceException;
import com.nr.workfloworchestrator.core.config.WorkflowDefinitionRegistry;
import com.nr.workfloworchestrator.core.model.WorkflowDefinition;
import com.nr.workfloworchestrator.core.model.WorkflowInstance;
import com.nr.workfloworchestrator.core.persistence.WorkflowInstancePersistence;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
public class WorkflowOrchestrator {

    private final WorkflowDefinitionRegistry workflowDefinitionRegistry;
    private final WorkflowStateTransitionActionRegistry actionRegistry;
    private final WorkflowInstancePersistence workflowInstancePersistence;

    //TODO: support bulk operations

    //TODO: support auto and manual actions

    public WorkflowInstance transitWorkflowInstanceState(WorkflowInstance workflowInstance) {
        WorkflowDefinition workflowDefinition = workflowDefinitionRegistry.getWorkflowDefinitionByName(workflowInstance.getWorkflowName());

        return Optional.ofNullable(workflowDefinition.getTransitions())
                .map(transitions -> transitions.stream()).orElse(Stream.empty())
                .filter(transition -> transition.getFrom().equals(workflowInstance.getState()))
                .findFirst()
                .map(transition -> {
                    WorkflowStateTransitionAction action = actionRegistry.getActionByName(transition.getActionName());
                    String outcome = action.executeFor(workflowInstance);
                    return transition.getOutcomesToNextState().get(outcome);
                })
                .map(nextState -> {
                    workflowInstance.setState(nextState, workflowDefinition);
                    return workflowInstancePersistence.update(workflowInstance);
                })
                .orElse(workflowInstance);
    }

    public WorkflowInstance createWorkflowInstance(String workflowName, Map<String, Object> context) {
        WorkflowDefinition workflowDefinition = workflowDefinitionRegistry.getWorkflowDefinitionByName(workflowName);
        WorkflowInstance workflowInstance = WorkflowInstance.newInstance(workflowDefinition, workflowDefinition.getInitialState(), context);
        return workflowInstancePersistence.create(workflowInstance);
    }

    public WorkflowInstance getWorkflowInstanceById(String workflowInstanceId) {
        return workflowInstancePersistence.findById(workflowInstanceId)
                .orElseThrow(() -> new NoSuchWorkflowInstanceException("No WorkflowInstance found with id %s".formatted(workflowInstanceId)));
    }

    //TODO: add functionality to search workflows

    public List<WorkflowInstance> getWorkflowInstances(String workflowName) {
        return workflowInstancePersistence.findByName(workflowName);
    }

    public List<WorkflowInstance> getAllWorkflowInstances() {
        return workflowInstancePersistence.findAll();
    }
}

