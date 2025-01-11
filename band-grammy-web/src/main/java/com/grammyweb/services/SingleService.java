package com.grammyweb.services;

import com.grammyejb.business.SingleServiceRemote;
import com.grammyejb.schemas.single.SingleBaseSchema;
import com.grammyejb.schemas.single.SingleReadSchema;
import jakarta.ejb.EJB;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SingleService {
    @EJB
    private SingleServiceRemote singleServiceEjb;

    public SingleReadSchema createSingle(Long toMusicBand, SingleBaseSchema schema) {
        return singleServiceEjb.createSingle(toMusicBand, schema);
    }
}
