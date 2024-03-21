package com.example.demo.services;

import com.example.demo.models.Book;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BooksService {
    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter"));
        books.add(new Book("Animal Farm"));
        return books;
    }

    public Book getBook() {
        return new Book("Animal Farm");
    }
}
