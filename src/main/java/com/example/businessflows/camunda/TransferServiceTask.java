package com.example.businessflows.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.spring.boot.starter.annotation.ProcessApplication;
import org.springframework.stereotype.Component;

@Component
@ProcessApplication
public class TransferServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        // Simulate transfer logic
        execution.setVariable("transferStatus", "COMPLETED");
    }
}
