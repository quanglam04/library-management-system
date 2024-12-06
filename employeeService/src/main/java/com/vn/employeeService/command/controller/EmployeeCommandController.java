package com.vn.employeeService.command.controller;


import com.vn.employeeService.command.command.CreateEmployeeCommand;
import com.vn.employeeService.command.data.Employee;
import com.vn.employeeService.command.model.EmployeeCreateModel;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addEmployee(@Valid @RequestBody EmployeeCreateModel employeeCreateModel ) {
        CreateEmployeeCommand command = new CreateEmployeeCommand(UUID.randomUUID().toString(),employeeCreateModel.getFirstName(),employeeCreateModel.getLastName(),employeeCreateModel.getKin(),false);
        return commandGateway.sendAndWait(command);

    }
}
