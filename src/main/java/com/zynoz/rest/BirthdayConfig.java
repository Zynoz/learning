package com.zynoz.rest;

import com.zynoz.entity.Birthday;
import com.zynoz.provider.ContextResolver;
import com.zynoz.provider.CsvMessageBodyProvider;
import com.zynoz.provider.CsvMessageBodyWriter;
import com.zynoz.provider.helper.CsvAnnotationIntrospector;
import com.zynoz.provider.helper.CsvSchema;
import com.zynoz.provider.helper.CsvSchemaFactory;
import com.zynoz.rest.api.ImportApi;
import com.zynoz.rest.api.RestApi;
import com.zynoz.service.BirthdayService;
import com.zynoz.service.ImportService;
import com.zynoz.service.api.BirthdayServiceApi;
import com.zynoz.service.api.ImportServiceApi;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class BirthdayConfig extends Application {
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> classes = new HashSet<>();
//        classes.add(Birthday.class);
//        classes.add(CsvAnnotationIntrospector.class);
//        classes.add(CsvSchema.class);
//        classes.add(CsvSchemaFactory.class);
//        classes.add(ContextResolver.class);
//        classes.add(ImportApi.class);
//        classes.add(RestApi.class);
//        classes.add(BirthdayConfig.class);
//        classes.add(BirthdayRest.class);
//        classes.add(ImportRest.class);
//        classes.add(BirthdayServiceApi.class);
//        classes.add(ImportServiceApi.class);
//        classes.add(BirthdayService.class);
//        classes.add(ImportService.class);
//        return classes;
//    }
//
//    @Override
//    public Set<Object> getSingletons() {
//        Set<Object> classes = new HashSet<>();
//        classes.add(CsvMessageBodyProvider.class);
//        classes.add(CsvMessageBodyWriter.class);
//        return classes;
//    }
}