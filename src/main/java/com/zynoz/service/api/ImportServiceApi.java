package com.zynoz.service.api;

import com.zynoz.entity.Birthday;

import java.util.List;

public interface ImportServiceApi {
    List<Birthday> importBirthdays(List<Birthday> birthdays);
}