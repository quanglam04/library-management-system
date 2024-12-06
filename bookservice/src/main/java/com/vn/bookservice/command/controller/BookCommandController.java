package com.vn.bookservice.command.controller;

import com.vn.bookservice.command.command.CreatedBookCommand;
import com.vn.bookservice.command.command.DeleteBookCommand;
import com.vn.bookservice.command.command.UpdateBookCommand;
import com.vn.bookservice.command.model.BookRequestModel;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addBook(@Valid @RequestBody BookRequestModel bookRequestModel) {
        CreatedBookCommand command = new CreatedBookCommand(UUID.randomUUID().toString(),bookRequestModel.getName(),bookRequestModel.getAuthor(),true);
        return commandGateway.sendAndWait(command);
    }

    @PutMapping("/{id}")
    public String updateBook(@RequestBody BookRequestModel bookRequestModel,@PathVariable String id) {
        UpdateBookCommand command = new UpdateBookCommand(id,bookRequestModel.getName(),bookRequestModel.getAuthor(),bookRequestModel.getIsReady());
        return commandGateway.sendAndWait(command);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        DeleteBookCommand command = new DeleteBookCommand(id);
        return commandGateway.sendAndWait(command);
    }
}
