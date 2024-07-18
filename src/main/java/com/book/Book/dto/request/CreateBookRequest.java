package com.book.Book.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;

@Data
public class CreateBookRequest implements Serializable {
    @NotBlank(message = "Title is required")
    @Schema(description = "Title of book", type = SchemaType.STRING, format = "XXXXX", example = "Title Example")
    public String title;

    @NotBlank(message = "Description is required")
    @Schema(description = "Title of book", type = SchemaType.STRING, format = "XXXXX", example = "Description Example")
    public String description;

    @NotBlank(message = "CategoryId is required")
    @Schema(description = "Title of book", type = SchemaType.STRING, format = "XXXXX", example = "507f1f77bcf86cd799439011")
    public String categoryId;

    @NotBlank(message = "AuthorId is required")
    @Schema(description = "Title of book", type = SchemaType.STRING, format = "XXXXX", example = "507f1f77bcf86cd799439011")
    public String authorId;
}
