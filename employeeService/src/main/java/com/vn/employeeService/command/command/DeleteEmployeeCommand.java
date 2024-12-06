package com.vn.employeeService.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteEmployeeCommand {
    @TargetAggregateIdentifier
    private String id;
    public DeleteEmployeeCommand(String id) {
        this.id = id;
    }
    public DeleteEmployeeCommand() {}
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
