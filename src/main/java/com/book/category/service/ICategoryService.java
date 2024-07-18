package com.book.category.service;

import com.book.category.dto.request.CategoryRequestDto;
import com.book.category.dto.response.CategoryResponseDto;
import com.book.utils.PaginationResponseDto;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

@ApplicationScoped
public interface ICategoryService {
    PaginationResponseDto<CategoryResponseDto> getAllCategory(int page, int totalResult);
    CategoryResponseDto getOneById (ObjectId id);
    CategoryResponseDto createCategory (CategoryRequestDto category);
}
