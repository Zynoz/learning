package com.zynoz.service.impl;

import birthday.entities.Reminder;
import birthday.service.api.ReminderServiceApi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ReminderService implements ReminderServiceApi {

    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;

    public ReminderService() {

    }

    public void setEntityManager(EntityManager em) {
        entityManager = em;
    }

    public Reminder createReminder(Reminder birthday) {
        entityManager.persist(birthday);
        return birthday;
    }

    public Reminder updateReminder(Reminder birthday) {
        entityManager.merge(birthday);
        return birthday;
    }

    public Reminder findReminder(Long id) {
        return entityManager.find(Reminder.class, id);
    }

    public Reminder deleteReminderId(Long id) {
        Reminder toDelete = findReminder(id);
        entityManager.remove(toDelete);
        return toDelete;
    }

    public List<Reminder> getReminders() {
        return entityManager.createQuery("SELECT r from reminder r", Reminder.class).getResultList();
    }

    public List<String> getNames() {
        return entityManager.createQuery("select r.name from reminder r", String.class).getResultList();
    }

    public List<Reminder> clearAll() {
        List<Reminder> temp = getReminders();
        for (Reminder b : temp) {
            entityManager.remove(b);
        }
        return temp;
    }
}