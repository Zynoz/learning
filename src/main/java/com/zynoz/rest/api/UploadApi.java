package com.zynoz.rest.api;

import com.zynoz.entity.Birthday;

import java.util.List;

public interface UploadApi {
    List<Birthday> importJson(List<Birthday> birthdays);
    List<Birthday> importCsv(List<Birthday> birthdays);
}