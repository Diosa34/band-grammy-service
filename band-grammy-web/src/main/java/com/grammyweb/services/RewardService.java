package com.grammyweb.services;

import com.grammyejb.business.RewardServiceRemote;
import com.grammyejb.models.MusicGenre;
import com.grammyejb.schemas.reward.RewardReadSchema;
import jakarta.ejb.EJB;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RewardService {
    @EJB
    private RewardServiceRemote rewardServiceEjb;

    public RewardReadSchema giveReward(Long toMusicBand, MusicGenre genre) {
        return rewardServiceEjb.giveReward(toMusicBand, genre);
    }
}
