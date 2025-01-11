package com.grammyejb.business;

import com.grammyejb.schemas.single.SingleBaseSchema;
import com.grammyejb.schemas.single.SingleReadSchema;
import jakarta.ejb.Remote;

@Remote
public interface SingleServiceRemote {
    SingleReadSchema createSingle(Long toMusicBand, SingleBaseSchema schema);
}
