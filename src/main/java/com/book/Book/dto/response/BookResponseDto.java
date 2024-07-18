package com.book.Book.dto.response;

import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class BookResponseDto  {
    private ObjectId id;
    private String title;
    private String description;
    private ObjectId categoryId;
    private ObjectId authorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
