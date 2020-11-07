package com.sda.testing.advanced.dto;

import com.sda.testing.advanced.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookMapperTest {

    BookMapper bookMapper;

    @BeforeEach
    void setUp() {
        bookMapper = new BookMapper();
    }

    @AfterEach
    void tearDown() {
        bookMapper = null;
    }

    // TODO:
    @Test
    void givenBookRequest_whenToEntity_thenReturnBook() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setAuthor("author1");
        bookRequest.setTitle("title1");

        Book expected = new Book();
        expected.setAuthor("author1");
        expected.setTitle("title1");

        Book actual = bookMapper.toEntity(bookRequest);

        assertThat(actual).isEqualTo(expected);
    }

    // TODO:
    @Test
    void givenBookToUpdateAndBookRequest_whenToEntity_thenRetunBook() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setAuthor("author1");
        bookRequest.setTitle("title1");

        Book expected = new Book();
        expected.setAuthor("author1");
        expected.setTitle("title1");

        Book actual = bookMapper.toEntity(new Book(), bookRequest);

        assertThat(actual).isEqualTo(expected);
    }

    // functional test
    // unit test
    // if no dependencies, no mocking needed
    @Test
    void givenBook_whenToDto_thenReturnBookResponse() {
        // given
        Book book = new Book();
        book.setAuthor("author1");
        book.setTitle("title1");

        BookResponse expectedResponse = new BookResponse();
        expectedResponse.setAuthor("author1");
        expectedResponse.setTitle("title1");

        // when
        BookResponse actualResponse = bookMapper.toDto(book);

        // then
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}