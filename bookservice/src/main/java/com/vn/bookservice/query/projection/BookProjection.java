package com.vn.bookservice.query.projection;


import com.vn.bookservice.command.data.Book;
import com.vn.bookservice.command.data.BookRepository;
import com.vn.bookservice.query.model.BookResponseModel;
import com.vn.bookservice.query.queries.GetAllBookQuery;
import com.vn.bookservice.query.queries.GetBookById;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProjection {

    @Autowired
    private BookRepository bookRepository;

    @QueryHandler
    public List<BookResponseModel> handle(GetAllBookQuery getAllBookQuery) {
        List<Book> list = bookRepository.findAll();
        List<BookResponseModel> listBookResponse = new ArrayList<>();
        list.forEach(book -> {
            BookResponseModel bookResponseModel = new BookResponseModel();
            BeanUtils.copyProperties(book, bookResponseModel);
            listBookResponse.add(bookResponseModel);
        });

        return listBookResponse;
    }

    @QueryHandler
    public BookResponseModel handle(GetBookById getBookById) throws Exception {
        BookResponseModel bookResponseModel = new BookResponseModel();
        Book book =  bookRepository.findById(getBookById.getId()).orElseThrow(() ->
            new Exception("Not found Book with BookId: "+getBookById.getId())
        );
        BeanUtils.copyProperties(book, bookResponseModel);

        return bookResponseModel;
    }

}
