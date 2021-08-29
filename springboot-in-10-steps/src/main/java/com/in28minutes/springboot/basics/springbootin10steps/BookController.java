package com.in28minutes.springboot.basics.springbootin10steps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/Books")
    public List<Book> getAllBooks() {
        return Arrays.asList(new Book(1L, "Mastering Spring 5.6", "Ranga Karana"));
    }
}
