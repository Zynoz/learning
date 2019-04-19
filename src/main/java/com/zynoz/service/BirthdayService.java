package com.zynoz.service;

import com.zynoz.entity.Birthday;
import com.zynoz.service.api.ServiceApi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BirthdayService implements ServiceApi {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Birthday createBirthday(Birthday birthday) {
        entityManager.persist(birthday);
        return birthday;
    }

    @Override
    public Birthday updateBirthday(Birthday birthday) {
        return entityManager.merge(birthday);
    }

    @Override
    public Birthday findBirthday(Long id) {
        return entityManager.find(Birthday.class, id);
    }

    @Override
    public List<Birthday> getBirthdays() {
        List<Birthday> birthdays = entityManager.createQuery("SELECT  b from Birthday  b", Birthday.class).getResultList();
        return entityManager.createQuery("SELECT b FROM Birthday b", Birthday.class).getResultList();
    }

    @Override
    public Birthday deleteBirthdayId(Long id) {
        Birthday toDelete = findBirthday(id);
        entityManager.remove(toDelete);
        return toDelete;
    }

    @Override
    public List<Birthday> clearAll() {
        List<Birthday> temp = getBirthdays();
        for (Birthday b : temp) {
            entityManager.remove(b);
        }
        return temp;
    }
}