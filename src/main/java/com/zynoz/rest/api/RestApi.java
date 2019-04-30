package com.zynoz.rest.api;

import birthday.entities.Reminder;

import javax.ws.rs.core.Response;
import java.util.List;


public interface RestApi {
    Response createReminder(Reminder reminder);
    Response updateReminder(Reminder reminder);
    Reminder getReminder(Long id);
    List<Reminder> getRemindersJson();
    List<Reminder> getReminders(boolean reoccuring);
    List<Reminder> deleteAll();
    Reminder deleteReminder(Long id);
}