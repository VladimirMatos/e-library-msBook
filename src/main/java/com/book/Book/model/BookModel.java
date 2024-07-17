package com.book.Book.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;


@Data
@MongoEntity(collection = "Book")
public class BookModel {
    @JsonProperty("_id")
    public ObjectId id;
    public String title;
    public String description;
    public ObjectId categoryId;
    public ObjectId authorId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    // Custom method to set createdAt and updatedAt
    public void initDates() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Custom method to update updatedAt
    public void updateDate() {
        this.updatedAt = LocalDateTime.now();
    }
}
