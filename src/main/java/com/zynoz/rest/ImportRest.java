package com.zynoz.rest;

import birthday.entities.Reminder;
import birthday.service.impl.ImportService;
import com.zynoz.rest.api.ImportApi;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("import")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ImportRest implements ImportApi {

    @Inject
    ImportService importService;

    @Override
    @Path("json")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reminder> importJson(List<Reminder> reminders) {
        return importService.importReminders(reminders);
    }
}