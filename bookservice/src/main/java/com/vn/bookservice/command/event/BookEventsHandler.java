package com.vn.bookservice.command.event;


import com.vn.bookservice.command.data.Book;
import com.vn.bookservice.command.data.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookEventsHandler {

    @Autowired
    private BookRepository bookRepository;

    @EventHandler
    public void on(BookCreatedEvent event) {
        Book book = new Book();
        System.out.println(">>>>>>>>>>>>>>>>>>>>"+event.toString());
//        BeanUtils.copyProperties(event, book);
        book.setName(event.getName());
        book.setAuthor(event.getAuthor());
        book.setIsReady(event.getIsReady());
        System.out.println(">>>>>>>>>>>>>>>>>>>>"+book.toString());
        bookRepository.save(book);
    }
}
