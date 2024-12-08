package com.vn.employeeService.command.controller;


import com.vn.employeeService.command.command.CreateEmployeeCommand;
import com.vn.employeeService.command.command.DeleteEmployeeCommand;
import com.vn.employeeService.command.command.UpdateEmployeeCommand;
import com.vn.employeeService.command.event.EmployeeUpdatedEvent;
import com.vn.employeeService.command.model.EmployeeCreateModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
@Tag(name = "Employee Command")
public class EmployeeCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @Operation(
            summary = "Add new Employee",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized / Invalid Token"
                    )
            }
    )
    @PostMapping
    public String addEmployee(@Valid @RequestBody EmployeeCreateModel employeeCreateModel ) {
        CreateEmployeeCommand command = new CreateEmployeeCommand(UUID.randomUUID().toString(),employeeCreateModel.getFirstName(),employeeCreateModel.getLastName(),employeeCreateModel.getKin(),false);
        return commandGateway.sendAndWait(command);

    }

    @Operation(
            summary = "Update employee",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized / Invalid Token"
                    )
            }
    )
    @PutMapping("/{id}")
    public String updateEmployee(@Valid @RequestBody EmployeeUpdatedEvent employeeUpdatedEvent , @PathVariable String id) {
        UpdateEmployeeCommand command = new UpdateEmployeeCommand(id,employeeUpdatedEvent.getFirstName(),employeeUpdatedEvent.getLastName(),employeeUpdatedEvent.getKin(),employeeUpdatedEvent.getDisliplined());
        return commandGateway.sendAndWait(command);


    }

    @Operation(
            summary = "Delete employee",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized / Invalid Token"
                    )
            }
    )
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") String id) {
        DeleteEmployeeCommand command = new DeleteEmployeeCommand(id);
        return commandGateway.sendAndWait(command);
    }
}
