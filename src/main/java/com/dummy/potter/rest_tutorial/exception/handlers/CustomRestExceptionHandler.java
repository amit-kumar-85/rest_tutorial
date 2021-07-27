package com.dummy.potter.rest_tutorial.exception.handlers;

import com.dummy.potter.rest_tutorial.exception.model.CustomException;
import com.dummy.potter.rest_tutorial.response.ApiException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ApiException apiException =
                new ApiException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(
                ex, apiException, headers, apiException.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";
        ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), Collections.singletonList(error));
        return new ResponseEntity<>(apiException, new HttpHeaders(), apiException.getStatus());
    }

    @ExceptionHandler({ CustomException.class })
    public ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest request) {

        List<String> errors = new ArrayList<>();
        ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<>(apiException, new HttpHeaders(), apiException.getStatus());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request){
        List<String> errors = new ArrayList<>();
        ApiException apiException = new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<>(apiException, new HttpHeaders(), apiException.getStatus());
    }

}
