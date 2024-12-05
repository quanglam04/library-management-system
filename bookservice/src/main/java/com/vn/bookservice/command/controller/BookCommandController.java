package com.vn.bookservice.command.controller;

import com.vn.bookservice.command.command.CreatedBookCommand;
import com.vn.bookservice.command.model.BookRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@RequestBody BookRequestModel bookRequestModel) {
        CreatedBookCommand command = new CreatedBookCommand(UUID.randomUUID().toString(),bookRequestModel.getName(),bookRequestModel.getAuthor(),true);
        return commandGateway.sendAndWait(command);
    }
}
