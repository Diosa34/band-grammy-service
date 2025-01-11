package com.grammyejb.repositories;

import com.grammyejb.models.Reward;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

@Stateless
public class RewardRepositoryEjb {
    @PersistenceContext
    private EntityManager entityManager;

    public Reward save(Reward reward) {
        entityManager.persist(reward);
        return reward;
    }

    public Optional<Reward> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Reward.class, id));
    }
}
