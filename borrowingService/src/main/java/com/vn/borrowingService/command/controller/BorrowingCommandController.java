package com.vn.borrowingService.command.controller;

import com.vn.borrowingService.command.command.CreateBorrowingCommand;
import com.vn.borrowingService.command.model.BorrowingCreateModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/borrowing")
public class BorrowingCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createBorrowing(@RequestBody BorrowingCreateModel borrowingCreateModel) {
        CreateBorrowingCommand createBorrowingCommand = new CreateBorrowingCommand(UUID.randomUUID().toString(),borrowingCreateModel.getBookId(),borrowingCreateModel.getEmployeeId(),borrowingCreateModel.getBorrowDate());
        return commandGateway.sendAndWait(createBorrowingCommand);

    }
}
