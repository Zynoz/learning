package com.zynoz.service.api;

import com.sun.jersey.core.header.FormDataContentDisposition;
import javax.ws.rs.core.Response;
import java.io.InputStream;

public interface FileUploadServiceApi {
    Response uploadFile(InputStream uploadedStream, FormDataContentDisposition fileDetail);
    void saveToFile(InputStream inStream, String target);
    void createFolderIfNotExists(String dirName);
}