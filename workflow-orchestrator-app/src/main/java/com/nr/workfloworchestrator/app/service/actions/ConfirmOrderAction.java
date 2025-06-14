package com.nr.workfloworchestrator.app.service.actions;

import com.nr.workfloworchestrator.core.model.WorkflowInstance;
import com.nr.workfloworchestrator.core.service.WorkflowStateTransitionAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ConfirmOrderAction implements WorkflowStateTransitionAction {

    @Override
    public String getName() {
        return "confirmOrder";
    }

    @Override
    public String executeFor(WorkflowInstance workflowInstance) {
        try {
            // code to confirm order
            String commEmailId = UUID.randomUUID().toString();
            workflowInstance.getContext().put("orderConfirmedCommEmailId", commEmailId);
            log.info("Order confirmed for orderId={}", workflowInstance.getContext().get("orderId"));
            return "success";
        } catch (Exception e) {
            log.error("Error confirming order for orderId={}", workflowInstance.getContext().get("orderId"));
            return "fail";
        }
    }
}
