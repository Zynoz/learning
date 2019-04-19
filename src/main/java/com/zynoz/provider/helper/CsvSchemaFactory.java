package com.zynoz.provider.helper;


import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.util.Optional;

public interface CsvSchemaFactory {

    static CsvSchema buildSchema(CsvMapper mapper, Class csvClass) {
        CsvAnnotationIntrospector introspector = new CsvAnnotationIntrospector(csvClass);
        char separatorChar = introspector.separator();
        Optional<String[]> columns = introspector.columns();

        CsvSchema csvSchema = mapper.schemaFor(csvClass)
                .withColumnSeparator(separatorChar)
                .withSkipFirstDataRow(introspector.skipFirstDataRow());
        if (columns.isPresent()) {
            // Rebuild columns to take account of order
            CsvSchema.Builder builder = csvSchema.rebuild().clearColumns();
            for (String column : columns.get()) {
                CsvSchema.Column oldColumn = csvSchema.column(column);
                builder.addColumn(column, oldColumn.getType());
            }
            csvSchema = builder.build();
        }

        return csvSchema;
    }
}