package com.book.category.service;

import com.book.category.dto.request.CategoryRequestDto;
import com.book.category.dto.response.CategoryResponseDto;
import com.book.category.model.CategoryModel;
import com.book.category.repository.CategoryRepository;
import com.book.utils.MapperSource;
import com.book.utils.PaginationResponse;
import com.book.utils.PaginationResponseDto;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import org.bson.types.ObjectId;

@ApplicationScoped
public class CategoryService implements ICategoryService{

    CategoryRepository categoryRepository;
    MapperSource mapperSource;

    @Inject
    public CategoryService(CategoryRepository categoryRepository, MapperSource mapperSource) {
        this.categoryRepository = categoryRepository;
        this.mapperSource = mapperSource;
    }



    @Override
    public PaginationResponseDto<CategoryResponseDto> getAllCategory(int page, int totalResult) {
        PaginationResponse<CategoryModel> categories = categoryRepository.findAllWithPagination(page,totalResult);

        return mapperSource.mapPagination(categories, CategoryResponseDto.class);
    }

    @Override
    public CategoryResponseDto getOneById(ObjectId id) {
        try{
            CategoryModel categoryFind = categoryRepository.findById(id);

            if (categoryFind == null) {
                return null;
            }
            return mapperSource.mapObject(categoryFind, CategoryResponseDto.class);

        }catch (Exception e){
            Log.error(e);
            return null;
        }
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto category) {
        try {
            String nameUpper = category.name.substring(0,1).toUpperCase() + category.name.substring(1);
            CategoryModel categoryFind = categoryRepository.findByName(nameUpper);

            if (categoryFind != null) {
                return null;
            }

            CategoryModel categoryModel = new CategoryModel();

            categoryModel.name = nameUpper;
            categoryModel.initDates();

            categoryRepository.persist(categoryModel);

            return mapperSource.mapObject(categoryModel, CategoryResponseDto.class) ;
        }catch (Exception e){
            Log.error(e);
            throw new BadRequestException();
        }
    }
}
