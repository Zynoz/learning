package com.zynoz.provider.helper;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

class CsvAnnotationIntrospector {

    private final char sep;
    private final Optional<String[]> columns;
    private final boolean skipFirstDataRow;

    CsvAnnotationIntrospector(Class csvClass) {
        Annotation sepAnnotation = csvClass.getAnnotation(CsvSchema.class);
        if (sepAnnotation != null) {
            sep = defineSeparator(sepAnnotation);
            columns = defineColumns(sepAnnotation);
            skipFirstDataRow = defineSkipFirstDataRow(sepAnnotation);
        } else {
            // default values
            sep = ';';
            columns = Optional.empty();
            skipFirstDataRow = false;
        }
    }

    public char separator() {
        return sep;
    }

    public Optional<String[]> columns() {
        return columns;
    }

    public boolean skipFirstDataRow() {
        return skipFirstDataRow;
    }

    private static char defineSeparator(Annotation sepAnnotation) {
        try {
            Method method = sepAnnotation.annotationType().getDeclaredMethod("separator");
            return  (char) method.invoke(sepAnnotation, (Object[])null);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static Optional<String[]> defineColumns(Annotation orderAnnotation) {
        try {
            Method method = orderAnnotation.annotationType().getDeclaredMethod("columns");
            return Optional.of((String[]) method.invoke(orderAnnotation, (Object[])null));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean defineSkipFirstDataRow(Annotation orderAnnotation) {
        try {
            Method method = orderAnnotation.annotationType().getDeclaredMethod("skipFirstDataRow");
            return (boolean) method.invoke(orderAnnotation, (Object[])null);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}