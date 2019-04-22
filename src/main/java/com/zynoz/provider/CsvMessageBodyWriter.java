package com.zynoz.provider;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

@Provider
@Produces("text/csv")
public class CsvMessageBodyWriter<T> implements MessageBodyWriter<List<T>> {

    @Override
    public boolean isWriteable(Class aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return List.class.isAssignableFrom(aClass);
    }

    @Override
    public long getSize(List<T> data, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(List<T> data, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        if (data != null && data.size() > 0) {
            CsvMapper csvMapper = new CsvMapper();
            csvMapper.findAndRegisterModules();
            csvMapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
            csvMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            CsvSchema schema = CsvSchema.builder()
                    .addColumn("id")
                    .addColumn("name")
                    .addColumn("birthdayDate")
                    .addColumn("reminderDate")
                    .addColumn("everyYear")
                    .build();

//            CsvSchema schema = csvMapper.schemaFor(Birthday.class);

            csvMapper.writer(schema).writeValues(outputStream).writeAll(data);
        }
    }
}