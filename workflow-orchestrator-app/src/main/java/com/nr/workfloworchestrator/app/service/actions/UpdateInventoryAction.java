package com.nr.workfloworchestrator.app.service.actions;

import com.nr.workfloworchestrator.core.model.WorkflowInstance;
import com.nr.workfloworchestrator.core.service.WorkflowStateTransitionAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateInventoryAction implements WorkflowStateTransitionAction {

    @Override
    public String getName() {
        return "updateInventory";
    }

    @Override
    public String executeFor(WorkflowInstance workflowInstance) {
        try {
            // code to update inventory
            log.info("Updated inventory for orderId={}", workflowInstance.getContext().get("orderId"));
            return "success";
        } catch (Exception e) {
            log.error("Error updating inventory for orderId={}", workflowInstance.getContext().get("orderId"));
            return "fail";
        }
    }
}
