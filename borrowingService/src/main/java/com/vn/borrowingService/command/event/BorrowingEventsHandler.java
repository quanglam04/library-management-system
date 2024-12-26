package com.vn.borrowingService.command.event;


import com.vn.borrowingService.command.data.Borrowing;
import com.vn.borrowingService.command.data.BorrowingRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BorrowingEventsHandler {
    @Autowired
    private BorrowingRepository borrowingRepository;
    @EventHandler
    public void on(BorrowingCreatedEvent event) {
        Borrowing borrowing = new Borrowing();
        borrowing.setId(event.getId());
        borrowing.setBorrowDate(event.getBorrowDate());
        borrowing.setBookId(event.getBookId());
        borrowing.setEmployeeId(event.getEmployeeId());
        borrowingRepository.save(borrowing);
    }
}
