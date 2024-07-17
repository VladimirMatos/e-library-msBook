package com.book.GeneralDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    @JsonProperty("_id")
    public ObjectId id;
    public String name;
    public String lastname;
    public String email;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
