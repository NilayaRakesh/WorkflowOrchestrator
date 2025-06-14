package com.nr.workfloworchestrator.app.service.actions;

import com.nr.workfloworchestrator.core.model.WorkflowInstance;
import com.nr.workfloworchestrator.core.service.WorkflowStateTransitionAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ConfirmPaymentAction implements WorkflowStateTransitionAction {

    @Override
    public String getName() {
        return "confirmPayment";
    }

    @Override
    public String executeFor(WorkflowInstance workflowInstance) {
        try {
            // code to process payment
            String transactionId = UUID.randomUUID().toString();
            workflowInstance.getContext().put("transactionId", transactionId);
            log.info("Payment processed for orderId={}", workflowInstance.getContext().get("orderId"));
            return "success";
        } catch (Exception e) {
            log.error("Error processing payment for orderId={}", workflowInstance.getContext().get("orderId"));
            return "fail";
        }
    }
}
