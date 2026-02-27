package com.libraryManSystem.LMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManSystem.LMS.dto.BookRequest;
import com.libraryManSystem.LMS.model.Book;
import com.libraryManSystem.LMS.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    
    @Autowired
    private final BookService bookService;

    // @PostMapping("/add")
    // public ResponseEntity<Book> addBook(@RequestBody Book book) {
    //     return ResponseEntity.ok(bookService.addBook(book));
    // }

    @PostMapping("/add")
    public Book addBook(@Valid @RequestBody BookRequest book) {

        Book books = Book.builder().title(book.getTitle()).author(book.getAuthor())
                .status("AVAILABLE")   
                .count(1)              // default value
                .isbn(false)           
                .build();

        return bookService.addBook(books);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@Valid @PathVariable Long id, @RequestBody BookRequest book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@Valid @PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

    @PostMapping("/search/{author}")
    public ResponseEntity<List<Book>> searchByAuthor(@Valid @PathVariable String author) {
        return ResponseEntity.ok(bookService.searchByAuthor(author));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        return ResponseEntity.ok(bookService.getAvailableBooks());
    }
}
