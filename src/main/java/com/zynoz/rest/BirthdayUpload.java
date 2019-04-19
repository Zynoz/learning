package com.zynoz.rest;

import com.zynoz.entity.Birthday;
import com.zynoz.rest.api.UploadApi;
import com.zynoz.service.UploadService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("upload")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BirthdayUpload implements UploadApi {

    @Inject
    UploadService uploadService;

    @Override
    @Path("json")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Birthday> importJson(List<Birthday> birthdays) {
        return uploadService.importBirthdays(birthdays);
    }

    @Override
    @Path("csv")
    @POST
    @Consumes("text/csv")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Birthday> importCsv(List<Birthday> birthdays) {
        return uploadService.importBirthdays(birthdays);
    }
}