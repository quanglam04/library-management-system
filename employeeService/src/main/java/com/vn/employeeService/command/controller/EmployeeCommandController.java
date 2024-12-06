package com.vn.employeeService.command.controller;


import com.vn.employeeService.command.command.CreateEmployeeCommand;
import com.vn.employeeService.command.command.DeleteEmployeeCommand;
import com.vn.employeeService.command.command.UpdateEmployeeCommand;
import com.vn.employeeService.command.data.Employee;
import com.vn.employeeService.command.event.EmployeeUpdatedEvent;
import com.vn.employeeService.command.model.EmployeeCreateModel;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public String updateEmployee(@Valid @RequestBody EmployeeUpdatedEvent employeeUpdatedEvent , @PathVariable("id") String id) {
        UpdateEmployeeCommand command = new UpdateEmployeeCommand(id,employeeUpdatedEvent.getFirstName(),employeeUpdatedEvent.getLastName(),employeeUpdatedEvent.getKin(),employeeUpdatedEvent.getDisliplined());
        return commandGateway.sendAndWait(command);


    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") String id) {
        DeleteEmployeeCommand command = new DeleteEmployeeCommand(id);
        return commandGateway.sendAndWait(command);
    }
}
