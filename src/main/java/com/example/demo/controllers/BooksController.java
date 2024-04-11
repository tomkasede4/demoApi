package com.example.demo.controllers;

import com.example.demo.configurations.MeterConfigs;
import com.example.demo.models.Book;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.BooksService;

import java.util.List;

@RestController
@RequestMapping("/books")
@Timed
public class BooksController {
    @Autowired
    Counter counter;
    @Autowired
    BooksService service;
    Logger log = LoggerFactory.getLogger(BooksController.class);


    @GetMapping("/getbooks")
    @Timed(
            value="get_all_books.requests",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99}
    )
    public ResponseEntity<?> getAllBooks(){
        counter.increment();
        log.info("getBooks");
        List<Book> response = service.getAllBooks();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getbook")
    @Timed(
            value="get_book_by_title.requests",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95,0.99}
    )
    public ResponseEntity<?> getBookByTitle(){
        counter.increment();
        log.info("getBook");
        Book response = service.getBook();
        return ResponseEntity.ok(response);
    }

}
