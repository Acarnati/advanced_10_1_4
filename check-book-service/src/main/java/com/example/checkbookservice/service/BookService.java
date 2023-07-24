package com.example.checkbookservice.service;

import com.example.checkbookservice.model.Book;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@EnableBinding(Processor.class)
@MessageEndpoint
@Service
public class BookService {
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Book updateBook(Book book) {
        return Book.builder()
                .id(book.getId())
                .name(book.getName())
                .description(book.getDescription())
                .status("checked")
                .price(book.getPrice())
                .build();
    }
}
