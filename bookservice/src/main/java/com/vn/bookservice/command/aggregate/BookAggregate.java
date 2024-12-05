package com.vn.bookservice.command.aggregate;

import com.vn.bookservice.command.command.CreatedBookCommand;
import com.vn.bookservice.command.event.BookCreatedEvent;
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
    public BookAggregate(CreatedBookCommand command) {
        BookCreatedEvent bookCreatedEvent = new BookCreatedEvent();

        System.out.println(">>>>>>>>>>>>>>>>>>>"+command.toString());
        BeanUtils.copyProperties(command, bookCreatedEvent);
//        bookCreatedEvent.setReady(command.getIsReady());
        System.out.println("???????????????????"+bookCreatedEvent.toString());

        AggregateLifecycle.apply(bookCreatedEvent);
    }

    @EventSourcingHandler
    public void on(BookCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.isReady = event.getIsReady();
    }
}
