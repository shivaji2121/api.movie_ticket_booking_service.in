package com.movie.ticket.booking.handlers;


import com.movie.ticket.booking.dtos.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class BookingAPIHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        log.info(exception.getMessage());
        List<ObjectError> errors=exception.getBindingResult().getAllErrors();
        ResponseDto responseDto=ResponseDto.builder()
                .errorMessage(errors.get(0).getDefaultMessage())
                .build();
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
