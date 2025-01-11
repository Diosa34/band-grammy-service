package com.grammyejb.repositories;

import com.grammyejb.models.Single;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

@Stateless
public class SingleRepositoryEjb {
    @PersistenceContext
    private EntityManager entityManager;

    public Single save(Single single) {
        entityManager.persist(single);
        return single;
    }

    public Optional<Single> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Single.class, id));
    }
}
