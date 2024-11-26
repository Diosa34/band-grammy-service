package com.musicbands.bandgrammyservice.controllers;

import com.musicbands.bandgrammyservice.exceptions.NotFoundException;
import com.musicbands.bandgrammyservice.exceptions.ServiceUnavailableException;
import com.musicbands.bandgrammyservice.schemas.exceptions.Http404Schema;
import com.musicbands.bandgrammyservice.schemas.exceptions.Http422Schema;
import com.musicbands.bandgrammyservice.schemas.exceptions.Http503Schema;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Hidden
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {NotFoundException.class})
    public Http404Schema handleNotFoundExceptions(NotFoundException ex) {
        return new Http404Schema(ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class,
            jakarta.validation.ConstraintViolationException.class})
    public Http422Schema handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new Http422Schema(errors);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(value = ServiceUnavailableException.class)
    public Http503Schema handleServiceUnavailableException(ServiceUnavailableException ex) {
        return new Http503Schema(ex.getMessage());
    }

//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = IllegalArgumentException.class)
//    public BadRequestSchema handleBadRequest(IllegalArgumentException exception) {
//        return new BadRequestSchema(exception);
//    }
//
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(value = ServerException.class)
//    public InternalServerErrorSchema handleBadRequest(ServerException exception) {
//        return new InternalServerErrorSchema(exception);
//    }
}
