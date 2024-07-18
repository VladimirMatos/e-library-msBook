package com.book.category.model;

import com.book.Book.model.BookModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@Data
@MongoEntity(collection = "Category")
public class CategoryModel {
    @JsonProperty("_id")
    public ObjectId id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<BookModel> books;

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
