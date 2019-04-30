package com.zynoz.service.impl;

import birthday.entities.Reminder;
import birthday.service.api.ImportServiceApi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ImportService implements ImportServiceApi {

    @PersistenceContext
    EntityManager entityManager;

    public List<Reminder> importReminders(List<Reminder> reminders) {
        for (Reminder b : reminders) {
            entityManager.persist(b);
        }
        return reminders;
    }
}