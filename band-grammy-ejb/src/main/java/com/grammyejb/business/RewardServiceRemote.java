package com.grammyejb.business;

import com.grammyejb.models.MusicGenre;
import com.grammyejb.schemas.reward.RewardReadSchema;
import jakarta.ejb.Remote;

@Remote
public interface RewardServiceRemote {
    RewardReadSchema giveReward(Long toMusicBand, MusicGenre genre);
}
