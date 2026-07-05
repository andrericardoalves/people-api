package com.alves.resource;

import com.alves.entity.PeopleEntity;
import com.alves.service.PeopleService;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("v1/people")
public class PeopleResource {

    private final PeopleService peopleService;

    public PeopleResource(final PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(final  List<PeopleEntity> people) {

        peopleService.insertPeople(people);

        return Response.ok().build();
    }
}
