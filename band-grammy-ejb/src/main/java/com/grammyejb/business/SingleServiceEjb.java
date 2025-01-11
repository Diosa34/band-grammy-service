package com.grammyejb.business;

import com.grammyejb.business.external.MusicBandService;
import com.grammyejb.business.mappers.SingleMapper;
import com.grammyejb.models.Single;
import com.grammyejb.repositories.SingleRepositoryEjb;
import com.grammyejb.schemas.single.SingleBaseSchema;
import com.grammyejb.schemas.single.SingleReadSchema;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@Stateless
@EntityScan("com.grammyejb")
@ComponentScan(basePackages="com.grammyejb")
public class SingleServiceEjb implements SingleServiceRemote {
    @EJB
    SingleMapper singleMapper;
    @EJB
    SingleRepositoryEjb singleRepository;
    @EJB
    MusicBandService musicBandService;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public SingleReadSchema createSingle(Long toMusicBand, SingleBaseSchema schema) {
        musicBandService.getMusicBand(toMusicBand);
        Single newSingle = singleMapper.mapSingleBaseToEntity(schema);
        newSingle.setMusicBandId(toMusicBand);
        newSingle = singleRepository.save(newSingle);
        return singleMapper.mapEntityToReadSchema(newSingle);
    }
}
