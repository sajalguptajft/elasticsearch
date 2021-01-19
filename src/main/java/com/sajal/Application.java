package com.sajal;

import com.sajal.book.model.Book;
import com.sajal.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override public void run(String... args) {

        bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa1", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa2", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa3", "21-MAR-2017"));

        final Page<Book> books = bookService.findByAuthor("Rambabu", PageRequest.of(0, 10));
        books.forEach(System.out::println);
    }

}