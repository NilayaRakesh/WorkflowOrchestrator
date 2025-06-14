package com.nr.workfloworchestrator.core.exception;

public class NoSuchWorkflowInstanceException extends RuntimeException {
    public NoSuchWorkflowInstanceException(String message) {
        super(message);
    }
}
