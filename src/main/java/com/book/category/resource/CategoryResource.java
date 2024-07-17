package com.book.category.resource;

import com.book.GeneralDto.ResponseDto;
import com.book.category.dto.request.CategoryRequestDto;
import com.book.category.dto.response.CategoryResponseDto;
import com.book.category.model.CategoryModel;
import com.book.category.service.CategoryService;
import com.book.utils.Constants;
import com.book.utils.PaginationResponseDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.bson.types.ObjectId;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/category")
@Produces(APPLICATION_JSON)
public class CategoryResource {

    CategoryService categoryService;

    @Inject
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GET
    public Response getAllCategory(@QueryParam("page") @DefaultValue("1") int page, @QueryParam("totalResult") @DefaultValue("5") int totalResult){
        PaginationResponseDto<CategoryResponseDto> categories =  categoryService.getAllCategory(page, totalResult);

        return  Response.ok().entity(categories).build();
    }

    @GET
    @Path("/{id}")
    public Response getOneCategory(@PathParam("id") String id){

        ResponseDto responseDto = new ResponseDto();
        responseDto.message = Constants.CATEGORY_NOT_FOUND;

        CategoryResponseDto category =  categoryService.getOneById(new ObjectId(id));

        if(category == null){
            return Response.status(Status.NOT_FOUND).entity(responseDto).build();
        }

        return  Response.ok().entity(category).build();
    }

    @POST
    public Response createCategory(@Valid CategoryRequestDto category){
        try {
            CategoryResponseDto categoryCreated = categoryService.createCategory(category);

            ResponseDto responseDto = new ResponseDto();

            responseDto.message = Constants.CATEGORY_REGISTERED_ALREADY;

            if(categoryCreated == null){
                return Response.status(Status.CONFLICT).entity(responseDto).build();
            }

            return Response.status(Status.CREATED).entity(categoryCreated).build();
        }catch (Exception ignored){
            throw new BadRequestException();
        }
    }
}
