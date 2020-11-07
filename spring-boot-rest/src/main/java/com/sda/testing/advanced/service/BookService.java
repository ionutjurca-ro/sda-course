package com.sda.testing.advanced.service;

import com.sda.testing.advanced.dto.BookMapper;
import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.dto.BookResponse;
import com.sda.testing.advanced.model.Book;
import com.sda.testing.advanced.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// deals with DTOs, not with entities
@Service
public class BookService {

    // need book repository
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    // save
    public BookResponse save(BookRequest bookRequest) {

        // convert dto to entity
        Book book = bookMapper.toEntity(bookRequest);

        Book savedBook = bookRepository.save(book);

        // convert entity to dto
        BookResponse bookResponse = bookMapper.toDto(savedBook);

        return bookResponse;
    }


    // find all
    public List<BookResponse> findAll() {
        List<Book> books = bookRepository.findAll();

        // convert each book to a response
        return books.stream().map(book -> bookMapper.toDto(book)).collect(Collectors.toList());
    }

    // find by id
    public BookResponse findById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("book not found"));
        return bookMapper.toDto(book);
    }

    // TODO: find by author using derived query

    // TODO: find by author using native query

    // find by author
    public List<BookResponse> findByAuthor(String author) {
        // TODO: var1: implement method in repository
//        return bookRepository.findByAuthor(author).stream()
//                .map(b -> bookMapper.toDto(b))
//                .collect(Collectors.toList());
        // var2: find all and filter
        return bookRepository.findAll().stream()
                .filter(book -> book.getAuthor().equals(author))
                .map(book -> bookMapper.toDto(book))
                .collect(Collectors.toList());
    }

    // update - boring version
    public BookResponse updateOld(Long id, BookRequest bookRequest) {
        // find book to update
        Book bookToUpdate = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));

        // update book details
        bookMapper.toEntity(bookToUpdate, bookRequest);

        // save in db
        Book book = bookRepository.save(bookToUpdate);

        //convert to dto
        return bookMapper.toDto(book);
    }

    // update  - medium version
    public BookResponse update2(Long id, BookRequest bookRequest) {
        // only if find returns optional
        return bookRepository.findById(id)
                // convert a book into an updated book
                .map(book -> bookMapper.toEntity(book, bookRequest))    // updated book
                // save to db
                .map(book -> bookRepository.save(book))     // saved book
                // to dto
                .map(book -> bookMapper.toDto(book))
                .orElseThrow(() -> new RuntimeException("book not found"));
    }

    // update - short version
    public BookResponse update(Long id, BookRequest bookRequest) {
        return bookRepository.findById(id)
                .map(book -> bookMapper.toEntity(book, bookRequest))
                .map(bookRepository::save)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new RuntimeException("book not found"));
    }

    // delete
    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}
