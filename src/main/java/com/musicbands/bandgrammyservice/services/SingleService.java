package com.musicbands.bandgrammyservice.services;

import com.musicbands.bandgrammyservice.mappers.SingleMapper;
import com.musicbands.bandgrammyservice.models.Single;
import com.musicbands.bandgrammyservice.repositories.SingleRepository;
import com.musicbands.bandgrammyservice.schemas.SingleBaseSchema;
import com.musicbands.bandgrammyservice.schemas.SingleReadSchema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SingleService {
    private final SingleRepository singleRepository;
    private final SingleMapper singleMapper;

    public SingleReadSchema add(Long bandId, SingleBaseSchema schema) {
        Single model = singleMapper.mapSingleBaseToEntity(bandId, schema);
        model = singleRepository.save(model);
        return singleMapper.mapEntityToSingleRead(model);
    }
}
