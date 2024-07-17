package com.book.Book.service;

import com.book.Book.dto.request.CreateBookRequest;
import com.book.Book.dto.response.BookResponseDto;
import com.book.Book.model.BookModel;
import com.book.Book.repository.BookRepository;
import com.book.GeneralDto.UserResponseDto;
import com.book.category.dto.response.CategoryResponseDto;
import com.book.category.service.CategoryService;
import com.book.rest.UserRestClient;
import com.book.utils.MapperSource;
import com.book.utils.PaginationResponse;
import com.book.utils.PaginationResponseDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class BookService implements IBookService{

    BookRepository bookRepository;
    MapperSource mapperSource;
    CategoryService categoryService;

    @RestClient
    UserRestClient userRestClient;

    @Inject
    public BookService(BookRepository bookRepository, MapperSource mapperSource, CategoryService categoryService, UserRestClient userRestClient) {
        this.bookRepository = bookRepository;
        this.mapperSource = mapperSource;
        this.categoryService = categoryService;
        this.userRestClient = userRestClient;
    }

    @Override
    public PaginationResponseDto<BookResponseDto> booksPagination(int page, int totalResult) {
        PaginationResponse<BookModel> books = bookRepository.findAllWithPagination(page, totalResult);

        return mapperSource.mapPagination(books, BookResponseDto.class);
    }

    @Override
    public BookResponseDto createBook(CreateBookRequest book) {
        CategoryResponseDto category = categoryService.getOneById(new ObjectId(book.categoryId));

        if(category == null){
            throw new NotFoundException();
        }

        UserResponseDto userFind = userRestClient.getOneUser(book.authorId);

        System.out.println(userFind);

        BookModel bookCreated = new BookModel();

        bookCreated.title = book.title;
        bookCreated.description = book.description;
        bookCreated.authorId =new ObjectId(book.authorId) ;
        bookCreated.categoryId = new ObjectId(book.categoryId);
        bookCreated.initDates();

        return mapperSource.mapObject(bookCreated, BookResponseDto.class);

    }


}
