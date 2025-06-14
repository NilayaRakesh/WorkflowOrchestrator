package com.nr.workfloworchestrator.core.exception;

public class NoSuchWorkflowDefinitionException extends RuntimeException {
    public NoSuchWorkflowDefinitionException(String message) {
        super(message);
    }
}
