package com.book.Book.dto.response;

import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class BookResponseDto  {
    public ObjectId id;
    public String title;
    public String description;
    public ObjectId categoryId;
    public ObjectId authorId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
