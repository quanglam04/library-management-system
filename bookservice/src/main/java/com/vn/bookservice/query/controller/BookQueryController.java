package com.vn.bookservice.query.controller;


import com.vn.bookservice.command.model.BookRequestModel;
import com.vn.bookservice.query.model.BookResponseModel;
import com.vn.bookservice.query.queries.GetAllBookQuery;
import com.vn.bookservice.query.queries.GetBookById;
import com.vn.commonService.services.KafkaService;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
public class BookQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @Autowired
    private KafkaService kafkaService;

    @GetMapping
    public List<BookResponseModel> getAllBook(){
        GetAllBookQuery query = new GetAllBookQuery();
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(BookResponseModel.class)).join();

    }

    @GetMapping("/{id}")
    public BookResponseModel getBookById(@PathVariable("id") String id){
        GetBookById query = new GetBookById(id);
        return queryGateway.query(query, ResponseTypes.instanceOf(BookResponseModel.class)).join();
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody String message ){
        kafkaService.sendMessage("test",message);
    }



}
