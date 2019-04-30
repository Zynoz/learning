package com.zynoz.service.api;

import birthday.entities.Reminder;

import java.util.List;

public interface ImportServiceApi {
    List<Reminder> importReminders(List<Reminder> reminder);
}