package com.musicbands.bandgrammyservice.repositories;

import com.musicbands.bandgrammyservice.models.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RewardRepository extends JpaRepository<Reward, Long> {
    Optional<Reward> findById(Long id);
}