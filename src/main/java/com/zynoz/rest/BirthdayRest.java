package com.zynoz.rest;

import com.zynoz.entity.Birthday;
import com.zynoz.rest.api.RestApi;
import com.zynoz.service.BirthdayService;

import javax.inject.Inject;
import javax.validation.ValidationException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("birthday")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BirthdayRest implements RestApi {

    @Inject
    BirthdayService birthdayService;

    @Override
    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBirthday(Birthday birthday) {
        try {
            birthdayService.createBirthday(birthday);
            return Response.status(Response.Status.OK).entity(birthday).build();
        } catch (ValidationException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR: Could not create new birthday").build();
        }
    }

    @Override
    @Path("update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBirthday(Birthday birthday) {
        try {
            birthdayService.updateBirthday(birthday);
            return Response.status(Response.Status.OK).entity(birthday).build();
        } catch (ValidationException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR: Could not update birthday").build();
        }
    }

    @Override
    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Birthday getBirthday(@PathParam("id") Long id) {
        return birthdayService.findBirthday(id);
    }

    @Override
    @Path("listCsv")
    @GET
    @Consumes("text/csv")
    @Produces("text/csv")
    public List<Birthday> getBirthdaysCsv() {
        return birthdayService.getBirthdays();
    }

    @Override
    @Path("list")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Birthday> getBirthdaysJson() {
        return birthdayService.getBirthdays();
    }

    @Override
    @Path("delete/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Birthday deleteBirthday(@PathParam("id")Long id) {
        return birthdayService.deleteBirthdayId(id);
    }

    @Override
    @Path("delete/all")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Birthday> deleteAll() {
        return birthdayService.clearAll();
    }

    @Override
    @Path("list/{re}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Birthday> getBirthdays(@QueryParam("re") boolean reoccuring) {
        return birthdayService.getBirthdays().stream().filter(b -> b.isEveryYear() == reoccuring).collect(Collectors.toList());
    }


}