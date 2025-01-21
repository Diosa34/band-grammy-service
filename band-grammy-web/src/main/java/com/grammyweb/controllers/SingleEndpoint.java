package com.grammyweb.controllers;

import com.grammyejb.schemas.single.SingleBaseSchema;
import com.grammyejb.schemas.single.SingleReadSchema;
import com.grammyweb.jaxbgenerated.CreateSingleRequest;
import com.grammyweb.jaxbgenerated.SOAPSingleReadSchema;
import com.grammyweb.services.SingleService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.grammyweb.mappers.SingleBaseSchemaMapper;
import com.grammyweb.mappers.SingleReadSchemaMapper;

@Endpoint
@RequiredArgsConstructor
public class SingleEndpoint {
    private final SingleService singleService;

    private static final String NAMESPACE_URI = "http://example.com/please";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateSingleRequest")
    @ResponsePayload
    public SOAPSingleReadSchema createSingle(@RequestPayload CreateSingleRequest request) {
        SingleBaseSchema singleBaseSchema = SingleBaseSchemaMapper.MAPPER.map(request.getSchema());
        Long musicBandId = request.getMusicBandId();

        SingleReadSchema response = singleService.createSingle(musicBandId, singleBaseSchema);

        return SingleReadSchemaMapper.MAPPER.map(response);
    }
}

