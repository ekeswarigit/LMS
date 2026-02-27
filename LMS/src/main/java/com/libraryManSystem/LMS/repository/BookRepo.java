package com.libraryManSystem.LMS.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import com.libraryManSystem.LMS.model.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByStatusIgnoreCase(String status);

    Optional<Book> findByTitle(String title);
}

