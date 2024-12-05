package com.vn.bookservice.command.aggregate;

import com.vn.bookservice.command.command.CreatedBookCommand;
import com.vn.bookservice.command.command.DeleteBookCommand;
import com.vn.bookservice.command.command.UpdateBookCommand;
import com.vn.bookservice.command.event.BookCreatedEvent;
import com.vn.bookservice.command.event.BookDeletedEvent;
import com.vn.bookservice.command.event.BookUpdatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@NoArgsConstructor
public class BookAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String author;
    private Boolean isReady;

    @CommandHandler
    public void handle(CreatedBookCommand command) {
        BookCreatedEvent bookCreatedEvent = new BookCreatedEvent();

//        System.out.println(">>>>>>>>>>>>>>>>>>>"+command.toString());
        BeanUtils.copyProperties(command, bookCreatedEvent);
//        bookCreatedEvent.setReady(command.getIsReady());
//        System.out.println("???????????????????"+bookCreatedEvent.toString());

        AggregateLifecycle.apply(bookCreatedEvent);
    }

    @CommandHandler
    public void handle(UpdateBookCommand command) {
        BookUpdatedEvent bookUpdatedEvent = new BookUpdatedEvent();
        BeanUtils.copyProperties(command, bookUpdatedEvent);
        AggregateLifecycle.apply(bookUpdatedEvent);
    }

    @CommandHandler
    public void handle(DeleteBookCommand command) {
        BookDeletedEvent bookDeletedEvent = new BookDeletedEvent();
        BeanUtils.copyProperties(command, bookDeletedEvent);
        AggregateLifecycle.apply(bookDeletedEvent);
    }

    @EventSourcingHandler
    public void on(BookCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
    }

    @EventSourcingHandler
    public void on(BookUpdatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
    }

    @EventSourcingHandler
    public void on(BookDeletedEvent event) {
        this.id = event.getId();

    }
}
