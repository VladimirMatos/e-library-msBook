package com.book.category.repository;

import com.book.category.model.CategoryModel;
import com.book.utils.GenericRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements GenericRepository<CategoryModel> {
    public CategoryModel findByName(String name){
        return find("name", name).firstResult();
    }
}
