package dev.umang.productserviceexciteddec24.advices;

import dev.umang.productserviceexciteddec24.dtos.ErrorDto;
import dev.umang.productserviceexciteddec24.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvice1 {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> HandleProductNotFoundException(ProductNotFoundException productNotFoundException){

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(productNotFoundException.getMessage());

        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
