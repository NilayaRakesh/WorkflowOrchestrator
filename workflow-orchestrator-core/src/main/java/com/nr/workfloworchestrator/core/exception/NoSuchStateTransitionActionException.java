package com.nr.workfloworchestrator.core.exception;

public class NoSuchStateTransitionActionException extends RuntimeException {
    public NoSuchStateTransitionActionException(String message) {
        super(message);
    }
}
