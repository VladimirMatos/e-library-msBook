package com.book.rest;

import com.book.GeneralDto.UserResponseDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/users")
@RegisterRestClient(configKey = "elibrary-app-user-api")
@ApplicationScoped
public interface UserRestClient {

    @GET
    @Path("/{id}")
    UserResponseDto getOneUser (@PathParam("id") String id);
}
