package com.zynoz.service.api;

import com.zynoz.entity.Birthday;

import java.util.List;

public interface ServiceApi {
    Birthday createBirthday(Birthday birthday);
    Birthday updateBirthday(Birthday birthday);
    Birthday findBirthday(Long id);
    Birthday deleteBirthdayId(Long id);
    List<Birthday> getBirthdays();
    List<Birthday> clearAll();
}