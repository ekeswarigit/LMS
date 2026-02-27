package com.libraryManSystem.LMS.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {
    
    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "author is mandatory")
    private String author;
    private int count;
}
