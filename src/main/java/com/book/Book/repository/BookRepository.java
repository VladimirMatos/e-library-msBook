package com.book.Book.repository;

import com.book.Book.model.BookModel;
import com.book.utils.GenericRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository implements GenericRepository<BookModel> {
    BookModel findByName(String name){
        return find("name", name).firstResult();
    }
}
