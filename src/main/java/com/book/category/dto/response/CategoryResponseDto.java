package com.book.category.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class CategoryResponseDto {
    @JsonProperty("_id")
    public ObjectId id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
