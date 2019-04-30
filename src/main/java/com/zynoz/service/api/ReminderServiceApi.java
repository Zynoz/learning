package com.zynoz.service.api;

import birthday.entities.Reminder;

import java.util.List;

public interface ReminderServiceApi {
    Reminder createReminder(Reminder reminder);
    Reminder updateReminder(Reminder reminder);
    Reminder findReminder(Long id);
    Reminder deleteReminderId(Long id);
    List<Reminder> getReminders();
    List<Reminder> clearAll();
}