package com.sda.testing.advanced.controller;

import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.dto.BookResponse;
import com.sda.testing.advanced.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sda.testing.advanced.controller.BookController.API_BOOKS;

@RestController
@RequestMapping(API_BOOKS)
public class BookController {

    public static final String API_BOOKS = "/api/books";
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // create book
    @PostMapping   // 301 = CREATED
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest bookRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookService.save(bookRequest));
    }

    // get all books
    @GetMapping   // 200 = OK
    public ResponseEntity<List<BookResponse>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{author}")
    public ResponseEntity<List<BookResponse>> findByAuthor(@PathVariable(name = "author") String author) {
        return ResponseEntity.ok(bookService.findByAuthor(author));
    }

    // on error 404 = NOT FOUND
    // http://localhost:8081/api/books/{id}
    // get book
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findBook(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    // update book
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(@PathVariable("id") Long id, @RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.update(id, bookRequest));
    }

    //delete book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
    }

}
