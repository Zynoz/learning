package com.zynoz.provider;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.zynoz.provider.helper.CsvSchemaFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("ALL")
@Provider
@Consumes("text/csv")
public class CsvMessageBodyProvider implements MessageBodyReader<Object>{

    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public Object readFrom(Class<Object> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
        CsvMapper mapper = new CsvMapper();
        Class csvClass = (Class) (((ParameterizedType) type).getActualTypeArguments())[0];
        CsvSchema schema = CsvSchemaFactory.buildSchema(mapper, csvClass);
        return mapper.reader(csvClass).with(schema).readValues(inputStream).readAll();
    }

    private Optional<Class> objectClass(Object o, Class<?> aClass) {
        Optional<Class> csvClass;
        if (o instanceof Collection) {
            Collection collection = (Collection) o;
            if (collection.isEmpty()) {
                csvClass = Optional.empty();
            } else {
                csvClass = Optional.of(collection.iterator().next().getClass());
            }
        } else {
            csvClass = Optional.of(aClass);
        }
        return csvClass;
    }

}