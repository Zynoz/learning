package com.zynoz.provider.helper;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CsvSchema {

    char separator() default ';';
    String[] columns() default {};
    boolean skipFirstDataRow() default false;
}