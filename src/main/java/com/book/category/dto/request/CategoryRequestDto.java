package com.book.category.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


public class CategoryRequestDto {
    @NotBlank(message = "Name is required")
    @Schema(description = "Title of book", type = SchemaType.STRING, format = "XXXXX", example = "Action")
    public String name;
}
