package com.vn.bookservice.command.event;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BookDeletedEvent {

    @TargetAggregateIdentifier
    private String id;
    public BookDeletedEvent(String id) {
        this.id = id;
    }

    public BookDeletedEvent() {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


}
