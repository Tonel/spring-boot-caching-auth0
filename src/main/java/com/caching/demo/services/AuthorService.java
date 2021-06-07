package com.caching.demo.services;

import com.caching.demo.data.Author;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService {

    @Cacheable("authors")
    public List<Author> retrieveAll() {
        // simulating a delay due to the data retrieval operation
        try  {
            System.out.println("Retrieving all the authors...");
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // returning a list containing all the authors
        return Arrays.asList(
                new Author("Patricia", "Brown", null),
                new Author("James", "Smith", "1964-07-01"),
                new Author("Mary", "Williams", "1988-11-19")
        );
    }
}
