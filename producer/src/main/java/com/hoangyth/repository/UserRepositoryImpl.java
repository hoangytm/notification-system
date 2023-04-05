package com.hoangyth.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public void getUser(String userId) {
        Query query = entityManager.createQuery("from User where id = :userId");
        query.setParameter("userId", userId);
        query.setLockMode(LockModeType.PESSIMISTIC_WRITE);
        List result = query.getResultList();

    }
}
