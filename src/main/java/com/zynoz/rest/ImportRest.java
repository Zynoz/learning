package com.zynoz.rest;

import com.zynoz.entity.Birthday;
import com.zynoz.rest.api.ImportApi;
import com.zynoz.service.ImportService;

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
    public List<Birthday> importJson(List<Birthday> birthdays) {
        return importService.importBirthdays(birthdays);
    }

    @Override
    @Path("csv")
    @POST
    @Consumes("text/csv")
    @Produces("text/csv")
    public List<Birthday> importCsv(List<Birthday> birthdays) {
        return importService.importBirthdays(birthdays);
    }

    @Override
    public void test() {

    }
}