package com.zynoz.rest.api;

import birthday.entities.Reminder;

import java.util.List;

public interface ImportApi {
    List<Reminder> importJson(List<Reminder> reminders);
}