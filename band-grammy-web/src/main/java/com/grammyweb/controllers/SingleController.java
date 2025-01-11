package com.grammyweb.controllers;

import com.grammyejb.schemas.single.SingleBaseSchema;
import com.grammyejb.schemas.single.SingleReadSchema;
import com.grammyweb.schemas.exceptions.Http422Schema;
import com.grammyweb.schemas.exceptions.Http503Schema;
import com.grammyweb.services.SingleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Синглы")
@Validated
@RestController
@RequestMapping("/grammy")
@AllArgsConstructor
public class SingleController {
    private final SingleService singleService;

    @Operation(
            summary = "Добавить сингл",
            description = "Создает сингл для группы с идентификатором musicBandId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "Валидационная ошибка", content = @Content(schema = @Schema(implementation = Http422Schema.class))),
            @ApiResponse(responseCode = "503", description = "Опорный сервис не доступен", content = @Content(schema = @Schema(implementation = Http503Schema.class)))
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            value = "/{musicBandId}/singles/add",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public SingleReadSchema createSingle(@PathVariable Long musicBandId, @RequestBody @Valid SingleBaseSchema schema) { // проверка на существование
        return singleService.createSingle(musicBandId, schema);
    }
}
