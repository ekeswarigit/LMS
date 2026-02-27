package com.libraryManSystem.LMS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
@Entity
public class Book {
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition = "INT DEFAULT 0")
    private int bookId;

    private String title;

    private String author;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isbn;

    private String status;

     @Column(columnDefinition = "INT DEFAULT 0")
     private int count;
}
