package com.zynoz.rest.api;

import com.zynoz.entity.Birthday;

import javax.ws.rs.core.Response;
import java.util.List;


public interface RestApi {
    Response createBirthday(Birthday birthday);
    Response updateBirthday(Birthday birthday);
    Birthday getBirthday(Long id);
    List<Birthday> getBirthdaysJson();
    List<Birthday> getBirthdaysCsv();
    List<Birthday> getBirthdays(boolean reoccuring);
    List<Birthday> deleteAll();
    Birthday deleteBirthday(Long id);
}