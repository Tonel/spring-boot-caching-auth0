package com.caching.demo.controllers;

import com.caching.demo.data.Author;
import com.caching.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(
            AuthorService authorService
    ) {
        this.authorService = authorService;
    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAll() {
        loggingMessage("Request received!");
        // retrieving the desired data
        List<Author> authors = authorService.retrieveAll();
        loggingMessage("Data retrieved!");

        return new ResponseEntity<>(
                authors,
                HttpStatus.OK
        );
    }

    private void loggingMessage(
            String message
    ) {
        System.out.printf("[%s] %s%n", java.time.LocalTime.now().truncatedTo(ChronoUnit.MILLIS), message);
    }
}
