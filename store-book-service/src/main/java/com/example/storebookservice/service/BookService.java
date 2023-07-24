package com.example.storebookservice.service;

import com.example.storebookservice.model.Book;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@EnableBinding(Sink.class)
@MessageEndpoint
public class BookService {

    Logger logger = Logger.getLogger(BookService.class.getName());

    @StreamListener(Sink.INPUT)
    public void logInputMessage(Book book) {
        logger.info("Input message processing: " + book);
    }
}
