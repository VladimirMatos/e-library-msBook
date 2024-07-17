package com.book.Book.service;

import com.book.Book.dto.request.CreateBookRequest;
import com.book.Book.dto.response.BookResponseDto;
import com.book.utils.PaginationResponseDto;

public interface IBookService {
    PaginationResponseDto<BookResponseDto> booksPagination(int page, int totalResult);
    BookResponseDto createBook(CreateBookRequest book);
}
