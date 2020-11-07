package com.sda.testing.advanced.service;

import com.sda.testing.advanced.dto.BookMapper;
import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.dto.BookResponse;
import com.sda.testing.advanced.model.Book;
import com.sda.testing.advanced.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Mock
    BookMapper bookMapper;

    @InjectMocks
    BookService bookService;

    // functional test
    // unit test
    // if has dependencies, use mocks
    @Test
    void givenBookRequest_whenSave_thenReturnBookResponse() {
        // given
        BookRequest request = new BookRequest();
        request.setTitle("game of thrones");
        request.setAuthor("george martin");
        request.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse expected = new BookResponse();
        expected.setTitle("game of thrones");
        expected.setAuthor("george martin");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        Book mockBook = new Book();
        mockBook.setTitle("game of thrones");
        mockBook.setAuthor("george martin");
        mockBook.setPublished(LocalDate.of(2000, 6, 30));

        when(bookMapper.toEntity(any(BookRequest.class)))
                .thenReturn(mockBook);
        when(bookRepository.save(any(Book.class)))
                .thenReturn(mockBook);
        when(bookMapper.toDto(any(Book.class)))
                .thenReturn(expected);

        // when
        BookResponse actual = bookService.save(request);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenExistingBook_whenSave_thenThrowException() {
        // given
        String sameTitle = "game of thrones";

        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle(sameTitle);
        bookRequest.setAuthor("george martin");
        bookRequest.setPublished(LocalDate.of(2000, 6, 30));

        Book mockBook = new Book();
        mockBook.setTitle(sameTitle);

        when(bookRepository.findByTitle(anyString()))
                .thenReturn(Optional.of(mockBook));
        // then
        // check that exception is thrown
        Assertions.assertThrows(RuntimeException.class,
                // when
                () -> bookService.save(bookRequest));
    }

    @Test
    void givenListBook_whenFindAll_thenReturnListBookResponse() {
        Book mockBook = new Book();
        mockBook.setTitle("game of thrones");
        mockBook.setAuthor("george martin");
        mockBook.setPublished(LocalDate.of(2000, 6, 30));
        List<Book> books = new ArrayList<>();
        books.add(mockBook);

        BookResponse bookResponse = new BookResponse();
        bookResponse.setTitle("game of thrones");
        bookResponse.setAuthor("george martin");
        bookResponse.setPublished(LocalDate.of(2000, 6, 30));
        List<BookResponse> expected = new ArrayList<>();
        expected.add(bookResponse);

        when(bookRepository.findAll())
                .thenReturn(books);
        when(books.stream().map(book -> bookMapper.toDto(any(Book.class))).collect(Collectors.toList()))
                .thenReturn(expected);

        List<BookResponse> actual = bookService.findAll();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenBook_whenFindById_thenReturnBookResponse() {
        Long id = 1L;
        Book mockBook = new Book();
        mockBook.setId(id);
        mockBook.setTitle("game of thrones");
        mockBook.setAuthor("george martin");
        mockBook.setPublished(LocalDate.of(2000, 6, 30));


        BookResponse expected = new BookResponse();
        expected.setId(id);
        expected.setTitle("game of thrones");
        expected.setAuthor("george martin");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        when(bookRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(mockBook));
        when(bookMapper.toDto(any(Book.class)))
                .thenReturn(expected);

        BookResponse actual = bookService.findById(id);

        assertThat(actual).isEqualTo(expected);
    }
}