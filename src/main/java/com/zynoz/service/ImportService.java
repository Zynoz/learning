package com.zynoz.service;

import com.zynoz.entity.Birthday;
import com.zynoz.service.api.ImportServiceApi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ImportService implements ImportServiceApi {

    @PersistenceContext
    EntityManager entityManager;

    public List<Birthday> importBirthdays(List<Birthday> birthdays) {
        for (Birthday b : birthdays) {
            entityManager.persist(b);
        }
        return birthdays;
    }
}