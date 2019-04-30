package com.zynoz.rest;

import birthday.entities.Reminder;
import birthday.service.impl.ReminderService;
import com.zynoz.rest.api.RestApi;

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
public class ReminderRest implements RestApi {

    @Inject
    private ReminderService reminderService;

    @Override
    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReminder(Reminder reminder) {
        try {
            reminderService.createReminder(reminder);
            return Response.status(Response.Status.OK).entity(reminder).build();
        } catch (ValidationException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR: Could not create new birthday").build();
        }
    }

    @Override
    @Path("update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateReminder(Reminder reminder) {
        try {
            reminderService.updateReminder(reminder);
            return Response.status(Response.Status.OK).entity(reminder).build();
        } catch (ValidationException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR: Could not update birthday").build();
        }
    }

    @Override
    @Path("{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reminder getReminder(@PathParam("id") Long id) {
        return reminderService.findReminder(id);
    }

    @Override
    @Path("list")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reminder> getRemindersJson() {
        return reminderService.getReminders();
    }

    @Override
    @Path("delete/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reminder deleteReminder(@PathParam("id")Long id) {
        return reminderService.deleteReminderId(id);
    }

    @Override
    @Path("delete/all")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reminder> deleteAll() {
        return reminderService.clearAll();
    }

    @Override
    @Path("list/{re}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reminder> getReminders(@QueryParam("re") boolean reoccuring) {
        return reminderService.getReminders().stream().filter(b -> b.getEveryyear() == reoccuring).collect(Collectors.toList());
    }
}