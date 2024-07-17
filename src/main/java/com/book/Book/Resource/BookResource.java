package com.book.Book.Resource;

import com.book.Book.dto.request.CreateBookRequest;
import com.book.Book.dto.response.BookResponseDto;
import com.book.Book.service.BookService;
import com.book.utils.PaginationResponseDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/book")
@Produces(APPLICATION_JSON)
public class BookResource {

    BookService bookService;

    @Inject
    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    public Response getAllPagination(@QueryParam("page") @DefaultValue("1") int page, @QueryParam("totalResul") @DefaultValue("5") int totalResult){
        PaginationResponseDto<BookResponseDto> books = bookService.booksPagination(page, totalResult);

        return Response.ok().entity(books).build();
    }

    @POST
    public Response createBook(@Valid CreateBookRequest book ){
        BookResponseDto bookCreated = bookService.createBook(book);

        return Response.status(Status.CREATED).entity(bookCreated).build();
    }
}
