package com.grammyejb.business;

import com.grammyejb.business.external.MusicBandService;
import com.grammyejb.business.mappers.RewardMapper;
import com.grammyejb.models.MusicGenre;
import com.grammyejb.models.Reward;
import com.grammyejb.repositories.RewardRepositoryEjb;
import com.grammyejb.schemas.reward.RewardReadSchema;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@Stateless
@EntityScan("com.grammyejb")
@ComponentScan(basePackages="com.grammyejb")
public class RewardServiceEjb implements RewardServiceRemote {
    @EJB
    RewardMapper rewardMapper;
    @EJB
    RewardRepositoryEjb rewardRepository;
    @EJB
    MusicBandService musicBandService;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public RewardReadSchema giveReward(Long toMusicBand, MusicGenre genre) {
        musicBandService.getMusicBand(toMusicBand); // проверка на существование
        Reward newReward = new Reward();
        newReward.setMusicBandId(toMusicBand);
        newReward.setGenre(genre);
        newReward = rewardRepository.save(newReward);
        return rewardMapper.mapEntityToReadSchema(newReward);
    }
}
