package com.libraryManSystem.LMS.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.libraryManSystem.LMS.dto.BookRequest;
import com.libraryManSystem.LMS.model.Book;
import com.libraryManSystem.LMS.repository.BookRepo;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepository;

    @Override
    public Book addBook(Book book) {

       Optional<Book> existingBook = bookRepository.findByTitle(book.getTitle());

            if (existingBook.isPresent()) {

                Book bookFromDb = existingBook.get();
                bookFromDb.setCount(bookFromDb.getCount() + 1);
                return bookRepository.save(bookFromDb);

            } else {

                book.setCount(1);
                return bookRepository.save(book);
            }
    }

    public Book updateBook(Long id, BookRequest updatedBook) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        //existingBook.setIsbn(updatedBook.getIsbn());
        //existingBook.setStatus(updatedBook.getStatus());
        //existingBook.setCount(updatedBook.getCount());

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {

        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }

        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookRepository.findByStatusIgnoreCase("AVAILABLE");
    }
}