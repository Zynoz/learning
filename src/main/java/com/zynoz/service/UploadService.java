package com.zynoz.service;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.zynoz.service.api.FileUploadServiceApi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Transactional
public class UploadService implements FileUploadServiceApi {

    private static final String UPLOAD_FOLDER = "c:\\scratch\\";

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Response uploadFile(InputStream uploadedStream, FormDataContentDisposition fileDetail) {
        return null;
    }

    @Override
    public void saveToFile(InputStream inStream, String target) {

    }

    @Override
    public void createFolderIfNotExists(String dirName) {

    }
}