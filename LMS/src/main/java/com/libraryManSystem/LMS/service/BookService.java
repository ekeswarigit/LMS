package com.libraryManSystem.LMS.service;

import java.util.List;

import com.libraryManSystem.LMS.dto.BookRequest;
import com.libraryManSystem.LMS.model.Book;

public interface BookService {

    Book addBook(Book book);

    Book updateBook(Long id, BookRequest book);

    void deleteBook(Long id);

    List<Book> searchByAuthor(String author);

    List<Book> getAvailableBooks();
}
