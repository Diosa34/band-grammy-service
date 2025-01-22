package com.grammyweb.controllers;

import com.grammyejb.schemas.single.SingleBaseSchema;
import com.grammyejb.schemas.single.SingleReadSchema;
import com.grammyweb.jaxbgenerated.CreateRewardResponse;
import com.grammyweb.jaxbgenerated.CreateSingleRequest;
import com.grammyweb.jaxbgenerated.CreateSingleResponse;
import com.grammyweb.services.SingleService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.grammyweb.mappers.SingleBaseSchemaMapper;

@Endpoint
@RequiredArgsConstructor
public class SingleEndpoint {
    private final SingleService singleService;

    private static final String NAMESPACE_URI = "http://example.com/please";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateSingleRequest")
    public @ResponsePayload CreateSingleResponse createSingle(@RequestPayload CreateSingleRequest request) {
        SingleBaseSchema singleBaseSchema = SingleBaseSchemaMapper.MAPPER.map(request.getSchema());
        Long musicBandId = request.getMusicBandId();

        SingleReadSchema readScheme = singleService.createSingle(musicBandId, singleBaseSchema);
        CreateSingleResponse response = new CreateSingleResponse();
        response.setId(readScheme.getId());
        response.setMusicBandId(readScheme.getMusicBandId());
        response.setName(readScheme.getName());
        response.setDescription(readScheme.getDescription());
        return response;
    }
}

